package dev.blsalin.dic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomContainerImpl implements CustomContainer {
    private Map<String, Object> instances = new HashMap<>();
    private Map<String, Function<CustomContainer, ?>> factoryMethods = new HashMap<>();

    @Override
    public <T> boolean addInstance(T instance) throws NullParameterException, InstanceRedeclarationException {
        if (instance == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        String className = instance.getClass().getName();
        if (instances.containsKey(className)) {
            throw new InstanceRedeclarationException("Instances cannot be redeclared");
        }
        instances.put(className, instance);
        return true;
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) throws NullParameterException, InstanceRedeclarationException {
        if (instance == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        if (customName == null || customName.trim().isEmpty()) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        if (instances.containsKey(customName)) {
            throw new InstanceRedeclarationException("Instances cannot be redeclared");
        }
        instances.put(customName, instance);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        String className = type.getName();
        Object instance = instances.get(className);
        if (instance == null) {
            instance = create(type);
            if (instance == null) {
                throw new CannotProvideInstanceException("Cannot provide instance");
            }
            instances.put(className, instance);
        }
        return type.cast(instance);
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        Object instance = instances.get(customName);
        if (instance == null) {
            instance = create(type);
            if (instance == null) {
                throw new CannotProvideInstanceException("Cannot provide instance");
            }
            instances.put(customName, instance);
        } else if (!type.isInstance(instance)) {
            throw new InvalidTypeException("Invalid type for object");
        }
        return type.cast(instance);
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) throws NullParameterException, InstanceRedeclarationException {
        if (type == null || factoryMethod == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        String className = type.getName();
        if (factoryMethods.containsKey(className)) {
            throw new InstanceRedeclarationException("Factory method for this type already exists");
        }
        factoryMethods.put(className, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        if (type == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        Function<CustomContainer, ?> factoryMethod = factoryMethods.get(type.getName());
        if (factoryMethod == null) {
            throw new CannotProvideInstanceException("Cannot provide instance");
        }
        return type.cast(factoryMethod.apply(this));
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null || parameters == null) {
            throw new NullParameterException("Null is not allowed as a parameter");
        }
        Function<CustomContainer, ?> factoryMethod = factoryMethods.get(type.getName());
        if (factoryMethod == null) {
            throw new CannotProvideInstanceException("Cannot provide instance");
        }
        CustomContainer tempContainer = new CustomContainerImpl();
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            tempContainer.addInstance(entry.getValue(), entry.getKey());
        }
        return type.cast(factoryMethod.apply(tempContainer));
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) instance).close();
                } catch (Exception e) {
                    System.err.println("Failed to close resource: " + e.getMessage());
                }
            }
        }
        instances.clear();
        factoryMethods.clear();
    }
}

class InstanceRedeclarationException extends RuntimeException {
    public InstanceRedeclarationException(String message) {
        super(message);
    }
}

class NullParameterException extends RuntimeException {
    public NullParameterException(String message) {
        super(message);
    }
}

class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(String message) {
        super(message);
    }
}

class CannotProvideInstanceException extends RuntimeException {
    public CannotProvideInstanceException(String message) {
        super(message);
    }
}

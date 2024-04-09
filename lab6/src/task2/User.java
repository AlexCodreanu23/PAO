package task2;


import java.util.*;

public class User {
    private String name;

    private List<String>Subscriptions;

    public User(String name) {
        this.name = name;
        this.Subscriptions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

}

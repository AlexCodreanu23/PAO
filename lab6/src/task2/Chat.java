package task2;
import java.util.*;

public class Chat {
    private Map<String, List<User>> topicSubscriptions;
    private List<Message> messages;

    public Chat() {
        topicSubscriptions = new HashMap<>();
        messages = new ArrayList<>();
    }

    public void addUserToTopic(User user, String topic) {
        topicSubscriptions.putIfAbsent(topic, new ArrayList<>());
        List<User> subscribers = topicSubscriptions.get(topic);
        if (!subscribers.contains(user)) {
            subscribers.add(user);
        }
    }

    public void sendMessage(String sender, String topic, String content) {
        Message message = new Message(content, sender, topic);
        messages.add(message);
        notifySubscribers(message);
    }

    private void notifySubscribers(Message message) {
        String sender = message.getSender();
        String topic = message.getTopic();
        String content = message.getText();
        List<User> subscribers = topicSubscriptions.getOrDefault(topic, new ArrayList<>());
        for (User user : subscribers) {
            if (!user.getName().equals(sender)) {
                String notification = String.format("[%s] %s @ %s: %s", user.getName(), sender, topic, content);
                System.out.println(notification);
            }
        }
    }
}

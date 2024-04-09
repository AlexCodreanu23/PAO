package task2;

public class Message {
    private String text;
    private String sender;
    private String topic;

    public Message(String text, String sender, String topic) {
        this.text = text;
        this.sender = sender;
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public String getTopic() {
        return topic;
    }


}

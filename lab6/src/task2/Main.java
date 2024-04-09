package task2;

public class Main {
    public static void main(String[] args) {
        User adrian = new User("Adrian");
        User ion = new User("Ion");
        User maria = new User("Maria");
        User matei = new User("Matei");

        Chat chatRoom = new Chat();
        chatRoom.addUserToTopic(adrian, "gatit");
        chatRoom.addUserToTopic(maria, "gatit");
        chatRoom.addUserToTopic(adrian, "programare");
        chatRoom.addUserToTopic(ion, "programare");
        chatRoom.addUserToTopic(maria, "programare");
        chatRoom.addUserToTopic(matei, "programare");

        chatRoom.sendMessage("Ion", "programare", "Salutare!");
        chatRoom.sendMessage("Adrian", "gatit", "Omlette du fromage!");
    }
}

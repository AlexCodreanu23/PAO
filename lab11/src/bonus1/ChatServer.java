package bonus1;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clientHandlers = Collections.synchronizedSet(new HashSet<>());
    private static Map<String, Set<ClientHandler>> topicSubscribers = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        System.out.println("Server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected.");
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void broadcastMessage(String topic, String message, ClientHandler sender) {
        Set<ClientHandler> subscribers = topicSubscribers.get(topic);
        if (subscribers != null) {
            for (ClientHandler clientHandler : subscribers) {
                if (clientHandler != sender) {
                    clientHandler.sendMessage(message);
                }
            }
        }
    }

    static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
        topicSubscribers.values().forEach(subscribers -> subscribers.remove(clientHandler));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private String userName;
        private String subscribedTopic;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                this.out = out;
                out.println("Enter your name: ");
                this.userName = in.readLine();

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("SUBSCRIBE ")) {
                        String topic = message.substring(10);
                        this.subscribedTopic = topic;
                        topicSubscribers.computeIfAbsent(topic, k -> new HashSet<>()).add(this);
                        System.out.println(userName + " subscribed to " + topic);
                    } else if (message.equalsIgnoreCase("EXIT")) {
                        break;
                    } else {
                        String[] parts = message.split(": ", 2);
                        if (parts.length == 2) {
                            String topic = parts[0];
                            String content = parts[1];
                            String formattedMessage = String.format("[%s] %s @ %s: %s", topic, userName, topic, content);
                            System.out.println(formattedMessage);
                            broadcastMessage(topic, formattedMessage, this);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                removeClient(this);
                System.out.println("Client disconnected.");
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }
    }
}

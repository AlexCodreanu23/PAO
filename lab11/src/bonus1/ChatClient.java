package bonus1;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to chat server.");

            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            System.out.print("Enter your name: ");
            String userName = consoleIn.readLine();
            out.println(userName);

            System.out.print("Enter topic to subscribe: ");
            String topic = consoleIn.readLine();
            out.println("SUBSCRIBE " + topic);

            String userInput;
            while ((userInput = consoleIn.readLine()) != null) {
                if (userInput.equalsIgnoreCase("exit")) {
                    out.println("EXIT");
                    break;
                } else {
                    out.println(topic + ": " + userInput);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

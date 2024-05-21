package bonus2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatServer {
    private static final int PORT = 12345;
    private static final Map<SocketChannel, String> clientMap = new HashMap<>();

    public static void main(String[] args) {
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress(PORT));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server started...");

            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (!key.isValid()) {
                        continue;
                    }

                    if (key.isAcceptable()) {
                        acceptClient(selector, serverSocket);
                    } else if (key.isReadable()) {
                        readMessage(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptClient(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel client = serverSocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
        clientMap.put(client, "");
        client.write(ByteBuffer.wrap("Enter your name: ".getBytes()));
        System.out.println("New client connected.");
    }

    private static void readMessage(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        try {
            int numRead = client.read(buffer);
            if (numRead == -1) {
                clientMap.remove(client);
                client.close();
                System.out.println("Client disconnected.");
                return;
            }

            buffer.flip();
            String message = new String(buffer.array(), 0, buffer.limit()).trim();
            if (clientMap.get(client).isEmpty()) {
                clientMap.put(client, message);
                System.out.println("Client name set to: " + message);
            } else {
                String userName = clientMap.get(client);
                String formattedMessage = String.format("[%s] %s: %s", userName, userName, message);
                System.out.println(formattedMessage);
                broadcastMessage(formattedMessage, client);
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void broadcastMessage(String message, SocketChannel sender) {
        for (SocketChannel client : clientMap.keySet()) {
            if (client != sender) {
                try {
                    client.write(ByteBuffer.wrap(message.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

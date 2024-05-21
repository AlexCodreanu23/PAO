package bonus2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Selector selector = Selector.open();
             SocketChannel client = SocketChannel.open()) {
            client.configureBlocking(false);
            client.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));
            client.register(selector, SelectionKey.OP_CONNECT);

            Scanner scanner = new Scanner(System.in);



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

                    if (key.isConnectable()) {
                        finishConnection(key);
                    } else if (key.isReadable()) {
                        readMessage(key);
                    }
                }

                if (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                    client.write(ByteBuffer.wrap(message.getBytes()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void finishConnection(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        try {
            client.finishConnect();
        } catch (IOException e) {
            key.cancel();
            return;
        }
        client.register(key.selector(), SelectionKey.OP_READ);
        System.out.println("Connected to chat server.");
    }

    private static void readMessage(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        try {
            int numRead = client.read(buffer);
            if (numRead == -1) {
                client.close();
                return;
            }
            String message = new String(buffer.array()).trim();
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
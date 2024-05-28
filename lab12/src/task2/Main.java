package task2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void getResourceById(int id) {
        try {
            URI uri = new URI(BASE_URL + "/" + id);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

            System.out.println("GET Response:");
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void createResource() {
        try {
            ObjectNode newPost = objectMapper.createObjectNode();
            newPost.put("title", "foo");
            newPost.put("body", "bar");
            newPost.put("userId", 1);

            String requestBody = objectMapper.writeValueAsString(newPost);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

            System.out.println("POST Request Body:");
            System.out.println(requestBody);

            System.out.println("POST Response:");
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int randomId = random.nextInt(100) + 1;
        getResourceById(randomId);

        createResource();
    }
}

package co.edu.uptc.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ReadFromURL {

    public static String getFileFromURL(String fileUrl) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fileUrl))
                .build();
        HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.body()))) {
            char[] buffer = new char[8192];
            int bytesRead;
            while ((bytesRead = reader.read(buffer, 0, buffer.length)) != -1) {
                content.append(buffer, 0, bytesRead);
            }
        }
        return content.toString();
    }

    public static <T> T getJsonFromURL(String fileUrl, Class<T> valueType) throws Exception {
        String jsonContent = getFileFromURL(fileUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonContent, valueType);
    }
}
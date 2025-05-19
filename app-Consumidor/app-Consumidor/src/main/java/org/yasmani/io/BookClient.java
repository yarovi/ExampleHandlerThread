package org.yasmani.io;

import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BookClient {

    private  HttpClient clientBook;

    private static final String BASE_URL = "http://localhost:8080/api/books";

    public void createRequest() throws IOException {
        try {
            clientBook = HttpClient.New(URI.create("http://localhost:8080/api/books").toURL());

            ExecutorService executor = Executors.newFixedThreadPool(3);

            Runnable createBookTask = () -> {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(BASE_URL))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString("{\"title\":\"Book Title\",\"author\":\"Author Name\",\"year\":2023}"))
                            .build();

                    HttpResponse<String> response = clientBook.send(request, HttpResponse.BodyHandlers.ofString());
                    System.out.println("Response: " + response.body());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            for (int i = 0; i < 3; i++) {
                executor.submit(createBookTask);
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

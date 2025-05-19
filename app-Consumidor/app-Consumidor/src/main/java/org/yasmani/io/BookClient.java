package org.yasmani.io;

import java.net.http.HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BookClient {

    Logger logger = Logger.getLogger( BookClient.class.getName() );
    private  HttpClient clientBook=HttpClient.newHttpClient();

    private static final String BASE_URL = "http://localhost:8080/api/books";


    public BookClient() {
    }

    public void createRequest() throws IOException {
        try {

            ExecutorService executor = Executors.newFixedThreadPool(3);
            logger.info( "Creating request..." );
            Runnable createBookTask = () -> {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(BASE_URL))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString("{\"title\":\"Book Title\",\"author\":\"Author Name\",\"year\":2023}"))
                            .build();

                    HttpResponse<String> response = clientBook.send(request, HttpResponse.BodyHandlers.ofString());
                    logger.info("Response: " + response.body());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.severe("Error: " + e.getMessage());
                }
            };

            for (int i = 0; i < 3; i++) {
                executor.submit(createBookTask);
                logger.info( "Created request... {}");
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }catch (InterruptedException e) {
            e.printStackTrace();
            logger.severe("Error: " + e.getMessage());
        }
    }
}

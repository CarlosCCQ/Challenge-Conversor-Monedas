package service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consumir_Api {

    private final String api_Key;

    public Consumir_Api(String api_Key) {
        if (api_Key == null || api_Key.isEmpty()) {
            throw new NullPointerException("API Key cannot be null or empty");
        }
        this.api_Key = api_Key;
    }

    public String getRequest(String baseCurrency) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + api_Key + "/latest/" + baseCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(java.net.URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

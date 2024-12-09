package com.alumbo.currencyconverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyAPI {
    private static final String API_KEY = "05da0881db27cd0b78e1690c";

    // Método para obtener las tasas de cambio
    public static JsonObject getExchangeRates() throws Exception {
        String url = "https://api.exchangerate-api.com/v4/latest/USD?api_key=05da0881db27cd0b78e1690c";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

            if (jsonResponse.has("rates") && jsonResponse.get("rates").isJsonObject()) {
                return jsonResponse;
            } else {
                throw new Exception("No 'rates' found in the response.");
            }
        } else {
            throw new Exception("Failed to get exchange rates. HTTP error code: " + response.statusCode());
        }
    }
}
package org.example;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;

public class WeatherApiClient {
    private final String apiKey;

    public WeatherApiClient(String apiKey) {
        this.apiKey = ApiKey.API_KEY;
    }

    public WeatherData getWeatherData(String city) throws IOException, ParseException {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = apiUrl + "?q=" + city + "&appid=" + ApiKey.API_KEY;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        String jsonResponse = EntityUtils.toString(((CloseableHttpResponse) response).getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            WeatherData weatherData = objectMapper.readValue(jsonResponse, WeatherData.class);
            return weatherData;
        } catch (JsonMappingException e) {
            throw new IOException("Failed to map JSON response to WeatherData", e);
        }
    }
}

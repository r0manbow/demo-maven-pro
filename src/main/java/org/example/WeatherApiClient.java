package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class WeatherApiClient {
    private final String apiKey;

    public WeatherApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public WeatherData getWeatherData(String city) throws IOException, IOException, ParseException {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        //String apiKey = "c14c6e69e8cc00dabc35167a1ab8cc02";
        //String city = "lat=44.34&lon=10.99";
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        String jsonResponse = EntityUtils.toString(((CloseableHttpResponse) response).getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(jsonResponse, WeatherData.class);

        return weatherData;
    }
}

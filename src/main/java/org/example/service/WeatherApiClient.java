package org.example.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.constant.ApiKey;
import org.example.constant.Lang;
import org.example.constant.Units;
import org.example.dto.WeatherData;


import java.io.IOException;

public class WeatherApiClient {
    private final String apiKey;

    public WeatherApiClient(String apiKey) {
        this.apiKey = ApiKey.API_KEY;
    }

    public WeatherData getWeatherData(String city) throws IOException, ParseException {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = apiUrl + "?q=" + city + "&lang=" + Lang.RU + "&appid=" + ApiKey.API_KEY + "&units=" + Units.METRIC;
        //System.out.println(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String jsonResponse = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonResponse, WeatherData.class);
        } catch (JsonMappingException e) {
            throw new IOException("Failed to map JSON response to WeatherData", e);
        }
    }
}

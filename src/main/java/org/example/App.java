package org.example;


import org.apache.http.ParseException;
import org.example.constant.ApiKey;
import org.example.dto.WeatherData;
import org.example.service.WeatherApiClient;

import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        // Получаем от пользователя название города
        System.out.print("Введите название города латинскими буквами без специальных знаков: ");
        String city = scanner.nextLine();
        String cityEdited = city.replace(" ", "+");

        // Создаем объект класса WeatherApiClient
        WeatherApiClient weatherApiClient = new WeatherApiClient(ApiKey.API_KEY);

        // Выполняем запрос к API и получаем данные о погоде
        WeatherData weatherData = weatherApiClient.getWeatherData(cityEdited);

        // Выводим информацию о погоде на экран
        System.out.println("--------------------------------------------------------");
        System.out.println("Погода в городе " + weatherData.getName() + ", страна "+ weatherData.getSys().getCountry() + " в настоящее время:");
        System.out.println("Температура: " + weatherData.getMain().getTemp() + "°C");
        System.out.println("Описание: " + weatherData.getWeather()[0].getDescription());

        // Закрываем сканнер
        scanner.close();
    }
}

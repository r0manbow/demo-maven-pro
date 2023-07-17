package org.example;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        // Получаем от пользователя название города
        System.out.print("Введите название города: ");
        String city = scanner.nextLine();

        // Создаем объект класса WeatherApiClient
        WeatherApiClient weatherApiClient = new WeatherApiClient("c14c6e69e8cc00dabc35167a1ab8cc02");

        // Выполняем запрос к API и получаем данные о погоде
        WeatherData weatherData = weatherApiClient.getWeatherData(city);

        // Выводим информацию о погоде на экран
        System.out.println("Погода в городе " + weatherData.getCity() + ":");
        System.out.println("Температура: " + weatherData.getTemperature() + "°C");
        System.out.println("Описание: " + weatherData.getDescription());

        // Закрываем сканнер
        scanner.close();
    }
}

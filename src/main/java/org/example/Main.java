package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    private double feels_like;
    private double temp;
    private int pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;
    private int sea_level;
    private int grnd_level;

    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }
    @JsonProperty("feels_like")
    public double getFeelsLike() {
        return feels_like;
    }
    @JsonProperty("feels_like")
    public void setFeelsLike(double feels_like) {
        this.feels_like = feels_like;
    }
    @JsonProperty("temp_min")
    public double getTempMin() {
        return temp_min;
    }
    @JsonProperty("temp_min")
    public void setTempMin(double temp_min) {
        this.temp_min = temp_min;
    }
    @JsonProperty("temp_max")
    public double getTempMax() {
        return temp_max;
    }
    @JsonProperty("temp_max")
    public void setTempMax(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    @JsonProperty("sea_level")
    public int getSeaLevel() {
        return sea_level;
    }
    @JsonProperty("sea_level")
    public void setSeaLevel(int sea_level) {
        this.sea_level = sea_level;
    }
    @JsonProperty("grnd_level")
    public int getGroundLevel() {return grnd_level;}
    @JsonProperty("grnd_level")
    public void setGroundLevel(int grnd_level) {
        this.grnd_level = grnd_level;
    }

}

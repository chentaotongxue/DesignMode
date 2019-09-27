package com.roadrover.designmode.observerpattern;

/**
 * Created by chentao on 2018/7/31.
 */

public class ForecastDisplay implements Observer1, DisplayElement {

    private float temperature;
    private float humidity;

    public ForecastDisplay(){
    }

    @Override
    public void display() {
        System.out.println("ForecastDisplay conditions: " + temperature
        +"F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}

package com.roadrover.designmode.observerpattern;

/**
 * Created by chentao on 2018/7/31.
 */

public class StatisticsDisplay implements Observer1, DisplayElement {

    private float temperature;
    private float humidity;

    public StatisticsDisplay(){
    }
    @Override
    public void display() {
        System.out.println("StatisticsDisplay conditions: " + temperature
        +"F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}

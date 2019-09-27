package com.roadrover.designmode.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao on 2018/7/31.
 */

public class WeatherData implements Subject1 {

    private List observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer1 o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer1 o) {
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer1 observer1 = (Observer1)observers.get(i);
            observer1.update(temperature, humidity, pressure);
        }
    }


    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }
}

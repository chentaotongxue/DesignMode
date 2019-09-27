package com.roadrover.designmode.observerpattern;

/**
 * Created by chentao on 2018/7/31.
 */

public interface Subject1 {

    void registerObserver(Observer1 o);
    void removeObserver(Observer1 o);
    void notifyObservers();
}

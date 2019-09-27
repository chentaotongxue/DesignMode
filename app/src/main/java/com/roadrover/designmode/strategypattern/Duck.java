package com.roadrover.designmode.strategypattern;

import com.roadrover.designmode.strategypattern.FlyBehavior;
import com.roadrover.designmode.strategypattern.QuackBehavior;

/**
 * Created by chentao on 2018/7/30.
 */

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }
}

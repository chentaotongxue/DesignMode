package com.roadrover.designmode.strategypattern;

/**
 * Created by chentao on 2018/7/30.
 */

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am a real Mallard duck!!");
    }
}

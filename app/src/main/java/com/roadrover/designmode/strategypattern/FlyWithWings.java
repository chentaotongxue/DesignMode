package com.roadrover.designmode.strategypattern;

import com.roadrover.designmode.strategypattern.FlyBehavior;

/**
 * Created by chentao on 2018/7/30.
 */

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I am fly!!");
    }
}

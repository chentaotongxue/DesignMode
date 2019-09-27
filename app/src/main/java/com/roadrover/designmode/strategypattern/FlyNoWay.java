package com.roadrover.designmode.strategypattern;

import com.roadrover.designmode.strategypattern.FlyBehavior;

/**
 * Created by chentao on 2018/7/30.
 */

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can not fly!!");
    }
}

package com.roadrover.designmode.strategypattern;

import com.roadrover.designmode.strategypattern.QuackBehavior;

/**
 * Created by chentao on 2018/7/30.
 */

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<<Silence>>");
    }
}

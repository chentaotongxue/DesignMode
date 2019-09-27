package com.roadrover.designmode.decoratorpattern;

/**
 * Created by chentao on 2018/8/14.
 * 具体的装饰者对象
 */

public class ManDecoratorA extends Decorator {

    @Override
    public void eat() {
        super.eat();
        System.out.println("ManDecoratorA类");
    }
}

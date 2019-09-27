package com.roadrover.designmode.decoratorpattern;

/**
 * Created by chentao on 2018/8/14.
 * 具体被装饰对象
 */

public class Man implements Person {
    @Override
    public void eat() {
        System.out.println("男人在吃");
    }
}

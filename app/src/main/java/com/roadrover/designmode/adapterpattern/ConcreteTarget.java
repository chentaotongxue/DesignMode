package com.roadrover.designmode.adapterpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public class ConcreteTarget implements Target {
    @Override
    public void request() {
       System.out.println("普通类 具有 普通功能...");
    }
}

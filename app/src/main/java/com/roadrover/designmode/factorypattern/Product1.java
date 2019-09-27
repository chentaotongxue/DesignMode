package com.roadrover.designmode.factorypattern;

/**
 * Created by chentao on 2018/8/14.
 */

public class Product1 implements IProduct1 {
    @Override
    public void show() {
        System.out.println("这是1型产品");
    }
}

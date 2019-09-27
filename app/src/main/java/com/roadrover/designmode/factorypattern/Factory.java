package com.roadrover.designmode.factorypattern;

/**
 * Created by chentao on 2018/8/14.
 */

public class Factory implements IFactory {
    @Override
    public IProduct1 createProduct1() {
        return new Product1();
    }

    @Override
    public IProduct2 createProduct2() {
        return new Product2();
    }
}

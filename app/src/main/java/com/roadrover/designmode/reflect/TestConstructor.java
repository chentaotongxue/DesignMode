package com.roadrover.designmode.reflect;

/**
 * Created by chentao on 2018/8/22.
 */

public class TestConstructor {
    private String self;
    public TestConstructor(){
        self = " Frank";
    }
    public TestConstructor(String self){
        this.self = self;
    }

    @Override
    public String toString() {
        return "TestConstructor [self = "+self+"]";
    }
}

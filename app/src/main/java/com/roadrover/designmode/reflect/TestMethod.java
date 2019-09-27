package com.roadrover.designmode.reflect;

/**
 * Created by chentao on 2018/8/22.
 */

public class TestMethod {
    public static void testStatic(){
        System.out.println("test static");
    }

    private int add(int a, int b){
        return a+b;
    }

    public void testException()throws IllegalAccessException{
        throw new IllegalAccessException("You have some problem.");
    }
}

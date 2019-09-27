package com.roadrover.designmode.singletonpattern;

/**
 * Created by chentao on 2018/8/17.
 */

public class MyClass {

    private int i;
    private static MyClass instance = new MyClass();;
    public static MyClass getInstance(){
        return instance;
    }

    private MyClass(){
        System.out.println(i++);
    }


}

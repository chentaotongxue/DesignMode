package com.roadrover.designmode.reflect;

import java.lang.reflect.Type;

/**
 * Created by chentao on 2018/8/21.
 */

public class A implements Type{
    public int a;
    private int b;

    public int getB(){
        return b;
    }
    public void setB(int b){
        this.b = b;
    }
}

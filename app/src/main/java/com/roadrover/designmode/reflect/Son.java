package com.roadrover.designmode.reflect;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chentao on 2018/8/20.
 */

public class Son extends Farther {
    int c;
    private String d;
    protected float e;

    public List<Car> cars;
    public HashMap<Integer, String> map;


    public Son(){
        super();
    }

    public Son(int c, String d){
        super();
        this.c = c;
        this.d = d;
    }
}

package com.roadrover.designmode.reflect;

import android.graphics.Color;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chentao on 2018/8/20.
 */

public class Car {

    private String mBand;
    private Color mColor;
    public enum Color{RED, WHITE, BLACK, BLUE, YELLOR}

    public static class Inner{}

    public Car(){
        super();
    }

    public Car(String mBand){
        this.mBand = mBand;
    }

    public void drive(){
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString() {
        return "Car [mBand="+mBand+", mColor="+mColor+"]";
    }

    public void test(String[] paraa, List<String> b, HashMap<Integer, Son> maps){}
}

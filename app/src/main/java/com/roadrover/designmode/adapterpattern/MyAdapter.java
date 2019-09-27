package com.roadrover.designmode.adapterpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public class MyAdapter extends Usber implements Ps2 {
    @Override
    public void isPs2() {
        isUsb();
    }
}

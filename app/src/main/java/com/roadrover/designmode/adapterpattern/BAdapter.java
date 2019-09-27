package com.roadrover.designmode.adapterpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public class BAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}

package com.roadrover.designmode.adapterpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public class Usber implements Usb {
    @Override
    public void isUsb() {
        System.out.println("USB interface!");
    }
}

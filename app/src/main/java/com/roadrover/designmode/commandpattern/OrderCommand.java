package com.roadrover.designmode.commandpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public class OrderCommand implements Command {

    private CookReceiver cook;

    public OrderCommand(CookReceiver cook){
        this.cook = cook;

    }
    @Override
    public void execute() {
        cook.cooking();
    }

    @Override
    public void undo() {
        cook.unCooking();
    }
}

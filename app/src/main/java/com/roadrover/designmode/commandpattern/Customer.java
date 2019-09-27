package com.roadrover.designmode.commandpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public class Customer {
    private Command command;
    public Customer(Command command){
        this.command = command;
    }

    public void order(){
        command.execute();
    }
    public void unOrder(){
        command.undo();
    }
}

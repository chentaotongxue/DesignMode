package com.roadrover.designmode.commandpattern;

/**
 * Created by chentao on 2018/8/28.
 */

public interface Command {
    public void execute();
    public void undo();
}

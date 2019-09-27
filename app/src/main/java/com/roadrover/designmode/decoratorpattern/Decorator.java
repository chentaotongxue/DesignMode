package com.roadrover.designmode.decoratorpattern;

/**
 * Created by chentao on 2018/8/14.
 * 装饰者抽象类
 */

public class Decorator implements Person {

    protected Person mPerson;
    public void setPerson(Person person){
        this.mPerson = person;
    }
    @Override
    public void eat() {
        if(null != mPerson){
            mPerson.eat();
        }
    }
}

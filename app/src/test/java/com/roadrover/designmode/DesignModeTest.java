package com.roadrover.designmode;

import com.roadrover.designmode.adapterpattern.Adaptee;
import com.roadrover.designmode.adapterpattern.BAdapter;
import com.roadrover.designmode.adapterpattern.ConcreteTarget;
import com.roadrover.designmode.adapterpattern.MyAdapter;
import com.roadrover.designmode.adapterpattern.Ps2;
import com.roadrover.designmode.adapterpattern.Target;
import com.roadrover.designmode.commandpattern.Command;
import com.roadrover.designmode.commandpattern.CookReceiver;
import com.roadrover.designmode.commandpattern.Customer;
import com.roadrover.designmode.commandpattern.OrderCommand;
import com.roadrover.designmode.decoratorpattern.Decorator;
import com.roadrover.designmode.decoratorpattern.Man;
import com.roadrover.designmode.decoratorpattern.ManDecoratorA;
import com.roadrover.designmode.decoratorpattern.ManDecoratorB;
import com.roadrover.designmode.decoratorpattern.ManDecoratorC;
import com.roadrover.designmode.decoratorpattern.Person;
import com.roadrover.designmode.factorypattern.Factory;
import com.roadrover.designmode.factorypattern.IFactory;
import com.roadrover.designmode.mediator.CDDriver;
import com.roadrover.designmode.mediator.CPU;
import com.roadrover.designmode.mediator.MainBoard;
import com.roadrover.designmode.mediator.SoundCard;
import com.roadrover.designmode.mediator.VideoCard;
import com.roadrover.designmode.observerpattern.CurrentConditionsDisplay;
import com.roadrover.designmode.observerpattern.ForecastDisplay;
import com.roadrover.designmode.observerpattern.StatisticsDisplay;
import com.roadrover.designmode.observerpattern.WeatherData;
import com.roadrover.designmode.singletonpattern.MyClass;
import com.roadrover.designmode.strategypattern.Duck;
import com.roadrover.designmode.strategypattern.MallardDuck;

import org.junit.Test;

/**
 * Created by chentao on 2018/7/31.
 */

public class DesignModeTest {

    /**
     * 策略模式
     *
     */
    @Test
    public void strategy(){
        Duck duck = new MallardDuck();
        duck.performFly();
    }
    /**
     * 观察者模式
     *
     */
    @Test
    public void observer(){

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        WeatherData weatherData = new WeatherData();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);


        weatherData.setMeasurements(80, 65, 30.4f);

    }

    /**
     * 装饰模式
     */
    @Test
    public void decorator(){
        Person man = new Man();

        Decorator md1 = new ManDecoratorA();
        md1.setPerson(man);

        Decorator md2 = new ManDecoratorB();
        md2.setPerson(md1);

        Decorator md3 = new ManDecoratorC();
        md3.setPerson(md2);
        md3.eat();
    }

    /**
     * 工厂模式
     */
    @Test
    public void factory(){
        IFactory factory = new Factory();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }

    /**
     * 单件模式
     */
    @Test
    public void single(){
        MyClass.getInstance();
    }

    /**
     * 命令模式
     *
     */
    @Test
    public void command(){
        CookReceiver receiver = new CookReceiver();
        Command cmd = new OrderCommand(receiver);
        Customer customer = new Customer(cmd);

        customer.order();
        customer.unOrder();
    }

    /**
     * 适配器模式
     */
    @Test
    public void adapter(){
        Ps2 ps = new MyAdapter();
        ps.isPs2();

        Target concteteTarget = new ConcreteTarget();
        concteteTarget.request();

        Target adapter = new BAdapter();
        adapter.request();
    }

    /**
     * 中介模式
     */
    @Test
    public void mediator(){
        //创建调停者--主板
        MainBoard mediator = new MainBoard();

        //创建同事类
        CDDriver cd = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard vc = new VideoCard(mediator);
        SoundCard sc = new SoundCard(mediator);

        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(vc);
        mediator.setSoundCard(sc);

        //开始看电影，把光盘放入光驱，光驱开始读盘
        cd.readCD();

    }
}


























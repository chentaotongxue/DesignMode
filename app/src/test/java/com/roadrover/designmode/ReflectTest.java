package com.roadrover.designmode;

import com.roadrover.designmode.reflect.A;
import com.roadrover.designmode.reflect.AutoDrive;
import com.roadrover.designmode.reflect.Car;
import com.roadrover.designmode.reflect.Farther;
import com.roadrover.designmode.reflect.Shuzu;
import com.roadrover.designmode.reflect.Son;
import com.roadrover.designmode.reflect.TestConstructor;
import com.roadrover.designmode.reflect.TestMethod;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * Created by chentao on 2018/8/21.
 */

public class ReflectTest {
    /**
     * Android反射机制
     */
    @Test
    public void reflect1(){
        try {
            Class clz = Class.forName("com.roadrover.designmode.reflect.Car");
            Class clz1 = float.class;
            Class clz2 = Void.class;
            Class clz3 = new int[]{}.getClass();
            Class clz4 = new Car[]{}.getClass();

            System.out.println(clz.getName());
            System.out.println(clz1.getName());
            System.out.println(clz2.getName());
            System.out.println(clz3.getName());
            System.out.println(clz4.getName());

            System.out.println(Car.Inner.class.getName());
            System.out.println(" Inner Class name:"+new Car.Inner[][][]{}.getClass().getName());
            System.out.println(" Inner Class simple name:"+new Car.Inner[][][]{}.getClass().getSimpleName());
            System.out.println(" Inner Class canonical name:"+new Car.Inner[][][]{}.getClass().getCanonicalName());

            Runnable run = new Runnable() {
                @Override
                public void run() {

                }
            };
            System.out.println(" anonymous Class name:"+run.getClass().getName());
            System.out.println(" anonymous Class simple name:"+run.getClass().getSimpleName());
            System.out.println(" anonymous Class canonical name:"+run.getClass().getCanonicalName());

            // local 是局部类
            class local{};
            System.out.println("Local a name:"+local.class.getName());
            System.out.println("Local a simplename:"+local.class.getSimpleName());
            System.out.println("Local a canonicalname:"+local.class.getCanonicalName());

            System.out.println("modifiers value:"+ Car.class.getModifiers());
            System.out.println("modifiers:"+ Modifier.toString(Car.class.getModifiers()));
            System.out.println("isAbstract:"+ Modifier.isAbstract(Car.class.getModifiers()));

            Field[] fields = Car.class.getDeclaredFields();
            for(Field field : fields){
                System.out.println("field:"+field.toString());
            }

            Class cls = Son.class;
            Field field = cls.getDeclaredField("c"); //getDeclaredField不能获取父类方法

            Field field1 = cls.getField("b");

            Field[] fields1 = cls.getDeclaredFields();
            for(Field f : fields1){
                System.out.println("Field:"+f.getName());
            }

            Constructor[] constructors = cls.getConstructors();
            for(Constructor c : constructors){
                System.out.println("getConstructor:"+c.toString());
            }

            constructors = cls.getDeclaredConstructors();
            for(Constructor c : constructors){
                System.out.println("getDeclaredConstructors:"+c.toString());
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("getDeclaredField "+e.getMessage());
        } catch (SecurityException e) {
            e.printStackTrace();
            System.out.println("getDeclaredField "+e.getMessage());
        }

    }

    /**
     * Android反射2
     */
    @Test
    public void reflect2(){
        Class cls = Farther.class;
        Field[] field2 = cls.getFields();
        for(Field f : field2){
            System.out.println("Field :"+f.getName());
            System.out.println("Field type:"+f.getType());
            System.out.println("Field generic type:"+f.getGenericType());
            System.out.println("-------------------");
        }

        A testa = new A();
        testa.a = 10;
        System.out.println("testa.a = "+testa.a);

        Class c = A.class;
        try{
            Field fielda = c.getField("a");
            int ra = fielda.getInt(testa);
            System.out.println("reflection testa.a = "+ra);

            fielda.setInt(testa, 15);
            System.out.println("testa.a = "+testa.a);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Android反射3
     */
    @Test
    public void reflect3(){
        A testa = new A();
        testa.setB(3);
        System.out.println("testa.b = "+testa.getB());
        Class c = A.class;
        try{
            Field fieldb = c.getDeclaredField("b");
            fieldb.setAccessible(true);
            int rb = fieldb.getInt(testa);
            System.out.println("reflection testa.a = "+rb);

            fieldb.setInt(testa, 20);
            System.out.println("testa.b = "+testa.getB());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Android反射4
     * Method获取方法名
     */
    @Test
    public void reflect4(){
        Car car = new Car();
        Class clz = car.getClass();
        Method methods[] = clz.getDeclaredMethods();
        for(Method m : methods){
            System.out.println("method name:"+m.getName());
            System.out.println("method Modifiers:"+m.getModifiers());
            System.out.println("--------------------");
        }

        Class clz2 = car.getClass();
        Method methods2[] = clz.getDeclaredMethods();
        for(Method m : methods2){
            System.out.println("method name:"+m.getName());
            Parameter[] paras = m.getParameters();
            for(Parameter p : paras){
                System.out.println("parameter:"+p.getName()+p.getType().getName());
            }
            Class[] pTypes = m.getParameterTypes();
            System.out.println("method para types:");
            for(Class type :pTypes){
                System.out.print(""+type.getName());
            }
            System.out.println();
            Type[] gTypes = m.getGenericParameterTypes();
            System.out.println("method para generic types:");
//            for(Type type :gTypes){
//                System.out.print(" "+ type.getTypeName());
//            }
            System.out.println();
            System.out.println("==========================================");
        }
    }

    /**
     * Android反射5
     * invoke方法是用
     */
    @Test
    public void reflect5(){

        Class testCls = TestMethod.class;
        try {
            Method mStatic = testCls.getMethod("testStatic", null);
            mStatic.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        TestMethod t = new TestMethod();
        try {
            Method mAdd = testCls.getDeclaredMethod("add", int.class, int.class);
            mAdd.setAccessible(true);
            int result = (int)mAdd.invoke(t, 1,2);
            System.out.println("add method result:"+result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Method testExcep = testCls.getMethod("testException", null);
            testExcep.invoke(t, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();?
            System.out.println("testException occur some error,Error type is :"+e.getCause().getClass().getName());
            System.out.println("Error message is :"+e.getCause().getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     *Android反射6
     *访问构造方法
     */
    @Test
    public void reflect6(){
        Class clz = TestConstructor.class;
        try {
            TestConstructor test1 = (TestConstructor)clz.newInstance();
            System.out.println(test1.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Constructor con = clz.getConstructor(String.class);
            TestConstructor test2 = (TestConstructor) con.newInstance("Zhao");
            System.out.println(test2.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *Android反射7
     *获取数组里面的元素类型
     */
    @Test
    public void reflect7(){
        Class clz = Shuzu.class;
        Field[] fields = clz.getDeclaredFields();
        for(Field f : fields){
            Class c = f.getType();
            if(c.isArray()){
                System.out.println("Type is "+c.getName());
                System.out.println("ComponentType type is :"+c.getComponentType());
            }
        }
    }

    /**
     * Android反射8
     *
     */
    @Test
    public void reflect8(){
        Class clz = Shuzu.class;
        try {
            Shuzu shu = (Shuzu) clz.newInstance();
            Field arrayF = clz.getDeclaredField("array");
            arrayF.setAccessible(true);

            Object o = Array.newInstance(int.class, 3);
            Array.set(o, 0, 1);
            Array.set(o, 1, 3);
            Array.set(o, 2, 5);
            arrayF.set(shu, o);
//            int[] array = shu.get();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * Android反射9
     *
     */
    @Test
    public void reflect9(){
        AutoDrive car = new AutoDrive();
        car.drive();

        Class cls = AutoDrive.class;
        try {
            Constructor cons = cls.getConstructor(String.class,AutoDrive.Color.class);

            // 利用反射技术创建 AutoDrive 对象
            AutoDrive autoDrive = (AutoDrive) cons.newInstance("Tesla",AutoDrive.Color.RED);

            // 获取能够驱动汽车的 drive 方法
            Method method = cls.getMethod("drive");

            System.out.println("=====================\n自动驾驶马上开始\n================");
            // 通过反射调用 Method 方法，最终车子跑去起来
            method.invoke(autoDrive, null);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        long time = System.nanoTime();
        long time2 = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("delay = "+ (System.nanoTime() - time));
        System.out.println("time2 = "+ (System.currentTimeMillis() - time2));
    }

}










































































































































































































































































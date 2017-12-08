package com.little.designpatternapp.strategy_pattern;

import android.util.Log;

/**
 * Created by Littlezuo on 2017/11/28.
 * 橡皮鸭子
 */

public class RubberDuck extends Duck implements FlyBehavior {
    //    @Override
    //    public void quack() {
    //        Log.e("kkkk", "吱吱叫");
    //    }

    /**
     * 构造代码块,每次在创建对象的时候都会被调用,优先于构造函数实现
     */ {
        //        mFlyBehavior = this;
        //        mQuackBehavior = this;
        setFlyBehavior(this);
        setQuackBehavior(new MyQuackBehavior());
    }

    public RubberDuck() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void display() {
        Log.e("kkkk", "橡皮鸭子");
    }

    @Override
    public void fly() {
        //        mFlyBehavior.fly();
        Log.e("kkkk", "不会飞呀");
    }

//    @Override
    //    public void quack() {
    //
    //    }

    //    @Override
    //    public void fly() {
    //
    //    }
}

package com.little.designpatternapp.strategy_pattern;

import android.util.Log;

/**
 * Created by Littlezuo on 2017/11/28.
 */

public abstract class Duck /*implements FlyBehavior*/ {

    //    public abstract void quack();

    /**
     * 游泳
     */
    public abstract void swim();

    /**
     * 外观
     */
    public abstract void display();

    private FlyBehavior mFlyBehavior;

    public void performFly() {
        Log.e("kkkk", "performFly");
        if (mFlyBehavior == null)
            return;
        mFlyBehavior.fly();
    }

    private QuackBehavior mQuackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        mFlyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        mQuackBehavior = quackBehavior;
    }

    /**
     * 叫
     */
    public void preformQuack() {
        if (mQuackBehavior == null)
            return;
        mQuackBehavior.quack();
    }
}

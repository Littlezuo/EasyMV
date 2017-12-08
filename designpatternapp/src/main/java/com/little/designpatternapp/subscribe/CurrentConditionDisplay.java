package com.little.designpatternapp.subscribe;

import android.util.Log;

/**
 * Created by Littlezuo on 2017/11/30.
 */

public class CurrentConditionDisplay implements MyObserver<String>, DisplayElement {
    private final MySubject<String> WeatherData;
    private String temperature;

    public CurrentConditionDisplay(MySubject<String> weatcherData) {
        this.WeatherData = weatcherData;
        weatcherData.registerObserver(this);
    }


    //    @Override
//    public void update(String temperature) {
//        this.temperature = temperature;
//        display();
//    }

    @Override
    public void display() {
        Log.e("kkkk", temperature + " ");
    }

    @Override
    public void update(MySubject<String> subject) {

    }
}

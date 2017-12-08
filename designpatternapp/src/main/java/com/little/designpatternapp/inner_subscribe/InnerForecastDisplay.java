package com.little.designpatternapp.inner_subscribe;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Littlezuo on 2017/11/30.
 */

public class InnerForecastDisplay implements Observer {
    private String pressure;

    public InnerForecastDisplay(InnerWeatherData innerWeatherData) {
        innerWeatherData.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        this.pressure = ((InnerWeatherData) observable).getPressure();
        display();
    }

    private void display() {
        Log.e("kkkk", "pressure == " + pressure);
    }
}

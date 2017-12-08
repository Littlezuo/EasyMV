package com.little.designpatternapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.little.designpatternapp.inner_subscribe.InnerForecastDisplay;
import com.little.designpatternapp.inner_subscribe.InnerWeatherData;
import com.little.designpatternapp.strategy_pattern.Duck;
import com.little.designpatternapp.strategy_pattern.RubberDuck;
import com.little.designpatternapp.subscribe.CurrentConditionDisplay;
import com.little.designpatternapp.subscribe.WeatherData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        strategyPattern();//策略模式
        //        observerPattern();//自己写的观察者模式
        innerObserverPattern();//java内置的观察者模式


    }

    private void innerObserverPattern() {
        boolean b = new TestBean("2").text == "2";
        Log.e("kkkk", b + " = b");
        boolean c = new String("2") == new String("2");
        Log.e("kkkk", c + " = c");
        InnerWeatherData innerWeatherData = new InnerWeatherData();
        InnerForecastDisplay forecastDisplay = new InnerForecastDisplay(innerWeatherData);
        innerWeatherData.addObserver(forecastDisplay);
        innerWeatherData.setPressure("change1");
        innerWeatherData.setPressure("change2");
    }

    private void observerPattern() {
        WeatherData<String> stringWeatherData = new WeatherData<>();
        stringWeatherData.setTempearture("10度");
        CurrentConditionDisplay display = new CurrentConditionDisplay(stringWeatherData);
        display.display();
        Log.e("kkkk", "----------------");
        stringWeatherData.setInfo("333", "444", "555");
        stringWeatherData.setInfo("666", "777", "888");
    }

    private void strategyPattern() {
        Duck duck = new RubberDuck();
        duck.performFly();
    }
}

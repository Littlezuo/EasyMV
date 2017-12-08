package com.little.designpatternapp.inner_subscribe;

import java.util.Observable;

/**
 * Created by Littlezuo on 2017/11/30.
 */

public class InnerWeatherData extends Observable {

    //    private ArrayList<Observer> mObservers;

    {
        //        mObservers = new ArrayList<>();
        //        addObserver();
    }

    private String pressure;

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
        setChanged();
        notifyObservers();
    }


    //    @Override
    //    public synchronized void addObserver(Observer o) {
    //        super.addObserver(o);
    //        mObservers.add(o);
    //    }
    //
    //    @Override
    //    public synchronized void deleteObserver(Observer o) {
    //        super.deleteObserver(o);
    //        mObservers.remove(o);
    //    }

}

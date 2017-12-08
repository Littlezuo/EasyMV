package com.little.designpatternapp.subscribe

import java.util.*

/**
 * Created by Littlezuo on 2017/11/30.
 */
class WeatherData<T> : MySubject<T> {
    //        var t :T = ;
    override fun registerObserver(observer: MyObserver<T>) {
        observerList.add(observer)
    }

    override fun removeObserver(observer: MyObserver<T>) {
        observerList.remove(observer)
    }
//    override fun registerObserver(observer: MyObserver) {
//        observerList.add(observer)
//    }
//
//    override fun removeObserver(observer: MyObserver) {
//        observerList.remove(observer)
//    }


    lateinit var observerList: MutableList<MyObserver<T>>;

    init {
        observerList = ArrayList<MyObserver<T>>()
    }


    override fun notifyObservers() {
        for (myObserver in observerList) {
            myObserver.update(this)
        }
    }

    var tempearture: String? = null
    var humidity: String? = null
    var pressure: String? = null

    fun measurementsChanged() {
        notifyObservers()
    }

    public fun setInfo(tempearture: String?, humidity: String?, pressure: String?) {
        this.humidity = humidity;
        this.tempearture = tempearture;
        this.pressure = pressure;
        measurementsChanged()
    }
}
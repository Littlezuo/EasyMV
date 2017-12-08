package com.little.designpatternapp.subscribe

/**
 * Created by Littlezuo on 2017/11/30.
 * 主题接口,具体的对象使用此接口注册为观察者,或者把自己从观察者中删除
 * notifyObservers()用于在状态改变时更新当前的观察者
 */
interface MySubject<T> {
    public abstract fun /*<T>*/ registerObserver(observer: MyObserver<T>)
    public abstract fun /*<T> */removeObserver(observer: MyObserver<T>)
    public abstract fun notifyObservers()
}
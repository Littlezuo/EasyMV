package com.little.designpatternapp.subscribe

/**
 * Created by Littlezuo on 2017/11/30.
 * 所有潜在的观察者必须实现MyOvserver这个观察者接口,这个接口只有update()一个方法,当主题状态改变的时候它被调用
 */
interface MyObserver<T> {
    public
    abstract fun /*<T>*/ update(subject: MySubject<T>)
}
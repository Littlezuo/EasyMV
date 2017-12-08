package com.little.designpatternapp.strategy_pattern;

import android.util.Log;

/**
 * Created by Littlezuo on 2017/11/30.
 */

public class MyQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        Log.e("kkkk", "MyQuackBehavior的叫声");
    }
}

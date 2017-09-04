package com.little.easymv.app

import android.content.Context
import com.jaydenxiao.common.baseapp.BaseApplication
import com.little.easymv.BuildConfig
import com.little.easymv.constants.EnvirConfig

/**
 * Created by Littlezuo on 2017/8/31.
 */

class MyApplication : BaseApplication() {
    object C {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        C.context = applicationContext
        EnvirConfig.setEnvir(BuildConfig.API_ENV)
        getAppContext()
    }

    //Companion Object是在类第一次加载时执行
    companion object {
        fun getAppContext(): Context {
            return C.context
        }
    }


}
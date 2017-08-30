package com.little.easymv

import android.util.Log
import com.jaydenxiao.common.basemvvm.ViewModel
import kotlinx.android.synthetic.main.activity_flash.*


/**
 * Created by Littlezuo on 2017/8/30.
 */

class FlashMV : ViewModel() {
    override fun onStart() {
        super.onStart()
//        Log.e("tag", mContext.iv_flash.toString())
    }

    fun setData() {
        Log.e("tag", mContext.iv_flash.toString())
    }
}

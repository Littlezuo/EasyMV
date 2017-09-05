package com.little.easymv.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import com.jaydenxiao.common.R
import com.jaydenxiao.common.baseapp.Router
import com.jaydenxiao.common.basemvvm.BaseActivity
import com.jaydenxiao.common.basemvvm.VMListener
import com.jaydenxiao.common.basemvvm.ViewModel

/**
 * Created by joyin on 17-4-12.
 * 侧滑退出activity
 */

abstract class SlideBaseActivity<M : ViewModel> : BaseActivity<M>(), VMListener, OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun initTitle(ivLeft: ImageView, Right: ImageView, title: String) {
        //        R.id.banner_indicatorId
        //        R.id.back;
    }

    fun initTitle(ivRight: ImageView, title: String) {
        //        initTitle();
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Router.pop(this)
            return false
        } else {
            return super.onKeyDown(keyCode, event)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.back -> Router.pop(this)
        }
    }
}

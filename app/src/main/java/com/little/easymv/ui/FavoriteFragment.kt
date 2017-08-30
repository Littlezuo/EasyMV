package com.little.easymv


import android.support.v4.app.Fragment

import com.jaydenxiao.common.basemvvm.BaseFragment


/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : BaseFragment<*>() {


    override fun getLayoutResource(): Int {
        return R.layout.fragment_favorite
    }

}

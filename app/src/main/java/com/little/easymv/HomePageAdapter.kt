package com.little.easymv

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.jaydenxiao.common.basemvvm.BaseFragment

/**
 * Created by Littlezuo on 2017/8/30.
 */

class HomePageAdapter(fm: FragmentManager, private val mFragment: List<BaseFragment<*>>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mFragment[position]
    }

    override fun getCount(): Int {
        return 0
    }
}

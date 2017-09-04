package com.little.easymv.ui

import android.support.v4.app.Fragment
import com.jaydenxiao.common.basemvvm.BaseFragment
import com.little.easymv.R
import com.little.easymv.vm.GameMV

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : BaseFragment<GameMV>() {


    override fun getLayoutResource(): Int {
        return R.layout.recy_fragment
    }

    override fun lazyLoad() {
        initAdapter()
    }

    private fun initAdapter() {

    }


    companion object {
        fun newInstance(): Fragment {
            return GameFragment()
        }

    }
}
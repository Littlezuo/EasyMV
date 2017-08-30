package com.little.easymv.ui

import android.support.v4.app.Fragment
import com.jaydenxiao.common.basemvvm.BaseFragment
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.R

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : BaseFragment<ViewModel>() {


    override fun getLayoutResource(): Int {
        return R.layout.fragment_favorite
    }


    companion object {
        fun newInstance(): Fragment {
            return CategoryFragment()
        }

    }
}
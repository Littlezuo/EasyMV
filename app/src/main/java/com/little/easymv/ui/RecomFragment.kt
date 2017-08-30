package com.little.easymv.ui


import android.support.v4.app.Fragment

import com.jaydenxiao.common.basemvvm.BaseFragment
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.R


/**
 * A simple [Fragment] subclass.
 */
class RecomFragment : BaseFragment<ViewModel>() {


    override fun getLayoutResource(): Int {
        return R.layout.fragment_favorite
    }

    companion object {
        public fun newInstance():RecomFragment {
            return RecomFragment()
        }
    }


}

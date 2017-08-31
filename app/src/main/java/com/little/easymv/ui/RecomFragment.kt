package com.little.easymv.ui


import android.support.v4.app.Fragment
import com.jaydenxiao.common.basemvvm.BaseFragment
import com.little.easymv.R
import com.little.easymv.vm.RecomMV


/**
 * A simple [Fragment] subclass.
 */
class RecomFragment : BaseFragment<RecomMV>() {


    override fun getLayoutResource(): Int {
        return R.layout.fragment_favorite
    }



    companion object {
        public fun newInstance():RecomFragment {
            return RecomFragment()
        }
    }

    override fun lazyLoad() {

        model.requestNet4recom()
    }


}

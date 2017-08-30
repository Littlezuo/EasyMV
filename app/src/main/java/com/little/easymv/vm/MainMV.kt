package com.little.easymv.vm


import android.support.v4.app.Fragment
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jaydenxiao.common.basemvvm.ViewModel
import com.jaydenxiao.common.commonutils.SPutil
import com.little.easymv.R
import com.little.easymv.base.C
import com.little.easymv.ui.CategoryFragment
import com.little.easymv.ui.FavoriteFragment
import com.little.easymv.ui.GameFragment
import com.little.easymv.ui.RecomFragment
import java.util.*

/**
 * Created by Littlezuo on 2017/8/28.
 */

class HomeMV : ViewModel() {
    companion object {
        val TABS = 0x001
    }

    var data = mutableListOf<String>()
    val icons = intArrayOf(R.drawable.selector_tab_favorite, R.drawable.selector_tab_recom, R.drawable.selector_tab_category, R.drawable.selector_tab_game)
    override fun onStart() {
        if (!TextUtils.isEmpty(SPutil.getString(C.TAB, ""))) {
            val old = Gson().fromJson<List<String>>(SPutil.getString(C.TAB, ""), object : TypeToken<List<String>>() {

            }.type)
            data.addAll(old)
        } else {
            data.addAll(Arrays.asList<String>(*C.HOME_TABS))
        }
        mVMListener.onUpdate(HomeMV.TABS)
        initFragments()
//        initResIcon()

    }
//    var resIcon = arrayListOf<Int>()
//    private fun initResIcon() {
//        resIcon.add()
//    }

    var fragments = kotlin.collections.arrayListOf<Fragment>()
    private fun initFragments() {
        fragments.add(FavoriteFragment.newInstance())
        fragments.add(RecomFragment.newInstance())
        fragments.add(CategoryFragment.newInstance())
        fragments.add(GameFragment.newInstance())
    }

}

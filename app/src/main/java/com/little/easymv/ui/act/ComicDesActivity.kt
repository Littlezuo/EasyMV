package com.little.easymv.ui.act

import com.jaydenxiao.common.basemvvm.BaseActivity
import com.little.easymv.R
import com.little.easymv.adapter.ComicDesAdapter
import com.little.easymv.vm.ComicDesMV
import kotlinx.android.synthetic.main.activity_comic_des.*

class ComicDesActivity : BaseActivity<ComicDesMV>() {


    override fun getLayoutId(): Int {
        setStatusBar()
        return R.layout.activity_comic_des
    }

    override fun initData() {
        super.initData()
        initAdapter()
    }

    private fun initAdapter() {
        val comicDesAdapter = ComicDesAdapter(model.comicDes, recyViDes)
    }
}

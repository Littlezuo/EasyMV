package com.little.easymv.ui.act

import com.jaydenxiao.common.basemvvm.BaseActivity
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.R

class CustomViewActivity : BaseActivity<ViewModel>() {
    var pageModels = ArrayList<PageModel>()
    init {
//        pageModels.add(PageModel(R.layout.))
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_custom_view
    }



    override fun initData() {
        super.initData()

    }

}

class PageModel {
     var layoutRes : Int = 0
    var titleRes :String = ""

    constructor(layoutRes: Int, titleRes: String) {
        this.layoutRes = layoutRes
        this.titleRes = titleRes
    }
}

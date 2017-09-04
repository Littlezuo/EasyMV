package com.little.easymv.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseViewHolder
import com.jaydenxiao.common.baseadapter.MyBaseQuickAdapter
import com.little.easymv.R
import com.little.easymv.extension.loadCircleImage
import com.little.easymv.responsebean.CategoryResponse

/**
 * Created by Littlezuo on 2017/9/4.
 */
class CateGoryAdapter : MyBaseQuickAdapter<CategoryResponse> {
    constructor(data: MutableList<CategoryResponse>?, recyclerView: RecyclerView) : super(R.layout.item_category,data, recyclerView) {
//        setOnItemClickListener()

    }

    override fun convert(helper: BaseViewHolder, item: CategoryResponse) {
        helper.setText(R.id.category_tv,item.title)
        val imageView = helper.getView<ImageView>(R.id.category_iv)
        loadCircleImage(mContext,imageView,item.cover)
//        helper.setOnClickListener()

    }

//    private fun itemClick() {
//                        Router.from(AppManager.getAppManager().currentActivity()).anim(R.anim.anim_fragment_in, R.anim.anim_fragment_out)
//                        .to(ComicClassifyActivity::class.java).launch()
//    }

}
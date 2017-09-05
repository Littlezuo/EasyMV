package com.little.easymv.adapter

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.chad.library.adapter.base.BaseViewHolder
import com.jaydenxiao.common.baseadapter.MyBaseQuickAdapter
import com.jaydenxiao.common.commonutils.LogUtils
import com.little.easymv.R
import com.little.easymv.extension.loadImage
import com.little.easymv.responsebean.ClassifyResponse

/**
 * Created by Littlezuo on 2017/9/5.
 */
class ComicAdapter : MyBaseQuickAdapter<ClassifyResponse> {
    constructor(data: List<ClassifyResponse>?, recyclerView: RecyclerView?) : super(R.layout.item_comic,data, recyclerView) {

    }

    override fun convert(helper: BaseViewHolder?, item: ClassifyResponse) {
        LogUtils.loge("helper $helper")
        val imagView = helper?.getView<ImageView>(R.id.category_iv)
        loadImage(mContext,imagView,item.cover)
    }

}


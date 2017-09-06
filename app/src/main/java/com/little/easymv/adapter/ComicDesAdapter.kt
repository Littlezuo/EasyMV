package com.little.easymv.adapter

import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseViewHolder
import com.jaydenxiao.common.baseadapter.MyMultiItemAdapter
import com.little.easymv.R
import com.little.easymv.bean.ComicTypeBean
import com.little.easymv.responsebean.ComicResponse

/**
 * Created by Littlezuo on 2017/9/6.
 */
class ComicDesAdapter : MyMultiItemAdapter<ComicTypeBean> {
    //    init {
//        val list = listOf<ComicTypeBean>(ComicTypeBean(ComicTypeBean.HEADER), ComicTypeBean(ComicTypeBean.CHAPTER), ComicTypeBean(ComicTypeBean.COMMENT))
//
//    }
    companion object {
        val list = listOf<ComicTypeBean>(ComicTypeBean(ComicTypeBean.HEADER), ComicTypeBean(ComicTypeBean.CHAPTER), ComicTypeBean(ComicTypeBean.COMMENT))
    }

     var comicBean: ComicResponse? = null

    constructor(data: ComicResponse?, recyclerView: RecyclerView) : super(list, recyclerView) {
        comicBean = data;
        addItemType(ComicTypeBean.HEADER, R.layout.item_comic_des_header)
        addItemType(ComicTypeBean.CHAPTER, R.layout.item_comic_des_chapter)
        addItemType(ComicTypeBean.COMMENT, R.layout.item_comic_des_comment)
    }

    override fun convert(helper: BaseViewHolder?, item: ComicTypeBean) {
        when (item.itemType) {
            ComicTypeBean.HEADER -> setHeader()
            ComicTypeBean.CHAPTER -> setChapter()
            ComicTypeBean.COMMENT -> setComment()
        }
    }

    private fun setChapter() {

    }

    private fun setComment() {

    }

    private fun setHeader() {

    }


}
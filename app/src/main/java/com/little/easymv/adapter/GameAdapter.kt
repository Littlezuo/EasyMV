package com.little.easymv.adapter

import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseViewHolder
import com.jaydenxiao.common.baseadapter.MyBaseQuickAdapter
import com.little.easymv.R
import com.little.easymv.responsebean.SubjectResopnse

/**
 * Created by Littlezuo on 2017/9/4.
 */
class GameAdapter : MyBaseQuickAdapter<SubjectResopnse> {
    constructor(data: MutableList<SubjectResopnse>?, recyclerView: RecyclerView?) : super(R.layout.item_game_view,data, recyclerView)

    override fun convert(helper: BaseViewHolder?, item: SubjectResopnse?) {
        
    }

}
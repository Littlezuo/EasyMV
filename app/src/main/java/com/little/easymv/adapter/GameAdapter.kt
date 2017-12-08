package com.little.easymv.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.chad.library.adapter.base.BaseViewHolder
import com.jaydenxiao.common.baseadapter.MyBaseQuickAdapter
import com.jaydenxiao.common.commonutils.TimeUtil
import com.little.easymv.R
import com.little.easymv.responsebean.SubjectResopnse
import kotlinx.android.synthetic.main.item_game_view.view.*

/**
 * Created by Littlezuo on 2017/9/4.
 */
class GameAdapter : MyBaseQuickAdapter<SubjectResopnse> {
    override fun convert(helper: BaseViewHolder, itemView: View, bean: SubjectResopnse) {
        itemView.iv_icon.setImageURI(bean.small_cover)
        itemView.tv_title.setText(bean.title)
        itemView.tv_time.text = TimeUtil.getfriendlyTime(bean.create_time)
    }

    constructor(data: MutableList<SubjectResopnse>?, recyclerView: RecyclerView?) : super(R.layout.item_game_view, data, recyclerView)


}
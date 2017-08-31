package com.little.easymv.adapter

import com.little.easymv.responsebean.RecommendResponse

/**
 * Created by Littlezuo on 2017/8/31.
 */

fun formatRecom(list :List<RecommendResponse>):List<FormatRecomBean> {
    val recoms = mutableListOf<FormatRecomBean>()
    recoms.add(FormatRecomBean(list.get(0)))
    for (item in list) {
        recoms.add(FormatRecomBean(item.title))
        var span = 3;
        for (childitem in item.data) {
            when(item.data.size%2) {
                1 -> span = 2;
            }
            recoms.add(FormatRecomBean(childitem,span))
        }
    }
    return recoms;
}
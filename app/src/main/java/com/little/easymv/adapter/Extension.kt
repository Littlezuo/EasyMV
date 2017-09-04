package com.little.easymv.adapter

import com.jaydenxiao.common.baseevent.EventBusUtil
import com.little.easymv.responsebean.RecommendResponse

/**
 * Created by Littlezuo on 2017/8/31.
 */

fun formatRecom(list: List<RecommendResponse>): MutableList<FormatRecomBean> {
    val recoms = mutableListOf<FormatRecomBean>()
    recoms.add(FormatRecomBean(list.get(0)))
    val subList = list.subList(1, list.size)
    for (item in subList) {
        recoms.add(FormatRecomBean(item.title))
        var span = 2
        for (childitem in item.data) {
            when (item.data.size % 3) {
                1 -> span = 3
//                2 -> span =
            }
            recoms.add(FormatRecomBean(childitem, span))
        }
    }
    return recoms
}

fun registerEventBus(any: Any) {
    EventBusUtil.register(any)
}

fun unregisterEventBus(any: Any) {
    EventBusUtil.register(any)
}

fun postMessage(event: Any) {
    EventBusUtil.post(event)
}

//val TO_TOP = 0x33333;




package com.little.easymv.adapter

import com.little.easymv.responsebean.RecommendResponse

/**
 * Created by Littlezuo on 2017/8/31.
 */

class FormatRecomBean {
    var childitem: RecommendResponse.DataBean? = null
    lateinit var bigImage: RecommendResponse
    var title: String? = null
    var span: Int = 0

    constructor(recommendResponse: RecommendResponse) {
        bigImage = recommendResponse
        span = ALLSPAN
    }

    constructor(title: String?) {
        this.title = title
        span = ALLSPAN
    }


    constructor(childitem: RecommendResponse.DataBean?, span: Int) {
        this.childitem = childitem
        this.span = span
    }

    companion object {
        val ALLSPAN = 6
    }
}

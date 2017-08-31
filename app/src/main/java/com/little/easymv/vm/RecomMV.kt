package com.little.easymv.vm

import com.jaydenxiao.common.basemvvm.ViewModel
import com.jaydenxiao.common.baserx.RxHelper
import com.little.easymv.adapter.formatRecom
import com.little.easymv.api.Api
import com.little.easymv.api.BaseSubscriber
import com.little.easymv.api.HostType
import com.little.easymv.responsebean.RecommendResponse

/**
 * Created by Littlezuo on 2017/8/31.
 */
class RecomMV : ViewModel() {
    override fun onStart() {
        super.onStart()

    }

    private fun handleData(recommendBean: List<RecommendResponse>) {

    }

    fun requestNet4recom() {
        Api.getDefault(HostType.KaBu).recommend
                .compose(RxHelper.handleErr())
//                .subscribe { recommendBean -> handleData(recommendBean) }
                .subscribe(object : BaseSubscriber<List<RecommendResponse>>() {
                    override fun _onNext(recommendResponses: List<RecommendResponse>) {
                        val formatRecoms = formatRecom(recommendResponses);
                    }

                    override fun _onError(message: String?) {
                        super._onError(message)
                    }
                })
    }
}
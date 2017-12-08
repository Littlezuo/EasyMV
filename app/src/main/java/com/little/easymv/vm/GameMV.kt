package com.little.easymv.vm

import com.jaydenxiao.common.baserx.RxHelper
import com.little.easymv.api.Api
import com.little.easymv.api.BaseSubscriber
import com.little.easymv.api.HostType
import com.little.easymv.base.ListViewModel
import com.little.easymv.responsebean.SubjectResopnse

import kotlinx.android.synthetic.main.layout_recy.view.*

/**
 * Created by Littlezuo on 2017/9/4.
 */

class GameMV : ListViewModel() {
    override fun onStart() {
        super.onStart()
    }

    override fun scroll2top() {
        rootView.recyVi.smoothScrollToPosition(0)
    }

    var gameList: MutableList<SubjectResopnse>? = null;
    var page: Int = 0

    fun requestNet4gameList() {
        val params = "subject/0/$page.json"
//        val params = "subject/0/0.json"
        Api.getDefault(HostType.KaBu)
                .getSubject(params)
                .compose(RxHelper.handleErr())
                .subscribe(object : BaseSubscriber<MutableList<SubjectResopnse>>() {
                    override fun _onNext(t: MutableList<SubjectResopnse>?) {
                        if (page == 0) rootView.refreshLayout.finishRefresh() else rootView.refreshLayout.finishLoadmore()
                        gameList = t;
                        mVMListener.onUpdate(if (page == 0) REFRESH else LOADMORE)
                    }

                    override fun onError(e: Throwable?) {
                        super.onError(e)
                        if (page == 0) rootView.refreshLayout.finishRefresh() else rootView.refreshLayout.finishLoadmore()
                        isErr = true
                    }
                })

    }
}

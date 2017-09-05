package com.little.easymv.vm

import com.jaydenxiao.common.baseapp.AppManager
import com.jaydenxiao.common.baseapp.Router
import com.jaydenxiao.common.basemvvm.SlideViewModel
import com.jaydenxiao.common.baserx.RxHelper
import com.little.easymv.ComicClassifyActivity
import com.little.easymv.R
import com.little.easymv.api.Api
import com.little.easymv.api.BaseSubscriber
import com.little.easymv.api.HostType
import com.little.easymv.ex.EXTRA_COMIC_ID
import com.little.easymv.ex.EXTRA_COMIC_TITLE
import com.little.easymv.responsebean.ClassifyResponse

/**
 * Created by Littlezuo on 2017/9/4.
 */

class ComicClassifyMV : SlideViewModel() {

    var id = -1
    var page = 0
    lateinit var title: String
        var classifyList:List<ClassifyResponse>? = listOf<ClassifyResponse>()
//    var classifyList = mutableListOf<ClassifyResponse>()
//    var classifyList: MutableList<CategoryResponse>? = null;
    //    var cateList: MutableList<CategoryResponse>? = null;
    override fun onStart() {
        super.onStart()
        id = Router.getInt(EXTRA_COMIC_ID)
        title = Router.getString(EXTRA_COMIC_TITLE)
    }

    companion object {
        fun open(tag_id: Int, title: String) {
            Router.from(AppManager.getAppManager().currentActivity())
                    .anim(R.anim.anim_fragment_in, R.anim.anim_fragment_out)
                    .putInt(EXTRA_COMIC_ID, tag_id)
                    .putString(EXTRA_COMIC_TITLE, title)
                    .to(ComicClassifyActivity::class.java).launch()
        }
    }

    fun requestNet4classifyDetail() {
        Api.getDefault(HostType.KaBu).getClassify("classify/" + id + "/0/" + page + ".json")
                .compose(RxHelper.handleErr())
                .subscribe {
                    object : BaseSubscriber<List<ClassifyResponse>>(mContext,true) {
                        override fun _onNext(list: List<ClassifyResponse>?) {
                            isErr = false
                            classifyList = list
                            mVMListener.onUpdate(DEFAULT)
                        }

                        override fun _onError(message: String?) {
                            super._onError(message)
                            isErr = true
                            mVMListener.onUpdate(DEFAULT)
                        }
                    }
                }

    }

}

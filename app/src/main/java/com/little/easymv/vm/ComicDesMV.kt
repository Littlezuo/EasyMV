package com.little.easymv.vm

import com.jaydenxiao.common.baseapp.Router
import com.jaydenxiao.common.basemvvm.SlideViewModel
import com.little.easymv.extension.EXTRA_COMIC_ID
import com.little.easymv.extension.EXTRA_COMIC_TITLE
import com.little.easymv.responsebean.ComicResponse
import com.little.easymv.ui.act.ComicDesActivity

/**
 * Created by Littlezuo on 2017/9/6.
 */
class ComicDesMV : SlideViewModel() {
    override fun onStart() {
        super.onStart()
    }

    companion object {
        fun start(tag_id: Int, title: String) {
            Router.fromWithAnim()
                    .putInt(EXTRA_COMIC_ID, tag_id)
                    .putString(EXTRA_COMIC_TITLE, title)
                    .to(ComicDesActivity::class.java).launch()
        }
    }

    val comicDes: ComicResponse? = null;
}
package com.little.easymv

import android.os.Bundle
import com.jaydenxiao.common.baseapp.AppManager
import com.jaydenxiao.common.baseapp.Router
import com.jaydenxiao.common.basemvvm.SlideBaseActivity
import com.little.easymv.vm.ComicClassifyMV

class ComicClassifyActivity : SlideBaseActivity<ComicClassifyMV>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_classify)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_comic_classify
    }


    companion object {
        fun open() {
            Router.from(AppManager.getAppManager().currentActivity())
//                    .anim(R.anim.anim_fragment_in, R.anim.anim_fragment_out)
                    .to(ComicClassifyActivity::class.java).launch()
        }
    }

}

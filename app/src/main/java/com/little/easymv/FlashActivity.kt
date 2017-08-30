package com.little.easymv


import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.util.Log
import com.jaydenxiao.common.baseapp.RouterManager
import com.jaydenxiao.common.baseevent.BindBus
import com.jaydenxiao.common.baseevent.rxbus.RxBus
import com.jaydenxiao.common.baseevent.rxbus.Subscribe
import com.jaydenxiao.common.basemvvm.BaseActivity
import com.jaydenxiao.common.basemvvm.BindMV
import com.little.easymv.base.EventName
import kotlinx.android.synthetic.main.activity_flash.*

@BindBus
@BindMV
class FlashActivity : BaseActivity<FlashMV>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        initData()
        model.setData()
    }

    fun initData() {
        RxBus.getDefault().post(100, EventA("textxxxx"))
        startAnimator()

    }


    private fun startAnimator() {
//        var alpha = PropertyValuesHolder.ofFloat("scaleX",0,1)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f)
//        val flash = findViewById(R.id.iv_flash)
        val animator = ObjectAnimator.ofPropertyValuesHolder(iv_flash, scaleX, scaleY)

        animator.setDuration(500)
        animator.start()
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationEnd(animation: Animator?) {
                mRxManager.post(EventName.TO_MAIN, "")
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
    }

    @Subscribe(value = EventName.TO_MAIN)
    fun jump2main(tag: String) {
        Log.e("CMAD", "jump $tag")
        RouterManager.start(MainActivity::class.java)
        finish()
    }

}

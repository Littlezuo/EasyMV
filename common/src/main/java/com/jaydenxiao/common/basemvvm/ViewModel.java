package com.jaydenxiao.common.basemvvm;

import android.support.v4.app.FragmentActivity;

import com.jaydenxiao.common.baseevent.BindBus;
import com.jaydenxiao.common.baseevent.rxbus.RxBus;
import com.jaydenxiao.common.baserx.RxManager;

/**
 * Created by Littlezuo on 2017/5/17.
 */

public class ViewModel  {
    public static final int DEFAULT = 0x111;
    public static final int REFRESH = 0x222;
    public static final int LOADMORE = 0x333;
    public FragmentActivity mContext;
    public RxManager mRxManager;

    public void onDestory() {
        setVMListener(null);
        com.jaydenxiao.common.baseevent.rxbus.RxBus.getDefault().unRegister(this);
        if (mRxManager != null) {
            mRxManager.clear();
        }
        if(this.getClass().isAnnotationPresent(BindBus.class)) {
            //            EventBusUtil.register(this);
            RxBus.getDefault().unRegister(this);
        }
    }

    public void onStart() {
        if(this.getClass().isAnnotationPresent(BindBus.class)) {
            //            EventBusUtil.register(this);
            RxBus.getDefault().register(this);
        }
    }

    public VMListener mVMListener;

    public void setVMListener(VMListener VMListener) {
        mVMListener = VMListener;
    }
}

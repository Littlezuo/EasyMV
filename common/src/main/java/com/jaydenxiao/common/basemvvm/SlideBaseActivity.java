package com.jaydenxiao.common.basemvvm;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.jaydenxiao.common.baseapp.AppManager;
import com.jaydenxiao.common.baseapp.Router;
import com.jaydenxiao.common.baseevent.BindBus;
import com.jaydenxiao.common.baseevent.EventBusUtil;
import com.jaydenxiao.common.baserx.RxManager;
import com.jaydenxiao.common.commonutils.TUtil;

/**
 * Created by joyin on 17-4-12.
 */

public abstract class SlideBaseActivity<M extends ViewModel> extends AppCompatActivity implements  VMListener {

    public SlideBaseActivity mContext;
    public M model;
    public RxManager mRxManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetContentView();
        setContentView(getLayoutId());
        mContext = this;
        mRxManager = new RxManager();
        if(this.getClass().isAnnotationPresent(BindBus.class)) {
            EventBusUtil.register(this);
        }
        //默认使用viewmodel
        if(!this.getClass().isAnnotationPresent(UnbindMV.class)) {
            setModel();
        }
        initData();
    }

    protected  void initData(){}
    public abstract int getLayoutId();

    private void doBeforeSetContentView() {
        AppManager.getAppManager().addActivity(this);
        // 无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    protected void setModel() {
        model = TUtil.getT(this, 0);
        if (model != null) {
            model.mContext = this;
            model.mRxManager = mRxManager;
            model.setVMListener(this);
            model.onStart();
        } else {
            throw new IllegalStateException("ViewModel 绑定activity不成功");
        }

    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        mRxManager.clear();
        if (model != null) {
            model.onDestory();
        }
        if(this.getClass().isAnnotationPresent(BindBus.class)) {
            EventBusUtil.unregister(this);
        }
        super.onDestroy();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onUpdate(int type) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Router.pop(this);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

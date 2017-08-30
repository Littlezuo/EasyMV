package com.jaydenxiao.common.basemvvm;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenxiao.common.baseevent.BindBus;
import com.jaydenxiao.common.baseevent.rxbus.RxBus;
import com.jaydenxiao.common.baserx.RxManager;
import com.jaydenxiao.common.commonutils.TUtil;
import com.orhanobut.logger.Logger;

/**
 * Created by joyin on 17-4-12.
 */

public abstract class BaseFragment<M extends ViewModel> extends Fragment implements VMListener {
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    private String mTitle;
    public RxManager mRxManager;
    public M model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }


    }
    protected View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView==null) {
            rootView = inflater.inflate(getLayoutResource(), container, false);
        }
        mContext = getActivity();
        mRxManager = new RxManager();
        if(this.getClass().isAnnotationPresent(BindBus.class)) {
//            EventBusUtil.register(this);
            RxBus.getDefault().register(this);
        }
        if(this.getClass().isAnnotationPresent(BindMV.class)) {
            setModel();
        }
        isPrepared = true;
        isGolazyLoad();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {

    }


    /**
     * 获取布局,同时设置isMVP,默认是MVP模式
     *
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutResource();

    protected boolean isPrepared = false;
    protected boolean isVisible;

    /**
     * 在这里实现Fragment数据的缓加载.
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    private void isGolazyLoad() {
        Logger.d("isGolazyLoad");
        if (!isPrepared || !isVisible) {
            return;
        }
        lazyLoad();
        isPrepared = false;
    }

    protected void lazyLoad() {
    }



    protected void onInvisible() {

    }

    protected void onVisible() {

    }

    protected FragmentActivity mContext;

    protected void setModel() {
        model = TUtil.getT(this, 0);
        if (model != null) {
            mContext = getActivity();
            model.mContext = mContext;
            model.mRxManager = mRxManager;
            model.setVMListener(this);
        } else {
            throw new IllegalStateException("fragment绑定viewmodel异常");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRxManager.clear();
        if(this.getClass().isAnnotationPresent(BindBus.class)) {
//            EventBusUtil.unregister(this);
            RxBus.getDefault().unRegister(this);
        }
        if (model != null) {
            model.onDestory();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    public String getTitle() {
        return mTitle;
    }


    @Override
    public void onUpdate(int flag) {

    }
}

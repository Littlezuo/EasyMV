package com.jaydenxiao.common.baseadapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jaydenxiao.common.R;

import java.util.Collection;
import java.util.List;

/**
 * Created by Littlezuo on 2017/8/10.
 */

public abstract class MyBaseQuickAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private View netErrView;
    private View loadingView;
    private View notDataView;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public MyBaseQuickAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public MyBaseQuickAdapter(@Nullable List<T> data) {
        super(data);
    }

    public MyBaseQuickAdapter(@LayoutRes int layoutResId, @Nullable List<T> data, RecyclerView recyclerView) {
        super(layoutResId, data);
        initEmpty(recyclerView);

    }


    protected void initEmpty(RecyclerView recyclerView) {

        loadingView = ((Activity) mContext).getLayoutInflater().inflate(R.layout.loading_bg, (ViewGroup) recyclerView.getParent(), false);
        notDataView = ((Activity) mContext).getLayoutInflater().inflate(R.layout.empty_bg, (ViewGroup) recyclerView.getParent(), false);
        netErrView = ((Activity) mContext).getLayoutInflater().inflate(R.layout.neterr_bg, (ViewGroup) recyclerView.getParent(), false);
    }


    public MyBaseQuickAdapter(@Nullable List<T> data, RecyclerView recyclerView) {
        super(data);
    }

    public MyBaseQuickAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    public void addData(@NonNull Collection<? extends T> newData) {
        super.addData(newData);
        if (mData == null || mData.size() <= 0) {
            if (newData == null || newData.size() <= 0) {
                setEmptyView(notDataView);
            }
        } else {
            if (newData == null || newData.size() <= 0) {
                loadMoreEnd();
            } else {
                loadMoreComplete();
            }
        }
    }



    public void setNetErrView() {
        if (mData == null || mData.size() <= 0) {
            setEmptyView(notDataView);
        } else {
            loadMoreFail();
        }
    }

    @Override
    public void setNewData(@Nullable List<T> data) {
        super.setNewData(data);
        if (data == null || data.size() <= 0) {
            setEmptyView(notDataView);
        }
    }
}
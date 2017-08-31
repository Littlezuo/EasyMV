package com.little.easymv.adapter;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jaydenxiao.common.baseadapter.MyBaseSectionAdapter;

import java.util.List;

/**
 * Created by Littlezuo on 2017/8/31.
 */

public class RecomSectionAdapter extends MyBaseSectionAdapter<RecomSection> {
    public RecomSectionAdapter(int layoutResId, int sectionHeadResId, List<RecomSection> data, RecyclerView recyclerView) {
        super(layoutResId, sectionHeadResId, data, recyclerView);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, RecomSection item) {

    }

    @Override
    protected void convert(BaseViewHolder helper, RecomSection item) {

    }
}

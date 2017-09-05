package com.little.easymv

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.adapter.ComicAdapter
import com.little.easymv.base.SlideBaseActivity
import com.little.easymv.ui.view.MyLoadMoreView
import com.little.easymv.vm.ComicClassifyMV
import kotlinx.android.synthetic.main.activity_comic_classify.*

class ComicClassifyActivity : SlideBaseActivity<ComicClassifyMV>(), BaseQuickAdapter.RequestLoadMoreListener {

    //上拉加载更多
    override fun onLoadMoreRequested() {

    }



    override fun getLayoutId(): Int {
        setStatusBar()
        return R.layout.activity_comic_classify
    }

    override fun initData() {
        super.initData()
        initAdapter()
        model.requestNet4classifyDetail()
    }
    lateinit var comicAdapter:ComicAdapter
    private fun initAdapter() {
//        recomMultiItemAdapter = RecomMultiItemAdapter(model.formatRecoms, rootView.recyVi)
//        rootView.recyVi.setLayoutManager(GridLayoutManager(mContext, FormatRecomBean.ALLSPAN))
//        rootView.recyVi.setAdapter(recomMultiItemAdapter)

         comicAdapter = ComicAdapter(model.classifyList, comicRecyVi)
        val gridLayoutManager = GridLayoutManager(mContext, 3)
        comicRecyVi.setLayoutManager(gridLayoutManager)
        comicRecyVi.setAdapter(comicAdapter)
        comicAdapter.setLoadMoreView(MyLoadMoreView())
        comicAdapter.setOnLoadMoreListener(this,comicRecyVi)
        comicRecyVi.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
//                val item = adapter?.data?.get(position) as ClassifyResponse
            }
        })
    }

    override fun onUpdate(type: Int) {
        when(type) {
            ViewModel.DEFAULT -> setData()
        }
    }

    private fun setData() {
        comicAdapter.setNewData(model.classifyList,model.isErr)
//        comicAdapter.addData(model.classifyList,model.isErr)
    }

}

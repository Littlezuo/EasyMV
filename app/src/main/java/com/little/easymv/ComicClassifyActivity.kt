package com.little.easymv

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.jaydenxiao.common.baseadapter.MyBaseQuickAdapter
import com.little.easymv.base.SlideBaseActivity
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.extension.loadImage
import com.little.easymv.responsebean.ClassifyResponse
import com.little.easymv.ui.view.MyLoadMoreView
import com.little.easymv.vm.ComicClassifyMV
import kotlinx.android.synthetic.main.activity_comic_classify.*

class ComicClassifyActivity : SlideBaseActivity<ComicClassifyMV>(), BaseQuickAdapter.RequestLoadMoreListener {

    //上拉加载更多
    override fun onLoadMoreRequested() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_comic_classify)

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
    lateinit var comicAdapter:ComicAdapter;
    private fun initAdapter() {
         comicAdapter = ComicAdapter(model.classifyList, comicRecyVi)
        val gridLayoutManager = GridLayoutManager(mContext, 3)
        comicRecyVi.setLayoutManager(gridLayoutManager)
        comicRecyVi.adapter=comicAdapter
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
    }

}
class ComicAdapter : MyBaseQuickAdapter<ClassifyResponse> {
    constructor(data: List<ClassifyResponse>?, recyclerView: RecyclerView?) : super( R.layout.item_comic,data, recyclerView)

    override fun convert(helper: BaseViewHolder?, item: ClassifyResponse?) {
        val imagView = helper?.getView<ImageView>(R.id.category_iv)
        loadImage(mContext,imagView,item?.cover)
    }

}

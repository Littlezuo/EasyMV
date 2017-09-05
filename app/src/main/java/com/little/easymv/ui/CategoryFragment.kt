package com.little.easymv.ui

import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.jaydenxiao.common.basemvvm.BaseFragment
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.R
import com.little.easymv.adapter.CateGoryAdapter
import com.little.easymv.responsebean.CategoryResponse
import com.little.easymv.vm.CateMV
import com.little.easymv.vm.ComicClassifyMV
import kotlinx.android.synthetic.main.recy_fragment.*
import kotlinx.android.synthetic.main.recy_fragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : BaseFragment<CateMV>() {
//    fun onRefresh() {
//
//    }



    override fun getLayoutResource(): Int {
        return R.layout.recy_fragment
    }

    override fun lazyLoad() {
        initAdapter()
        loadData()

    }

    private fun loadData() {
        rootView.refreshLayout.isEnabled = true
        model.requestNet4CateData()

    }

    override fun onUpdate(flag: Int) {
        when (flag) {
            ViewModel.DEFAULT -> setData()
        }
    }


    var cateAdapter: CateGoryAdapter? = null
    private fun setData() {
        rootView.refreshLayout.isEnabled = false
        cateAdapter?.setNewData(model.cateList, model.isErr)
    }

    private fun initAdapter() {
        refreshLayout.initRefresh(true)
        cateAdapter = CateGoryAdapter(model.cateList, recyVi)
        cateAdapter?.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        val gridLayoutManager = GridLayoutManager(mContext, 3)
        recyVi.setLayoutManager(gridLayoutManager)
        recyVi.setAdapter(cateAdapter)
//        refreshLayout.setOnRefreshListener(this)
        cateAdapter?.setReloadListener { loadData() }
        recyVi.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                                val item = adapter?.data?.get(position) as CategoryResponse
                                ComicClassifyMV.open(item.tag_id,item.title)

            }
        })

    }

    companion object {
        fun newInstance():CategoryFragment {
            return CategoryFragment();
        }
    }

}
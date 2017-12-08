package com.little.easymv.ui

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.jaydenxiao.common.basemvvm.BaseFragment
import com.jaydenxiao.common.basemvvm.ViewModel
import com.little.easymv.R
import com.little.easymv.adapter.GameAdapter
import com.little.easymv.vm.GameMV
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.layout_recy.view.*


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : BaseFragment<GameMV>(), OnRefreshListener, OnLoadmoreListener {
    override fun onLoadmore(refreshlayout: RefreshLayout?) {
        model.page++
        model.requestNet4gameList()
    }

    override fun onRefresh(refreshlayout: RefreshLayout?) {
        model.page = 0
        model.requestNet4gameList()
//        gameAdapter.setNewData(model.gameList)
    }


    override fun getLayoutResource(): Int {
        return R.layout.layout_recy
    }

    override fun lazyLoad() {
        initAdapter()
        model.requestNet4gameList()
    }

    lateinit var gameAdapter: GameAdapter;
    private fun initAdapter() {
        gameAdapter = GameAdapter(model.gameList, rootView.recyVi)
        val layoutManager = LinearLayoutManager(mContext)
        rootView.recyVi.layoutManager = layoutManager
        rootView.recyVi.adapter = gameAdapter
        rootView.recyVi.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
//                adapter
            }
        })
        rootView.refreshLayout.setOnRefreshListener(this)
        rootView.refreshLayout.autoRefresh()
        rootView.refreshLayout.autoLoadmore()
        rootView.refreshLayout.setOnLoadmoreListener(this)
//        rootView.refreshLayout.setOnRefreshLoadmoreListener(this)
    }

    override fun onUpdate(flag: Int) {
        super.onUpdate(flag)
        when (flag) {
            ViewModel.REFRESH -> gameAdapter.setNewData(model.gameList)
            ViewModel.LOADMORE -> gameAdapter.addData(model.gameList, model.isErr)
        }
    }


    companion object {
        fun newInstance(): Fragment {
            return GameFragment()
        }
    }

}

package com.little.easymv

import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.jaydenxiao.common.baseevent.BindBus
import com.jaydenxiao.common.basemvvm.BaseActivity
import com.jaydenxiao.common.commonutils.LogUtils
import com.little.easymv.vm.MainMV
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

@BindBus
class MainActivity : BaseActivity<MainMV>(), NavigationView.OnNavigationItemSelectedListener {
    override fun getLayoutId(): Int {
//        StatusBarUtil.setStatusBarColor(this, com.jaydenxiao.common.R.color.colorPrimary)
//        window.decorView.setBackgroundColor(R.color.colorPrimary)
//        StatusBarUtil.transparencyBar(this)
        return R.layout.activity_main
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.nav_manage)
        return true;
    }

    override fun initData() {
       initView()
    }


    private fun initView() {
        //存在toolbar,关联ActionBarDrawerToggle控制侧边栏弹出
        val drawerToggle = ActionBarDrawerToggle(this, dl_main_drawer, R.string.drawer_open, R.string.drawer_close)
        drawerToggle.syncState()
        dl_main_drawer.addDrawerListener(drawerToggle)
        nv_main_navigation.setNavigationItemSelectedListener(this)

        val homePageAdapter = HomePageAdapter(supportFragmentManager, model.fragments, model.icons)
        LogUtils.loge("$homePageAdapter")
        viewpager.setAdapter(homePageAdapter)
        tabs.setupWithViewPager(viewpager)
    }

    override fun onUpdate(type: Int) {
        when (type) {
//            MainMV.TABS -> initTabs()
        }
    }

    private fun initTabs() {

    }
}

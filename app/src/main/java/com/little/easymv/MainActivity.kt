package com.little.easymv

import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.jaydenxiao.common.baseevent.BindBus
import com.jaydenxiao.common.basemvvm.BaseActivity
import com.jaydenxiao.common.commonutils.ImageLoaderUtils
import com.jaydenxiao.common.commonutils.LogUtils
import com.little.easymv.vm.MainMV
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*
import kotlinx.android.synthetic.main.nav_header_main.view.*

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

        //菜单栏
        val headerView = nv_main_navigation.getHeaderView(0)
        //让item显示原本的颜色
//        nv_main_navigation.itemIconTintList = null
        ImageLoaderUtils.displayCircle(this,headerView.im_face,R.drawable.pig)
        ImageLoaderUtils.displayCircle(this,iv_user,R.drawable.pig)
    }

    override fun onUpdate(type: Int) {
        when (type) {
//            MainMV.TABS -> initTabs()
        }
    }


}

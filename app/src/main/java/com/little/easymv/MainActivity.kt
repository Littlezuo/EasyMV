package com.little.easymv

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.jaydenxiao.common.baseevent.BindBus
import com.jaydenxiao.common.basemvvm.BaseActivity
import com.little.easymv.vm.HomeMV
import kotlinx.android.synthetic.main.activity_main.*

@BindBus
class MainActivity : BaseActivity<HomeMV>(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.nav_manage)
        return true;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("tag", "onCreate")
        initView()
    }

    private fun initView() {
        //存在toolbar,关联ActionBarDrawerToggle控制侧边栏弹出
        val drawerToggle = ActionBarDrawerToggle(this, dl_main_drawer, R.string.drawer_open, R.string.drawer_close)
        drawerToggle.syncState()
        dl_main_drawer.addDrawerListener(drawerToggle)
        nv_main_navigation.setNavigationItemSelectedListener(this)

    }

    override fun onUpdate(type: Int) {
        when (type) {
            HomeMV.TABS -> initTabs()
        }
    }

    private fun initTabs() {

    }
}

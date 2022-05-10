package com.androidapp.androidcomponent


import android.graphics.Color
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.example.androidcomponent.R
import com.example.androidcomponent.databinding.ActivityMainBinding
import com.example.commonlib.base.BaseActivity
import com.next.easynavigation.view.EasyNavigationBar


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun bindRightClickListener(): View.OnClickListener {

        return View.OnClickListener {
            Toast.makeText(
                this@MainActivity,
                "click right",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun bindLeftClickListener(): View.OnClickListener {
        return View.OnClickListener {
            Toast.makeText(
                this@MainActivity,
                "click left",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun initView() {
        var titles = arrayOf("首页", "统计","我的")
        var normal = intArrayOf(
            R.drawable.tab_bookshelf_normal,
            R.drawable.tab_home_normal,
            R.drawable.tab_me_normal,
        )
        var select = intArrayOf(
            R.drawable.tab_bookshelf_selected,
            R.drawable.tab_home_selected,
            R.drawable.tab_me_selected,
        )

        var fragments = mutableListOf<Fragment>(
            ARouter.getInstance().build("/main/fragment_main").navigation() as Fragment,
            ARouter.getInstance().build("/home/fragment_home").navigation() as Fragment,
            ARouter.getInstance().build("/mine/fragment_mine").navigation() as Fragment
        )

        binding!!.easyNavigation
            .normalIconItems(normal)
            .selectIconItems(select)
            .titleItems(titles)
            .normalTextColor(Color.parseColor("#999999"))
            .selectTextColor(Color.parseColor("#333333"))
            .fragmentList(fragments)
            .fragmentManager(supportFragmentManager)
            .setOnTabClickListener(object : EasyNavigationBar.OnTabClickListener {
                override fun onTabSelectEvent(view: View?, position: Int): Boolean {
                    return false
                }

                override fun onTabReSelectEvent(view: View?, position: Int): Boolean {
                    return false
                }
            })
            .build()
    }


}
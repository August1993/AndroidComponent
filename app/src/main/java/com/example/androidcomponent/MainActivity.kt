package com.example.androidcomponent


import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.example.androidcomponent.databinding.ActivityMainBinding
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.example.mediator.router.HomeRouter
import com.example.mediator.router.MainRouter
import com.example.mediator.router.MineRouter
import com.wuhenzhizao.titlebar.widget.CommonTitleBar


class MainActivity : BaseActivity<ActivityMainBinding, NoViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun enableSimpleTitle(): Boolean = true

    override fun bindCenterTitle(): String {
        return "superTitle"
    }

    override fun bindLeftType(): Int {
        return CommonTitleBar.TYPE_LEFT_TEXTVIEW
    }

    override fun bindLeftText(): String {
        return "取消"
    }

    override fun bindLeftIcon(): Int {
        return R.drawable.comm_titlebar_search_normal
    }

    override fun bindRightType(): Int {
        return CommonTitleBar.TYPE_RIGHT_TEXTVIEW
    }

    override fun bindRightIcon(): Int {
        return R.drawable.comm_titlebar_voice
    }

    override fun bindRightText(): String {
        return "确定"
    }

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


        binding.homeMain.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "1",
                Toast.LENGTH_SHORT
            ).show()
            ARouter.getInstance().build(HomeRouter.PAGE_MAIN).navigation()


        }

        binding.mainMain.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "2",
                Toast.LENGTH_SHORT
            ).show()
            ARouter.getInstance().build(MainRouter.PAGE_MAIN).navigation()
        }

        binding.mineMain.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "3",
                Toast.LENGTH_SHORT
            ).show()
            ARouter.getInstance().build(MineRouter.PAGE_MAIN).navigation()
        }

        binding.test.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "4",
                Toast.LENGTH_SHORT
            ).show()
            ARouter.getInstance().build("/second/page").navigation()
        }

    }


}
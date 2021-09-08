package com.example.androidcomponent


import android.view.View
import android.widget.Toast
import com.example.androidcomponent.databinding.ActivityMainBinding
import com.example.commonlib.base.BaseActivity
import com.wuhenzhizao.titlebar.widget.CommonTitleBar


class MainActivity : BaseActivity<ActivityMainBinding>() {

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
        return View.OnClickListener { Toast.makeText(this@MainActivity, "click right", Toast.LENGTH_SHORT).show() }
    }

    override fun bindLeftClickListener(): View.OnClickListener {
        return View.OnClickListener { Toast.makeText(this@MainActivity, "click left", Toast.LENGTH_SHORT).show() }
    }

    override fun initView() {

    }


}
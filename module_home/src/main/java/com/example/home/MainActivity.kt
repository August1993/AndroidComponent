package com.example.home

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.example.home.databinding.HomeActivityMainBinding
import com.example.mediator.router.HomeRouter


@Route(path = HomeRouter.PAGE_MAIN)
class MainActivity : BaseActivity<HomeActivityMainBinding,NoViewModel>() {
    override fun getLayoutId(): Int {
      return R.layout.home_activity_main
    }

    override fun initView() {
            Toast.makeText(this,"hhh",Toast.LENGTH_SHORT).show()
    }

}
package com.example.module.main

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.example.mediator.router.MainRouter
import com.example.module.R
import com.example.module.databinding.ActivityMainBinding


@Route(path = MainRouter.PAGE_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, NoViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {

    }

}
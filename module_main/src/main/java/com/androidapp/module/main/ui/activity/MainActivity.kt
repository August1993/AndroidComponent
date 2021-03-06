package com.androidapp.module.main.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.androidapp.mediator.router.MainRouter
import com.example.module.R
import com.example.module.databinding.MainActivityMainBinding


@Route(path = MainRouter.PAGE_MAIN)
class MainActivity : BaseActivity<MainActivityMainBinding, NoViewModel>() {
    override fun getLayoutId(): Int = R.layout.main_activity_main

    override fun initView() {

    }

}
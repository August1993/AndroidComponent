package com.androidapp.module.home.ui

import android.graphics.Color
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.dialog.CommonMessageDialog
import com.example.commonlib.util.RxUtils
import com.example.home.databinding.HomeActivityMainBinding
import com.androidapp.module.home.ui.adapter.ProjectAdapter
import com.androidapp.module.home.viewmodel.HomeViewModel
import com.androidapp.mediator.router.HomeRouter
import com.example.home.R
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


@Route(path = HomeRouter.PAGE_MAIN)
class MainActivity : BaseActivity<HomeActivityMainBinding, HomeViewModel>() {

    private val adapter by lazy { ProjectAdapter() }

    override fun getLayoutId(): Int = R.layout.home_activity_main

    override fun initView() {




    }

    override fun initListener() {
        super.initListener()

    }
}
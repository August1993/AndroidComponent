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
        mViewModel?.getBanner()
        binding.ry.layoutManager = LinearLayoutManager(this)
        binding.ry.adapter = adapter
        lifecycleScope.launch {
            mViewModel?.getPagingData()?.collect {
                adapter.submitData(it)
            }
        }
        adapter.addLoadStateListener {

        }

        Single.just(1)
            .delay(5, TimeUnit.SECONDS)
            .compose(RxUtils::toSimpleSingle)
            .compose(bindToLifecycle())
            .subscribe({
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show()
            }, {


            })

        CommonMessageDialog
            .Builder()
            .setTitleText("更新提示")
            .setMessageText("有新的版本,请立即更新")
            .setNegativeText("拒绝")
            .setPositiveText("同意")
            .setNegativeTextColor(Color.RED)
            .setPositiveTextColor(Color.GREEN)
            .setTitleColor(Color.parseColor("#0094ff"))
            .setMessageColor(Color.YELLOW)
            .setNegativeClickListener {
                Toast.makeText(MainActivity@ this, "取消", Toast.LENGTH_SHORT).show()
            }
            .setPositiveClickListener {
                Toast.makeText(MainActivity@ this, "确认", Toast.LENGTH_SHORT).show()
            }
            .setCancelable(true)
            .show(supportFragmentManager, "11")
    }

    override fun initListener() {
        super.initListener()
        mViewModel?.mBannerLiveData?.observe(this, {
        })
    }
}
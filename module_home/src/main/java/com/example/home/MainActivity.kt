package com.example.home

import android.graphics.Color
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.dialog.CommonMessageDialog
import com.example.commonlib.util.LogUtils
import com.example.commonlib.util.RxUtils
import com.example.home.databinding.HomeActivityMainBinding
import com.example.home.model.bean.Data
import com.example.home.ui.adapter.ProjectAdapter
import com.example.home.viewmodel.HomeViewModel
import com.example.mediator.router.HomeRouter
import com.trello.lifecycle4.android.lifecycle.RxLifecycleAndroidLifecycle
import com.trello.rxlifecycle4.RxLifecycle
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit
import java.util.function.Consumer


@Route(path = HomeRouter.PAGE_MAIN)
class MainActivity : BaseActivity<HomeActivityMainBinding, HomeViewModel>() {

    val adapter by lazy { ProjectAdapter() }

    override fun getLayoutId(): Int {
        return R.layout.home_activity_main
    }

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

//        CommonMessageDialog.Builder()
//            .setTitleText("更新提示")
//            .setMessageText("有新的版本,请立即更新")
//            .setNegativeText("拒绝")
//            .setPositiveText("同意")
//            .setNegativeTextColor(Color.RED)
//            .setPositiveTextColor(Color.GREEN)
//            .setTitleColor(Color.parseColor("#0094ff"))
//            .setMessageColor(Color.YELLOW)
//            .setNegativeClickListener {
//                Toast.makeText(MainActivity@ this, "取消", Toast.LENGTH_SHORT).show()
//            }
//            .setPositiveClickListener {
//                Toast.makeText(MainActivity@ this, "确认", Toast.LENGTH_SHORT).show()
//
//            }
//            .setCancelable(true)
//            .show(supportFragmentManager, "11")
    }

    override fun initListener() {
        super.initListener()
        mViewModel?.mBannerLiveData?.observe(this, {
            Toast.makeText(this, "receive data success !!! ", Toast.LENGTH_SHORT).show()

        })
    }
}
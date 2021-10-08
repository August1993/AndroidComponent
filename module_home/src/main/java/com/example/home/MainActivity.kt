package com.example.home

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.home.databinding.HomeActivityMainBinding
import com.example.home.viewmodel.HomeViewModel
import com.example.mediator.router.HomeRouter


@Route(path = HomeRouter.PAGE_MAIN)
class MainActivity : BaseActivity<HomeActivityMainBinding, HomeViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.home_activity_main
    }

    override fun initView() {
        mViewModel?.getBanner()
    }

    override fun initListener() {
        super.initListener()
        binding.tv.setOnClickListener {  }
        mViewModel?.mBannerLiveData?.observe(this,{
            Toast.makeText(this, "receive data success !!! ", Toast.LENGTH_SHORT).show()
            binding.tv.text=it.toString()
        })
    }
}
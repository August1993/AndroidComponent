package com.example.mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.NoViewModel
import com.example.mediator.router.HomeRouter
import com.example.mediator.router.MineRouter
import com.example.mine.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding,NoViewModel>() {
    override fun getLayoutId(): Int {
         return R.layout.activity_main
    }

    override fun initView() {

    }

}
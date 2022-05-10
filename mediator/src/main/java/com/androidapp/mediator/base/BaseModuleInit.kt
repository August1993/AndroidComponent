package com.androidapp.mediator.base

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonlib.util.LogUtils
import com.example.mediator.BuildConfig
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class BaseModuleInit : IModuleInit {
    override fun onInitAhead(application: Application?) {
        //初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog() // 打印日志
            ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application) // 尽可能早，推荐在Application中初始化
        Log.d("IModuleInit", "onInitAhead: BaseModuleInit")
    }

    override fun onInitLow(application: Application?) {
        setRxJavaErrorHandler()
        Log.d("IModuleInit", "onInitLow: BaseModuleInit")
    }

    private fun setRxJavaErrorHandler() {
        RxJavaPlugins.setErrorHandler { throwable ->
            throwable.printStackTrace()
            LogUtils.e("BaseModuleInit", "setRxJavaErrorHandler " + throwable.message)
        }
    }


}
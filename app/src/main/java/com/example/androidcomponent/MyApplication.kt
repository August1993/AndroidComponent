package com.example.androidcomponent

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/7 2:41 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}
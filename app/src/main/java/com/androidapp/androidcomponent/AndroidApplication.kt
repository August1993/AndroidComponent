package com.androidapp.androidcomponent

import com.alibaba.android.arouter.launcher.ARouter
import com.androidapp.mediator.config.ModuleLifecycleConfig
import com.example.commonlib.base.BaseApplication


/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/7 2:41 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class AndroidApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this)
        ModuleLifecycleConfig.getInstance().initModuleLow(this)

    }
}



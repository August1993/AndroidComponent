package com.androidapp.module.home

import android.app.Application
import android.util.Log
import com.androidapp.mediator.base.IModuleInit

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2022/5/10 2:21 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class MineModule : IModuleInit {
    override fun onInitAhead(application: Application?) {
        Log.d("IModuleInit", "onInitAhead: MineModule")
    }

    override fun onInitLow(application: Application?) {
        Log.d("IModuleInit", "onInitLow: MineModule")
    }
}
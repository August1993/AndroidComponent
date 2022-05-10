package com.androidapp.mediator.base

import android.app.Application


interface IModuleInit {
    //初始化优先的
    fun onInitAhead(application: Application?)

    //初始化靠后的
    fun onInitLow(application: Application?)
}
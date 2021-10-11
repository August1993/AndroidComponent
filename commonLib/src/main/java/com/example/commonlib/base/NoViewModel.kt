package com.example.commonlib.base

import android.app.Application

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/23 10:17 上午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class NoViewModel(application: Application) : BaseViewModel<NoModel>(application,NoModel()) {
}
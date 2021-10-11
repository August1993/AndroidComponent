package com.example.androidcomponent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.commonlib.base.BaseViewModel
import com.example.commonlib.base.NoModel
import com.example.commonlib.base.NoViewModel

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/30 3:51 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class MainViewModel(application: Application) : BaseViewModel<NoModel>(application,NoModel()) {


}
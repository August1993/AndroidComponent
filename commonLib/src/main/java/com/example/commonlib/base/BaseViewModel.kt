package com.example.commonlib.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/8 4:40 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class BaseViewModel<M : BaseModel> : ViewModel() {

    val emptyLiveDate = MutableLiveData<Any>()

    val loadingLiveData = MutableLiveData<Boolean>()

}


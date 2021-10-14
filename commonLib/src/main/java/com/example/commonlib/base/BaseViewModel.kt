package com.example.commonlib.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/8 4:40 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
abstract class BaseViewModel<M : BaseModel> : AndroidViewModel,IBaseViewModel {

    override fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?) {

    }

    override fun onCreate() {

    }

    override fun onDestroy() {

    }

    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun registerRxBus() {

    }

    override fun removeRxBus() {

    }

    constructor(application: Application, model: BaseModel) : super(application) {
        mModel = model as M
    }

    var mModel: M? = null

    val emptyLiveDate = MutableLiveData<Any>()

    val loadingLiveData = MutableLiveData<Boolean>()

}


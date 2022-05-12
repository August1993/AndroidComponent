package com.example.commonlib.base

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.commonlib.event.event.SingleLiveEvent
import com.example.commonlib.http.model.NetResult
import com.rxjava.rxlife.RxConverter
import com.rxjava.rxlife.RxLife
import com.rxjava.rxlife.ScopeViewModel

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/8 4:40 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
abstract class BaseViewModel<M : BaseModel> : ScopeViewModel, IBaseViewModel {

    var uiChangeLiveData: UIChangeLiveData? = null

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
        uiChangeLiveData = UIChangeLiveData()
    }

    fun <T>bindLifecycle(): RxConverter<T> {
        return RxLife.asOnMain<T>(this)
    }

    @JvmField
    var mModel: M? = null

    class UIChangeLiveData : SingleLiveEvent<Any>() {
        val showLoadingEvent by lazy { return@lazy MutableLiveData<Boolean>() }
        val showErrorEvent by lazy { return@lazy SingleLiveEvent<NetResult.Error>() }
    }

}


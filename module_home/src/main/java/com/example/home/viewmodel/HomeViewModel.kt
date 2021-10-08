package com.example.home.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.commonlib.base.BaseViewModel
import com.example.commonlib.base.NoModel
import com.example.commonlib.http.model.NetResult
import com.example.commonlib.util.LogUtils
import com.example.home.model.HomeModel
import com.example.home.model.bean.Banner
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/30 4:38 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class HomeViewModel : BaseViewModel<HomeModel>() {

    val mBannerLiveData by lazy {
        MutableLiveData<List<Banner>>()
    }

    val m by lazy {
        HomeModel()
    }

    fun getBanner() {
        viewModelScope.launch {
            val banner = m.getBanner()
            if (banner is NetResult.Success) {
                LogUtils.d("getBanner","getBanner is $banner")
                mBannerLiveData.value=banner.data
            } else if (banner is NetResult.Error) {

            }
        }

    }
}
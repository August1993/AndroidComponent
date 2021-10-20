package com.example.home.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.commonlib.base.BaseViewModel
import com.example.commonlib.http.model.NetResult
import com.example.commonlib.util.LogUtils
import com.example.home.model.HomeModel
import com.example.home.model.bean.Banner
import com.example.home.model.bean.Data
import com.example.home.model.repo.ProjectPagingSource
import com.example.home.model.service.RequestCenter
import com.zs.zs_jetpack.http.RetrofitFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/30 4:38 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class HomeViewModel(application: Application) : BaseViewModel<HomeModel>(application, HomeModel()) {

    val mBannerLiveData by lazy {
        MutableLiveData<List<Banner>>()
    }

    fun getBanner() {
        uiChangeLiveData?.showLoadingEvent?.value = true
        viewModelScope.launch {
            val banner = mModel?.getBanner()
            if (banner is NetResult.Success) {
                LogUtils.d("getBanner", "getBanner is $banner")
                mBannerLiveData.value = banner.data
                uiChangeLiveData?.showLoadingEvent?.value = false
            } else if (banner is NetResult.Error) {
                uiChangeLiveData?.showErrorEvent?.value=banner
            }
        }
    }

    fun getPagingData(): Flow<PagingData<Data>> {
        val requestCenter = buildService(RequestCenter::class.java)
        return Pager(config = PagingConfig(1),
            pagingSourceFactory = { ProjectPagingSource(requestCenter) })
            .flow
    }

    fun <T> buildService(service: Class<T>): T {
        return RetrofitFactory.factory().create(service)
    }
}
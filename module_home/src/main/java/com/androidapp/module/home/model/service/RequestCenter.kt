package com.androidapp.module.home.model.service


import com.example.commonlib.http.model.HttpResult
import com.androidapp.module.home.model.bean.Banner
import com.androidapp.module.home.model.bean.ProjectBean
import com.zhpan.idea.net.common.BasicResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Create by liwen on 2020-05-18
 */
interface RequestCenter {
    @GET("/banner/json")
    fun getBanner(): Single<MutableList<Banner>>

}
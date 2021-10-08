package com.example.home.model.service

import com.example.commonlib.base.BaseModel
import com.example.commonlib.http.model.HttpResult
import com.example.home.model.bean.Banner


import retrofit2.http.GET


/**
 * Create by liwen on 2020-05-18
 */
interface RequestCenter {
    @GET("/banner/json")
    suspend fun getBanner(): HttpResult<MutableList<Banner>>
}
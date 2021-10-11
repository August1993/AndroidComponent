package com.example.home.model.service

import com.example.commonlib.base.BaseModel
import com.example.commonlib.http.model.HttpResult
import com.example.home.model.bean.Banner
import com.example.home.model.bean.ProjectBean


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Create by liwen on 2020-05-18
 */
interface RequestCenter {
    @GET("/banner/json")
    suspend fun getBanner(): HttpResult<MutableList<Banner>>

    @GET("/project/list/{pageNum}/json")
    suspend fun getProjectList(@Path("pageNum") pageNum: Int): HttpResult<ProjectBean>

}
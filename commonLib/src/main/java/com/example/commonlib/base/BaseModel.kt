package com.example.commonlib.base

import com.zhpan.idea.net.common.IdeaApi
import com.zs.zs_jetpack.http.RetrofitFactory

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/8 4:41 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
open class BaseModel {

    fun <T> buildService(service: Class<T>): T{

//        return RetrofitFactory.factory().create(service)
        return IdeaApi.getApiService(service, "https://www.wanandroid.com")
    }
}
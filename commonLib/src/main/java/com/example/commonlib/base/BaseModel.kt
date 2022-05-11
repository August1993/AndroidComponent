package com.example.commonlib.base

import com.example.commonlib.http.model.DealException
import com.example.commonlib.http.model.HttpResult
import com.example.commonlib.http.model.NetResult
import com.example.commonlib.http.model.ResultException
import com.zs.zs_jetpack.http.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/8 4:41 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
open class BaseModel {

    fun <T> buildService(service: Class<T>): T {

        return RetrofitFactory.factory().create(service)
    }
}
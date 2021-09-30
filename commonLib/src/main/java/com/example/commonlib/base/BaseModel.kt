package com.example.commonlib.base

import com.example.commonlib.http.model.DealException
import com.example.commonlib.http.model.NetResult
import com.zs.zs_jetpack.http.RetrofitFactory
import com.zs.zs_jetpack.http.RetrofitManager

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/8 4:41 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
open class BaseModel {

    suspend fun <T : Any> callRequest(
        call: suspend () -> NetResult<T>
    ): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e))
        }
    }


    fun <T> buildService(service: Class<T>): T {
        return RetrofitFactory.factory().create(service)
    }
}
package com.example.commonlib.base

import com.example.commonlib.http.model.DealException
import com.example.commonlib.http.model.HttpResult
import com.example.commonlib.http.model.NetResult
import com.example.commonlib.http.model.ResultException
import com.zs.zs_jetpack.http.RetrofitFactory
import com.zs.zs_jetpack.http.RetrofitManager
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

    suspend fun <T : Any> handleResponse(
            response: HttpResult<T>,
            successBlock: (suspend CoroutineScope.() -> Unit)? = null,
            errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                NetResult.Error(
                        ResultException(
                                response.errorCode.toString(),
                                response.errorMsg
                        )
                )
            } else {
                successBlock?.let { it() }
                NetResult.Success(response.data)
            }
        }
    }

    fun <T> buildService(service: Class<T>): T {
        return RetrofitFactory.factory().create(service)
    }
}
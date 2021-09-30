package com.example.commonlib.http

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2021/9/23 10:32 上午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class ApiException(val errorCode: Int, private val errorMsg: String) : Throwable(errorMsg)
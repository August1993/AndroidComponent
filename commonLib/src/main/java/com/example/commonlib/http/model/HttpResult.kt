package com.example.commonlib.http.model

data class HttpResult<out T>(val errorCode: Int, val errorMsg: String, val data: T)
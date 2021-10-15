package com.example.commonlib.http.model


class ResultException(var errCode: String?, var msg: String?) : Throwable(msg)

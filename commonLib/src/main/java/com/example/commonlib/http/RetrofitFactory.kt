package com.zs.zs_jetpack.http

import com.example.commonlib.http.CacheInterceptor
import com.example.commonlib.http.HttpLoggingInterceptor
import com.example.commonlib.http.RequestInterceptor
import com.example.commonlib.util.FileUtils
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.security.AccessController.getContext
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * des Retrofit工厂类
 * @author zs
 * @date 2020-05-09
 */
object RetrofitFactory {
    private const val DEFAULT_TIMEOUT = 10000
    private const val BASE_URL = "https://www.wanandroid.com"

    //缓存100Mb
    private val okHttpClientBuilder: OkHttpClient.Builder
        get() {

            //设置Http缓存
            val cache = Cache(File(FileUtils.getCachePath(), "HttpCache"), 1024 * 1024 * 10)
            return OkHttpClient.Builder()
                .readTimeout(
                    DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                .connectTimeout(
                    DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                .addInterceptor(RequestInterceptor())
                .addInterceptor(getLogInterceptor())
                .addInterceptor(CacheInterceptor())
                .cache(cache)
        }

    fun factory(): Retrofit {
        val okHttpClient = okHttpClientBuilder.build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    /**
     * 获取日志拦截器
     */
    private fun getLogInterceptor(): Interceptor {
        //http log 拦截器
        return HttpLoggingInterceptor("OkHttp").apply {
            setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            setColorLevel(Level.INFO)
        }
    }


}
package com.example.commonlib.http;


import com.example.commonlib.util.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作　　者: chenpin<br>
 * 创建时间: 2017/10/30 下午4:59<br>
 * 版权声明: Copyright (C) 2013-2017 南京地平线网络科技有限公司<br>
 * 修改历史: 2017/10/30 1.0<br>
 * 文件描述: 缓存测量
 */
public class CacheInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //没网强制从缓存读取(必须得写，不然断网状态下，退出应用，或者等待一分钟后，就获取不到缓存）
        if (!NetworkUtils.isConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response response = chain.proceed(request);
        Response responseLatest;
        if (NetworkUtils.isConnected()) {
            // 有网失效由服务器控制
            int maxAge = response.cacheControl().maxAgeSeconds();
            responseLatest = response.newBuilder()
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();

        } else {
            // 没网失效3天
            int maxStale = 60 * 60 * 24 * 3;
            responseLatest = response.newBuilder()
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return responseLatest;
    }
}

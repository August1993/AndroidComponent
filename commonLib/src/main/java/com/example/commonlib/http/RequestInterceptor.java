package com.example.commonlib.http;

import android.os.Build;

import com.example.commonlib.util.DeviceUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作　　者: chenpin<br>
 * 创建时间: 2017/10/30 下午5:19<br>
 * 版权声明: Copyright (C) 2013-2017 南京地平线网络科技有限公司<br>
 * 修改历史: 2017/10/30 1.0<br>
 * 文件描述: 请求拦截器
 */
public class RequestInterceptor implements Interceptor {

    public static String CHANNEL = "";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        String version = DeviceUtils.getVersionName();
        String channel = "";
        Request.Builder builder = original.newBuilder()
                .header("platform", "android")
                .header("version", version)
                .header("User-Agent", "PeanutNovel/" + version + "(Android;" + Build.MODEL + ";"
                        + Build.VERSION.RELEASE + ")");
        builder.addHeader("channel", channel);
        Request request = builder.build();
        return chain.proceed(request);
    }
}

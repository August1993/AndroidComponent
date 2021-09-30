package com.example.commonlib.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;


import com.example.commonlib.base.BaseApplication;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 作　　者: chenpin<br>
 * 创建时间: 2017/10/25 上午9:46<br>
 * 版权声明: Copyright (C) 2013-2017 南京地平线网络科技有限公司<br>
 * 修改历史: 2017/10/25 1.0<br>
 * 文件描述: 网络状态工具类
 */
public final class NetworkUtils {

    /**
     * 获取活动网络信息
     * @return NetworkInfo
     */
    public static NetworkInfo getNetworkInfo(){
        ConnectivityManager cm = (ConnectivityManager) BaseApplication
                .getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo();
    }

    /**
     * 网络是否可用
     * @return
     */
    public static boolean isAvailable(){
        NetworkInfo info = getNetworkInfo();
        return info != null && info.isAvailable();
    }

    /**
     * 网络是否连接
     * @return
     */
    public static boolean isConnected(){
        NetworkInfo info = getNetworkInfo();
        return info != null && info.isConnected();
    }

    /**
     * 判断wifi是否连接状态
     * <p>需添加权限 {@code <uses-permission android:name="android.permission
     * .ACCESS_NETWORK_STATE"/>}</p>
     *
     * @param context 上下文
     * @return {@code true}: 连接<br>{@code false}: 未连接
     */
    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    public static boolean isNetworkProxy() {

        return isWifiProxy() || isVpnUsed();
    }
    /**
     * 是否使用代理(WiFi状态下的,避免被抓包)
     */
    private static boolean isWifiProxy(){

        String proxyAddress;
        int proxyPort;
        proxyAddress = System.getProperty("http.proxyHost");
        String portstr = System.getProperty("http.proxyPort");
        proxyPort = Integer.parseInt((portstr != null ? portstr : "-1"));
        System.out.println(proxyAddress + "~");
        System.out.println("port = " + proxyPort);

        return (!TextUtils.isEmpty(proxyAddress)) && (proxyPort != -1);
    }

    /**
     * 是否正在使用VPN
     */
    private static boolean isVpnUsed() {
        try {
            Enumeration<NetworkInterface> niList = NetworkInterface.getNetworkInterfaces();
            if(niList != null) {
                for (NetworkInterface intf : Collections.list(niList)) {
                    if(!intf.isUp() || intf.getInterfaceAddresses().size() == 0) {
                        continue;
                    }
                    LogUtils.d("-----", "isVpnUsed() NetworkInterface Name: " + intf.getName());
                    if ("tun0".equals(intf.getName()) || "ppp0".equals(intf.getName())){
                        return true; // The VPN is up
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

}

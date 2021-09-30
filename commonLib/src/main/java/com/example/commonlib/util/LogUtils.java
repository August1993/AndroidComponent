package com.example.commonlib.util;

import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.commonlib.BuildConfig;


/**
 * 作　　者: chenpin<br>
 * 创建时间: 2020/9/27 11:56 AM<br>
 * 版权声明: Copyright (C) 2013-Present 南京地平线网络科技有限公司<br>
 * 修改历史: 2020/9/27 1.0<br>
 * 文件描述: 日志工具
 */
public final class LogUtils {

    private static final String LOG_TYPE = "e";

    private static Boolean LOG_SWITCH = BuildConfig.DEBUG; // 日志文件总开关

    public static void d(String format, Object... msg) {
        d(LOG_TYPE, format, msg);
    }

    public static void i(String format, Object... msg) {
        i(LOG_TYPE, format, msg);
    }

    public static void w(String format, Object... msg) {
        w(LOG_TYPE, format, msg);
    }

    public static void e(String format, Object... msg) {
        e(LOG_TYPE, format, msg);
    }

    public static void d(String logType, String format, Object... msg) {
        log(Log.DEBUG, logType, format, msg);
    }

    public static void i(String logType, String format, Object... msg) {
        log(Log.INFO, logType, format, msg);
    }

    public static void w(String logType, String format, Object... msg) {
        log(Log.WARN, logType, format, msg);
    }

    public static void e(String logType, String format, Object... msg) {
        log(Log.ERROR, logType, format, msg);

    }

    private static void log(int priority, String logType, String format, Object... msg) {
        if (priority >= 2 && LOG_SWITCH) {
            Log.println(priority, logType, createMessage(format, msg));
        }
    }

    @NonNull
    private static String createMessage(String format, Object... msg) {
        if (TextUtils.isEmpty(format)) {
            return createMessage(msg);
        } else {
            try {
                return String.format(format, msg);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("d format = ");
                sb.append(format);
                sb.append("\n格式化失败 -> error = ");
                sb.append(Log.getStackTraceString(e));
                Log.e(LOG_TYPE, sb.toString());
                return format;
            }
        }
    }

    @NonNull
    private static String createMessage(Object... msg) {
        if (msg == null || msg.length == 0) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object append : msg) {
                sb.append(append);
            }
            return sb.toString();
        }
    }
}

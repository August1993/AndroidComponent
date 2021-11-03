package com.example.commonlib.update;

/**
 * 下载进度回调
 *
 */
public interface DownloadProgressCallBack {
     void downloadProgress(int progress);
     void downloadException(Exception e);
     void onInstallStart();
}

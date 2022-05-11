package com.androidapp.module.home.model;

import com.androidapp.module.home.model.bean.Banner;
import com.androidapp.module.home.model.service.RequestCenter;
import com.example.commonlib.base.BaseModel;
import com.zhpan.idea.net.common.IdeaApi;
import com.zhpan.idea.net.common.IdeaApiProxy;

import java.util.List;

import io.reactivex.Single;


/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2022/5/11 10:28 上午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
public class HomeModel extends BaseModel {
    public Single<List<Banner>> getBanner(){

        RequestCenter apiService = IdeaApi.getApiService(RequestCenter.class, "https://www.wanandroid.com");
       return apiService.getBanner() ;

    }

}

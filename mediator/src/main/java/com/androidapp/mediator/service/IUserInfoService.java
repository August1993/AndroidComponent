package com.androidapp.mediator.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2022/5/11 5:41 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
public interface IUserInfoService extends IProvider {
    void setUserName(String name);

    String getUserName();

}

package com.androidapp.module.mine.serviceimpl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.androidapp.mediator.router.AccountRouter;
import com.androidapp.mediator.service.IUserInfoService;

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2022/5/11 5:43 下午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
@Route(path = AccountRouter.SERVICE_INFO)
public class UserServiceImpl implements IUserInfoService {

    String userName = "";

    @Override
    public void setUserName(String name) {
        userName = name;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void init(Context context) {

    }
}

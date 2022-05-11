package com.androidapp.module.home.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.androidapp.module.home.model.HomeModel;
import com.androidapp.module.home.model.bean.Banner;
import com.example.commonlib.base.BaseModel;
import com.example.commonlib.base.BaseViewModel;
import com.rxjava.rxlife.RxLife;
import com.zhpan.idea.utils.RxUtil;
import com.zhpan.idea.utils.RxUtils;
import com.zhpan.idea.utils.ToastUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author : wangzhiyi
 *     time   : 2022/5/11 10:23 上午
 *     version: 1.0
 *     desc   :
 * </pre>
 */
public class HomeViewModel extends BaseViewModel<HomeModel> {

    private MutableLiveData<List<Banner>> mBannerLiveData;

    public HomeViewModel(@NonNull Application application) {
        super(application, new HomeModel());
        mBannerLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Banner>> getBannerLiveData(){
        return mBannerLiveData;
    }

    public void getBanner() {

        mModel.getBanner()
                .compose(RxUtils::toSimpleSingle)
                .as(bindLifecycle())
                .subscribe(new Consumer<List<Banner>>() {
                    @Override
                    public void accept(List<Banner> banners) throws Exception {
                        mBannerLiveData.setValue(banners);
                        ToastUtils.show(banners.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("getBanner", "accept: " + throwable);
                        ToastUtils.show("" + throwable);
                    }
                });
    }
}

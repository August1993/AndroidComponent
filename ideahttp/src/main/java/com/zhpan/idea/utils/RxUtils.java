package com.zhpan.idea.utils;
import org.jetbrains.annotations.NotNull;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作　　者: chenpin<br>
 * 创建时间: 2017/8/18 上午9:33<br>
 * 版权声明: Copyright (C) 2013-2017 南京地平线网络科技有限公司<br>
 * 修改历史: 2017/8/18 1.0<br>
 * 文件描述: RxUtils
 */
public final class RxUtils {

    @NotNull
    public static <T> SingleSource<T> toSimpleSingle(Single<T> upstream){
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NotNull
    public static <T> ObservableSource<T> toSimpleObservable(Observable<T> upstream){
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NotNull
    public static CompletableSource toSimpleCompletable(Completable upstream){
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NotNull
    public static <T> MaybeSource<T> toSimpleMaybe(Maybe<T> upstream){
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}

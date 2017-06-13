package com.xusangbo.basemoudle.baserx;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import rx.Observable;


public class RxManager {
    public RxBus mRxBus = RxBus.getInstance();
    //管理rxbus订阅
   // private Map<Class<?>, Flowable<?>> mFlowable = new HashMap<>();
    /*管理Observables 和 Subscribers订阅*/
    private CompositeDisposable  mCompositeDisposable = new CompositeDisposable();

    /**
     * RxBus注入监听
     * @param eventName
     * @param consumer
     */
    public <T>void on(Class<T> eventName, Consumer consumer) {
        Flowable<T> register = mRxBus.register(eventName);
     //   mFlowable.put(eventName, register);
        /*订阅管理*/

        register.observeOn(AndroidSchedulers.mainThread()).subscribe(consumer, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    /**
     * 单纯的Observables 和 Subscribers管理
     * @param m
     */
    public void add(Disposable m) {
        /*订阅管理*/
        mCompositeDisposable.add(m);
    }
    /**
     * 单个presenter生命周期结束，取消订阅和所有rxbus观察
     */
    public void clear() {
        mRxBus.unregisterAll();

        mCompositeDisposable.clear();// 取消所有订阅

    }
    //发送rxbus
    public void post(@NonNull Object obj) {
        mRxBus.post(obj);
    }
}

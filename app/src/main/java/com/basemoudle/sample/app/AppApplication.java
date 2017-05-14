package com.basemoudle.sample.app;

import com.xusangbo.basemodule.BuildConfig;
import com.xusangbo.basemoudle.base.BaseApplication;
import com.xusangbo.basemoudle.utils.LogUtils;

/**
 * Created by boxu on 2017/4/4.
 */

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logInit(BuildConfig.LOG_DEBUG);
    }
}

package com.basemoudle.sample.persenter;

import com.basemoudle.sample.bean.User;
import com.basemoudle.sample.contract.MVPContract;
import com.xusangbo.basemoudle.base.BaseRespose;
import com.xusangbo.basemoudle.baserx.RxSubscriber;

/**
 * Created by hasee on 2017/5/14.
 */

public class MVPPersenter extends MVPContract.Presenter {
    @Override
    public void postData() {
        mModel.postData().subscribe(new RxSubscriber<BaseRespose<User>>(mContext, false) {
            @Override
            protected void _onNext(BaseRespose<User> userBaseRespose) {
//处理请求返回数据
            }

            @Override
            protected void _onError(String message) {

            }
        });
    }
}

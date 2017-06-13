package com.basemoudle.sample.model;

import com.basemoudle.sample.api.Api;
import com.basemoudle.sample.bean.User;
import com.basemoudle.sample.contract.MVPContract;
import com.xusangbo.basemoudle.base.BaseRespose;
import com.xusangbo.basemoudle.baserx.RxSchedulers;
import io.reactivex.Flowable;


/**
 * Created by hasee on 2017/5/14.
 */

public class MVPModel implements MVPContract.Model {
    @Override
    public Flowable<BaseRespose<User>> postData() {
        return Api.getDefault().postData().compose(RxSchedulers.<BaseRespose<User>>io_main());
    }
}

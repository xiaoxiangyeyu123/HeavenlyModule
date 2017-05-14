package com.basemoudle.sample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.basemoudle.sample.R;
import com.basemoudle.sample.contract.MVPContract;
import com.basemoudle.sample.model.MVPModel;
import com.basemoudle.sample.persenter.MVPPersenter;
import com.xusangbo.basemoudle.base.BaseActivity;

/**
 * Created by hasee on 2017/5/14.
 */

public class MVPActivity extends BaseActivity<MVPPersenter, MVPModel> implements MVPContract.View {
    private Button bt_demo;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        bt_demo = (Button) findViewById(R.id.bt_demo);
        bt_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.postData();

            }
        });
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}

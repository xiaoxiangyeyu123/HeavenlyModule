package com.basemoudle.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.basemoudle.sample.activity.MVCActivity;
import com.basemoudle.sample.activity.MVPActivity;
import com.xusangbo.basemoudle.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_mvc;
    private Button bt_mvp;


    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        bt_mvc = (Button) findViewById(R.id.bt_mvc);
        bt_mvp = (Button) findViewById(R.id.bt_mvp);
        bt_mvc.setOnClickListener(this);
        bt_mvp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_mvc:
                readyGo(MVCActivity.class);
                break;
            case R.id.bt_mvp:
                readyGo(MVPActivity.class);
                break;
        }
    }
}

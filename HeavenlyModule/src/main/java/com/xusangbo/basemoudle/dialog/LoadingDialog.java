package com.xusangbo.basemoudle.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

/**
 * Created by boxu on 2017/4/1.
 */

public class LoadingDialog {


    private static final String TAG = "LoadingDialog";

    /**
     * 加载进度
     */
    private static ProgressDialog progressDialog;

    public static final int PROGRESS_LOADING = 0;


    public static void showLoadingDialog(Context context, int type) {

        showLoadingDialog(context, type, null, 0);

    }

    public static void showLoadingDialog(Context context, int type, String message) {

        showLoadingDialog(context, type, message, 0);

    }
    public static void showLoadingDialog(Context context, int type, int drawableId) {

        showLoadingDialog(context, type, null, drawableId);

    }
    public static void showLoadingDialog(Context context, int type, String message, int drawableId) {
        if (null == context) {
            return;
        }
        switch (type) {
            case PROGRESS_LOADING:
                showProgressLoading(context, message);
                break;


            default:
                showProgressLoading(context, message);
                break;
        }
    }
    private static void showProgressLoading(Context context, String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(null == message ? "请稍候" : message);
        }
        progressDialog.setCancelable(true);
        try {
            progressDialog.show();
        } catch (Exception e) {
            Log.e(TAG, "progressDialog启动失败");
        }
    }
    /**
     * 默认载入loading
     *
     * @param context
     */
    public static void showLoadingDialog(Context context) {
        showLoadingDialog(context, PROGRESS_LOADING);
    }
    /**
     * 取消loading
     */
    public static void cancelLoadingDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
                Log.e(TAG, "progressDialog销毁失败");
            }
        }
        progressDialog = null;
    }


}

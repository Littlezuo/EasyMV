package com.jaydenxiao.common.commonwidget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jaydenxiao.common.R;

/**
 * Created by baidu on 15/8/31.
 */
public class XProgressDialog extends ProgressDialog {

    // theme类型

    public static final int THEME_CIRCLE = 2;
    public static final int THEME_IMAGE = 3;
    private int drawableRes = -1 ;

    protected View progressBar;
    protected TextView message;
    protected String messageText = "正在加载中...";
    protected int theme = THEME_CIRCLE;
    Context mContext;
    private static XProgressDialog progressDialog;

    public XProgressDialog(Context context) {
        super(context);
        mContext = context;
    }

    public XProgressDialog(Context context, String message) {
        super(context);
        this.messageText = message;
        mContext = context;
    }

    public XProgressDialog(Context context, int theme) {
        super(context);
        this.theme = theme;
        mContext = context;
    }

    public XProgressDialog(Context context, String message, int theme) {
        super(context);
        this.messageText = message;
        this.theme = theme;
        mContext = context;
    }

    public XProgressDialog(Context context, String message, int theme,int drawbleRes) {
        super(context);
        this.messageText = message;
        this.theme = theme;
        mContext = context;
        this.drawableRes = drawbleRes;
    }
    public XProgressDialog(Context context,int theme,int drawbleRes) {
        super(context);
        this.theme = theme;
        mContext = context;
        this.drawableRes = drawbleRes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (theme) {

            case THEME_IMAGE:
                setContentView(R.layout.view_xprogressdialog_image_progress);
                break;
            default:
                setContentView(R.layout.view_xprogressdialog_circle_progress);
                break;
        }
        message = (TextView) findViewById(R.id.message);
        if (message != null && !TextUtils.isEmpty(messageText)) {
            message.setText(messageText);
        }

        if (theme == THEME_IMAGE) {
            if(drawableRes != -1) {
                GifMovieView gif = (GifMovieView) findViewById(R.id.gif_progress);
                gif.setMovieResource(drawableRes);
            }
        }
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setMessage(String message) {
        this.messageText = message;
    }

    /**
     * 获取显示文本控件
     *
     * @return
     */
    protected TextView getMessageView() {
        return message;
    }

    /**
     * 获取显示进度的控件
     *
     * @return
     */
    protected View getProgressView() {
        return progressBar;
    }

    @Override
    public void show() {
        super.show();
    }

    public static XProgressDialog showLoading(Context context, String msg) {
        progressDialog = new XProgressDialog(context,msg);
        progressDialog.show();
        return progressDialog;
    }

}

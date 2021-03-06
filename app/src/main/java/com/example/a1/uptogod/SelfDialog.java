package com.example.a1.uptogod;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 创建自定义的dialog
 **/
public class SelfDialog extends Dialog {

    public SelfDialog(Context context) {
        super(context, R.style.MyDialog);
    }


    private Button details;//详情按钮
    private Button spin;//再次旋转按钮
    private TextView titleTv;//消息标题文本
    private TextView messageTv;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //详情文本和再次旋转文本 的显示内容
    private String detailsStr, spinStr;
    private onSpinOnclickListener SpinClickListener;//再次旋转 按钮被点击了的监听器
    private onDetailsOnclickListener detailsOnclickListener;//详情 按钮被点击了的监听器

    /**
     * 设置"再次旋转"按钮的显示内容和监听
     *
     * @param str
     * @param onSpinOnclickListener
     */
    public void setSpinOnclickListener(String str, onSpinOnclickListener onSpinOnclickListener) {
        if (str != null) {
            spinStr = str;
        }
        this.SpinClickListener = onSpinOnclickListener;
    }

    /**
     * 设置"详情"按钮的显示内容和监听
     *
     * @param str
     * @param onDetailsOnclickListener
     */
    public void setDetailsOnclickListener(String str, onDetailsOnclickListener onDetailsOnclickListener) {
        if (str != null) {
            detailsStr = str;
        }
        this.detailsOnclickListener = onDetailsOnclickListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog_layout);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的“详情”和“再次旋转”监听器
     */
    private void initEvent() {
        //设置“详情”按钮被点击后，向外界提供监听
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailsOnclickListener != null) {
                    detailsOnclickListener.onDetailsClick();
                }
            }
        });
        //设置“再次旋转”按钮被点击后，向外界提供监听
        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SpinClickListener != null) {
                    SpinClickListener.onSpinClick();
                }
            }
        });
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            titleTv.setText(titleStr);
        }
        if (messageStr != null) {
            messageTv.setText(messageStr);
        }
        //如果设置按钮的文字
        if (detailsStr != null) {
            details.setText(detailsStr);
        }
        if (spinStr != null) {
            spin.setText(spinStr);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        details = (Button) findViewById(R.id.details);
        spin = (Button) findViewById(R.id.spin);
        titleTv = (TextView) findViewById(R.id.title);
        messageTv = (TextView) findViewById(R.id.message);
    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    /**
     * 设置“详情”按钮和“再次旋转”被点击的接口
     */
    public interface onDetailsOnclickListener {
        void onDetailsClick();
    }

    public interface onSpinOnclickListener {
        void onSpinClick();
    }
}


package com.example.a1.uptogod;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.Random;


/**
 * Created by 1 on 2017/5/9.
 */

public class MyRotateView extends View {

    int countN;
    private SelfDialog selfDialog;
    static RotateActivity rotateActivity;
    float pointer_center_y;
    private Paint mBitPaint;
    private  Bitmap mBitmap;
    private float rotate_angle;
    private static final int[] COLORS = {
            0xFFFFAEB9,//粉红色0x00FF0000
            0xFFFFF68F,//粉黄色
            0xFF7CCD7C,//粉绿色
            0xFFB0E2FF,//粉蓝色
            0xFFFF8C69,//桔色
            0xFF607B8B,//青色
            0xFF9370DB,//淡紫色
            0xFF6495ED,//深蓝色
            0xFFFF4040,//淡红色
            0xFF7CFC00//淡绿色
    };

    public MyRotateView(Context context) {
        super(context);
        initPaint();
    }

    public MyRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, (int) (width / 0.783)); /** modified rotating_pie size */
    }

    @Override
    protected void onDraw(Canvas canvas) {

        /**画转盘图 & 数字**/
        RectF rect;
        int width = getWidth();
        int height = getHeight();
        float center_x;
        float center_y;
        float r;
        if(RotateActivity.frame_pic.equals("frame1")) {
            center_x = width * 175/350f;
            center_y = height *178/447f;
            r = width * 101/350f;
        }else if(RotateActivity.frame_pic.equals("frame2")) {
            center_x = width * 199/350f;
            center_y = height * 304/447f;
            r = width * 129/350f;
        }else if(RotateActivity.frame_pic.equals("frame3")) {
            center_x = width * 175/350f;
            center_y = height * 213/447f;
            r = width *93/350f;
        }else {
            center_x = width * 129/350f;
            center_y = height * 317/447f;
            r = width *95/350f;
        }
        rect = new RectF(center_x - r, center_y - r, center_x + r, center_y + r);
        int n = ((RotateActivity)getContext()).count_num;
        float angle = 360f / n;

        mBitPaint.setStyle(Paint.Style.FILL);

        Paint text_paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        text_paint.setTextSize(40);
        text_paint.setColor(Color.BLACK);
        for (int i = 0; i < n; ++i) {
            mBitPaint.setColor(COLORS[i]);
            canvas.drawArc(rect, angle * (i - 1) - 90, angle, true, mBitPaint);//画“转盘弧形”
            String text = i+1+"";
            canvas.save();
            canvas.rotate((angle * i -angle/2),center_x,center_y);
            canvas.drawText(text, center_x - text_paint.measureText(text) / 2, center_y - r + text_paint.getTextSize() * 1.2f,text_paint); //画数字
            canvas.restore();
        }




        /**画指针图**/
        float pointer_center_x;
        //指针为“point1”的情况下：
        pointer_center_x = (float) 15 * width/350;
        if(RotateActivity.pointer_pic.equals("pointer1") && RotateActivity.frame_pic.equals("frame1") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_1);
        }else if(RotateActivity.pointer_pic.equals("pointer1") && RotateActivity.frame_pic.equals("frame2") ) {
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_1);
        }else if(RotateActivity.pointer_pic.equals("pointer1") && RotateActivity.frame_pic.equals("frame3") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_1);
        }else if(RotateActivity.pointer_pic.equals("pointer1") && RotateActivity.frame_pic.equals("frame4") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_1);
        }
        //指针为“point2”的情况下：
        if(RotateActivity.pointer_pic.equals("pointer2") && RotateActivity.frame_pic.equals("frame1") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_2);
        }else if(RotateActivity.pointer_pic.equals("pointer2") && RotateActivity.frame_pic.equals("frame2") ) {
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_2);
        } else if(RotateActivity.pointer_pic.equals("pointer2") && RotateActivity.frame_pic.equals("frame3") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_2);
        }else if(RotateActivity.pointer_pic.equals("pointer2") && RotateActivity.frame_pic.equals("frame4") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_2);
        }
        //指针为“point3”的情况下：
        if(RotateActivity.pointer_pic.equals("pointer3") && RotateActivity.frame_pic.equals("frame1") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_3);
        }else if(RotateActivity.pointer_pic.equals("pointer3") && RotateActivity.frame_pic.equals("frame2") ) {
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_3);
        }else if(RotateActivity.pointer_pic.equals("pointer3") && RotateActivity.frame_pic.equals("frame3") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_3);
        }else if(RotateActivity.pointer_pic.equals("pointer3") && RotateActivity.frame_pic.equals("frame4") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_3);
        }
        //指针为“point4”的情况下：
        if(RotateActivity.pointer_pic.equals("pointer4") && RotateActivity.frame_pic.equals("frame1") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_4);
        }else if(RotateActivity.pointer_pic.equals("pointer4") && RotateActivity.frame_pic.equals("frame2") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_4);
        }
        else if(RotateActivity.pointer_pic.equals("pointer4") && RotateActivity.frame_pic.equals("frame3") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_4);
        }else if(RotateActivity.pointer_pic.equals("pointer4") && RotateActivity.frame_pic.equals("frame4") ){
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.pointer_4);
        }
        mBitmap = Bitmap.createScaledBitmap(mBitmap, (int) (r * mBitmap.getWidth() / mBitmap.getHeight()), (int) r, true);//指针图缩放到合适尺寸

        if(RotateActivity.pointer_pic.equals("pointer1")){
            pointer_center_y = 23 * height/447;
        }else if(RotateActivity.pointer_pic.equals("pointer2")){
            pointer_center_y = 9 * height/447;
        }else if(RotateActivity.pointer_pic.equals("pointer3")){
            pointer_center_y = 6 * height/447;
        }else if(RotateActivity.pointer_pic.equals("pointer4")){
            pointer_center_y = 10 * height/447;
        }

        if(RotateActivity.rotate_direction.equals("clockwise")){//顺时针旋转的情况：(画指针)
            canvas.save();
            canvas.rotate(rotate_angle, center_x, center_y);
            canvas.drawBitmap(mBitmap,center_x-pointer_center_x, center_y - r + pointer_center_y,mBitPaint);//画指针
            canvas.restore();
        }else if( RotateActivity.rotate_direction.equals("antiClockwise")){//逆时针旋转的情况：(画指针)
            float balance_angle = rotate_angle % 360;
            canvas.save();
            canvas.rotate(360-balance_angle, center_x, center_y);
            canvas.drawBitmap(mBitmap,center_x-pointer_center_x, center_y - r + pointer_center_y,mBitPaint);//画指针
            canvas.restore();
        }

    }


    private boolean reserve;

    private void initPaint() {
        mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        post(new Runnable() {
            @Override
            public void run() {
                startRotatingThread();
            }
        });
    }

    private  void startRotatingThread(){
        Random random = new Random();
        final int random_plus = random.nextInt(24);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 700 + random_plus*15; ++i) {
                    rotate_angle = RotateActivity.friction_rotate_angle * i;
                    postInvalidate();
                    try {
                        Thread.sleep(RotateActivity.rotate_sleepTime);//设置“转速”
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

/** 自定义dialog**/
                post(new Runnable() {
                    @Override
                    public void run() {
                        selfDialog = new SelfDialog(rotateActivity);
                        countN = rotateActivity.getIntent().getIntExtra("NumOfOne_counts",2);

                        int pointerResult = 1;
                        float perPieAngle = 360f / countN;
                        float balanceAngle = rotate_angle % 360;
                       if( RotateActivity.rotate_direction.equals("clockwise")){//顺时针的情况
                           if(balanceAngle < perPieAngle){
                               pointerResult = 2;
                           }else if (balanceAngle == 0){
                               pointerResult = 1;
                           } else {
                               float balance = balanceAngle / perPieAngle;
                               int balanceInt = (int) balance;
                               if (balance > balanceInt) {
                                   pointerResult = pointerResult + balanceInt + 1;
                                   if (pointerResult > countN) {
                                       pointerResult = 1;
                                   }
                               } else {
                                   pointerResult = pointerResult + balanceInt;
                               }
                           }
                       } else {//逆时针的情况
                           pointerResult = ((int) ((360 - balanceAngle) / perPieAngle) + 1) % countN + 1;
                       }

                        selfDialog.setTitle(countN +" 选 1");
                        selfDialog.setMessage("你选择的是：" + pointerResult);
                        final int finalPointerResult = pointerResult;
                        selfDialog.setDetailsOnclickListener("详情", new SelfDialog.onDetailsOnclickListener() {
                            @Override
                            public void onDetailsClick() {

                                reserve =  true;
                                Intent intent = new Intent(rotateActivity,DetailsActivity.class);
                                int countsNums= rotateActivity.getIntent().getIntExtra("NumOfOne_counts",2);
                                intent.putExtra("NumOfOne_counts",countsNums);
                                String answerStr = rotateActivity.getIntent().getStringExtra("answers");
                                intent.putExtra("resPic",rotateActivity.getIntent().getStringExtra("resPic"));
                                intent.putExtra("question",rotateActivity.getIntent().getStringExtra("question"));
                                intent.putExtra("answers",answerStr);
                                intent.putExtra("指针结果", finalPointerResult);

                                rotateActivity.startActivityForResult(intent,RotateActivity.REQUEST_DETAILS);
                                selfDialog.dismiss();
                            }
                        });
                        selfDialog.setSpinOnclickListener("再次旋转", new SelfDialog.onSpinOnclickListener() {
                            @Override
                            public void onSpinClick() {
                                reserve = true;
                                selfDialog.dismiss();
                                startRotatingThread();
                            }
                        });
                        selfDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { //设置dialog的监听事件
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                if (!reserve) {
                                    ((Activity) getContext()).finish();
                                }
                                reserve = false;
                            }
                        });
                        selfDialog.show();
                    }
                });
            }

        }).start();
 }

}



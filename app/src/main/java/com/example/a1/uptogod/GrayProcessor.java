package com.example.a1.uptogod;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;

/**
 * Created by 1 on 2017/5/2.
 */

public class GrayProcessor extends BasePostprocessor { //图片后处理（灰度）

    private CacheKey mKey;

    public GrayProcessor(@Nullable Uri uri) {
        if (uri != null) {
            mKey = new SimpleCacheKey(uri.toString());
        }
    }

    @Override
    public String getName() {
        return "grayProcessor";
    }

    @Override
    public void process(Bitmap destBitmap, Bitmap sourceBitmap) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        Paint paint = new Paint();
        paint.setColorFilter(filter);
        Canvas canvas = new Canvas(destBitmap);
        canvas.drawBitmap(sourceBitmap, 0, 0, paint);
    }

    @Override
    public CacheKey getPostprocessorCacheKey() {
        return mKey;
    }
}

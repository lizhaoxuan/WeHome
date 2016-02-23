package com.zhaoxuan.wehome.support.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.module.log.WLog;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public class ViewUtils {

    private ViewUtils() {
    }

    public static void CreateBlurView(Bitmap bkg, ViewGroup view) {
        long startMs = System.currentTimeMillis();
        float scaleFactor = 1;
        float radius = 15;

        Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth() / scaleFactor),
                (int) (view.getMeasuredHeight() / scaleFactor), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft() / scaleFactor, -view.getTop() / scaleFactor);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), paint);


        RenderScript rs = RenderScript.create(WeHomeApplication.getInstance());
        Allocation overlayAlloc = Allocation.createFromBitmap(
                rs, overlay);
        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(
                rs, Element.U8_4(rs));
        blur.setInput(overlayAlloc);
        blur.setRadius(radius);
        blur.forEach(overlayAlloc);
        overlayAlloc.copyTo(overlay);
        rs.destroy();

        view.setBackground(new BitmapDrawable(WeHomeApplication.getInstance().getResources(), overlay));
        //模糊化结束后，才可以初始化布局
        WLog.i("TAG", System.currentTimeMillis() - startMs + "ms");
    }

}

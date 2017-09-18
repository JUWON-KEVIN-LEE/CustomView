package com.immymemine.kevin.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by quf93 on 2017-09-18.
 */

public class CustomView extends View {
    // 내가 소스코드에서 생성할 때
    public CustomView(Context context) {
        super(context);
    }
    // xml
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(); // 겉모양을 결정하는 도구
        paint.setColor(Color.BLACK);

        canvas.drawRect(100,100,200,200,paint);
    }
}

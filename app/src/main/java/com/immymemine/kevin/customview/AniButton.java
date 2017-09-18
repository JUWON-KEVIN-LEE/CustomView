package com.immymemine.kevin.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by quf93 on 2017-09-18.
 */

public class AniButton extends AppCompatButton implements View.OnTouchListener {
    boolean b = false;
    // AppCompat < android support package 에 있다 version 호환성 문제를 해결해준다.
    public AniButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AniButton);
        int size = typedArray.getIndexCount();

        for(int i=0; i<size; i++) {
            int current_attr = typedArray.getIndex(i);
            switch (current_attr) {
                case R.styleable.AniButton_animation:
                    String animation = typedArray.getString(current_attr);
                    if("true".equals(animation)) {
                        String currentText = getText().toString();
                        setText("[Animation]\n" + currentText);
                        this.b = true;
                    }
                    break;
            }
        }
        setOnTouchListener(this);
    }

    private void anim() {
        if(b) {
            ObjectAnimator aniX = ObjectAnimator.ofFloat(this, "scaleX", 1.2f, 1f);
            ObjectAnimator aniY = ObjectAnimator.ofFloat(this, "scaleY", 1.2f, 1f);
            AnimatorSet aniSet = new AnimatorSet();
            aniSet.playTogether(aniX, aniY);
            aniSet.setDuration(1000);
            aniSet.start();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                anim();
                break;
        }
        return false;
    }
}

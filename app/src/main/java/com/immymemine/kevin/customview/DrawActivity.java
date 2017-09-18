package com.immymemine.kevin.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by quf93 on 2017-09-18.
 */

public class DrawActivity extends AppCompatActivity {
    FrameLayout stage;
    RadioGroup radioGroup;
    DrawView drawView;
    SeekBar seekBar;
    TextView seekBarResultView;
    int progrss;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        stage = (FrameLayout)findViewById(R.id.stage);
        drawView = new DrawView(this);
        drawView.init();
        stage.addView(drawView);

        progrss = 50;
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarResultView = (TextView) findViewById(R.id.seekBarResultView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progrss = progress;
                seekBarResultView.setText(String.valueOf(progress));
                int color = drawView.pathTool.getColor();
                drawView.makeTool();
                drawView.setWidth(progress);
                drawView.setColor(color);
                drawView.sendToolToCP();
                drawView.addTool();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int id) {
                switch (id) {
                    case R.id.cyan:
                        drawView.makeTool();
                        drawView.setWidth(progrss);
                        drawView.setColor(Color.CYAN);
                        drawView.sendToolToCP();
                        drawView.addTool();
                        break;
                    case R.id.magenta:
                        drawView.makeTool();
                        drawView.setWidth(progrss);
                        drawView.setColor(Color.MAGENTA);
                        drawView.sendToolToCP();
                        drawView.addTool();
                        break;
                    case R.id.yellow:
                        drawView.makeTool();
                        drawView.setWidth(progrss);
                        drawView.setColor(Color.YELLOW);
                        drawView.sendToolToCP();
                        drawView.addTool();
                        break;
                    case R.id.black:
                        drawView.makeTool();
                        drawView.setWidth(progrss);
                        drawView.setColor(Color.BLACK);
                        drawView.sendToolToCP();
                        drawView.addTool();
                        break;
                }
            }
        });
    }
}

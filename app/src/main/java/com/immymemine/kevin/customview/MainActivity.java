package com.immymemine.kevin.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Custom View
 * 1. attrs.xml  2. widget 상속 받아서 재정의  3. custom 한 위젯을 layout.xml 태그로 사용
 */

public class MainActivity extends AppCompatActivity {
    ConstraintLayout stage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.aniButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
            }
        });

        stage = (ConstraintLayout)findViewById(R.id.stage);
        CustomView cv = new CustomView(this);
        stage.addView(cv);

        findViewById(R.id.goToDraw).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrawActivity.class);
                startActivity(intent);
            }
        });
    }
}

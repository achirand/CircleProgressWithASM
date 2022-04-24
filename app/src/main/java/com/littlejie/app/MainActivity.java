package com.littlejie.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.littlejie.circleprogress.CircleProgress;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    private Button mBtnResetAll;
    private CircleProgress mCircleProgress1;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnResetAll = (Button) findViewById(R.id.btn_reset_all);
        Button add = (Button) findViewById(R.id.add);
        Button reduce = (Button) findViewById(R.id.reduce);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float newValue = mCircleProgress1.getValue() + 1;
                int iValue = (int)newValue;
                mCircleProgress1.setValue(iValue);
                Log.i(TAG, "add newValue = " + iValue);
            }
        });

        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float value = mCircleProgress1.getValue() - 1;

                int ivalue = (int)value;
                if (ivalue < 0) ivalue = 0;
                if(ivalue<0.1) ivalue = 0;
                Log.i(TAG, "reduce ivalue = " + ivalue);
                mCircleProgress1.setValue(ivalue);
            }
        });


        mCircleProgress1 = (CircleProgress) findViewById(R.id.circle_progress_bar1);

        mBtnResetAll.setOnClickListener(this);
        mCircleProgress1.setOnClickListener(this);

        mRandom = new Random();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reset_all:
                mCircleProgress1.reset();
                break;
            case R.id.circle_progress_bar1:
                mCircleProgress1.setValue(mRandom.nextInt((int) mCircleProgress1.getMaxValue()));
                break;
        }
    }
}

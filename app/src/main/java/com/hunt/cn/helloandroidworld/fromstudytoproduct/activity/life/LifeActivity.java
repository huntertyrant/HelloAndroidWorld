package com.hunt.cn.helloandroidworld.fromstudytoproduct.activity.life;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hunt.cn.helloandroidworld.R;

public class LifeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("LifeActivity","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i("LifeActivity","onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.i("LifeActivity","onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("LifeActivity","onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("LifeActivity","onResume");
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("LifeActivity","onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        Log.i("LifeActivity","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("LifeActivity","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("LifeActivity","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.i("LifeActivity","onWindowFocusChanged");
        super.onWindowFocusChanged(hasFocus);
    }

}

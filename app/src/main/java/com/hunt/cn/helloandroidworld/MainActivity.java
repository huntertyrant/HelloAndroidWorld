package com.hunt.cn.helloandroidworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_to_cuc).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("cua");//隐式意图
            startActivity(intent);
        });
        findViewById(R.id.btn_to_aalv).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("aalv");//隐式意图
            startActivity(intent);
        });
        findViewById(R.id.btn_to_salv).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("salv");//隐式意图
            startActivity(intent);
        });
        findViewById(R.id.btn_to_balv).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("balv");//隐式意图
            startActivity(intent);
        });
        findViewById(R.id.btn_to_stfm).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("stfm");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_vwpg).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("vwpg");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_vpwf).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("vpwf");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_vpwt).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("vpwt");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_rcle).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("rcle");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_mv).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("mv");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_ml).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("ml");
            startActivity(intent);
        });
        findViewById(R.id.btn_to_muv).setOnClickListener((view) -> {
            Intent intent=new Intent();
            intent.setAction("muv");
            startActivity(intent);
        });
    }
}

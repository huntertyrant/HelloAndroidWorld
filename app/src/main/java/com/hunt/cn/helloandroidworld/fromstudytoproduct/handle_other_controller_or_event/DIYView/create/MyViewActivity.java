package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hunt.cn.helloandroidworld.R;

public class MyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        findViewById(R.id.my_view).setOnClickListener(v -> Toast.makeText(this, "第一个自定义控件", Toast.LENGTH_SHORT).show());
    }
}

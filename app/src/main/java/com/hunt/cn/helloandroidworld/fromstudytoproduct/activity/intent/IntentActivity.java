package com.hunt.cn.helloandroidworld.fromstudytoproduct.activity.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.hunt.cn.helloandroidworld.R;
import com.hunt.cn.helloandroidworld.fromstudytoproduct.activity.life.LifeActivity;

public class IntentActivity extends AppCompatActivity {
    
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        btn=findViewById(R.id.life_btn);
        btn.setOnClickListener((view) -> gotoSecondaryActivity());
    }

    private void gotoSecondaryActivity() {
        Intent toSecondary=new Intent();
        //this是当前Activity，**.class是需要跳转到的Activity
        //显示意图:跳转的Activity没有在manifests文件中注册,需要传递.class
        //隐式意图:调用Intent的setAction方法将注册过的Activity的自定义名称参数("SecondActivity")传入
        //注册格式为:
        //          <activity android:name=".fromstudytoproduct.activity.life.LifeActivity">
        //              <intent-filter>
        //                  <action android:name="SecondActivity" /><!-- name自定义 -->
        //                  <category android:name="android.intent.category.DEFAULT" />
        //              </intent-filter>
        //          </activity>
        //添加到application节点内
        toSecondary.setClass(this, LifeActivity.class);
        //通过Intent的putExtra存入信息类似于Map的put,是键值对信息
        //可以直接将信息存入Intent,也可以将信息存入新实例化的Bundle对象中(bundle.putInt/.putString/etc.)再将Bundle对象存入Intent(intent.putExtras(bundle))
        //在将要跳转的Activity中调用getIntent获取该Intent对象,通过getExtra直接获取信息或者通过getExtras获取Bundle对象后再通过Bundle对象获取信息(bundle.getInt/.getString/etc.)
        //***自定义对象只允许通过Bundle对象的putSerializable("123",T)和(T)get("123)来存储传递和提取
        toSecondary.putExtra("name","huntertyrant");
        //调用Activity的startActivity进行跳转
        //在将要跳转的Activity中添加按钮设置监听对象并调取监听对象的finish方法可以返回第一个Activity
        startActivity(toSecondary);
    }

}

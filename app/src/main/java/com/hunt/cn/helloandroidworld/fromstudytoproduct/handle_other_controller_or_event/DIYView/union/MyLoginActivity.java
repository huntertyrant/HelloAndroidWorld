package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.union;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hunt.cn.helloandroidworld.R;

public class MyLoginActivity extends AppCompatActivity {

    private LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        loginView=findViewById(R.id.login_page);
        loginView.setTitleText("微博");
        loginView.setLoginButtonText("登录");
    }
}

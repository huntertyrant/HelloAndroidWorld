package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.union;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hunt.cn.helloandroidworld.R;

public class LoginView extends FrameLayout {

    private Button loginButton;
    private TextView titleText;
    private EditText editText;

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_login_view,this);
        titleText=findViewById(R.id.login_title);
        editText=findViewById(R.id.login_pwd);
        loginButton=findViewById(R.id.login_btn);
        loginButton.setOnClickListener(v -> Toast.makeText(context,"欢迎登录"+titleText.getText().toString()+",您的密码是"+editText.getText().toString(),Toast.LENGTH_LONG).show());
    }

    public void setTitleText(String text){
        titleText.setText(text);
    }

    public void setLoginButtonText(String text){
        loginButton.setText(text);
    }

}

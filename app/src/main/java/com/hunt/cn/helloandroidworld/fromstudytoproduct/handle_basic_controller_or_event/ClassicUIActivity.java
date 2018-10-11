package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_basic_controller_or_event;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

import com.hunt.cn.helloandroidworld.R;

public class ClassicUIActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuc);
        findViewById(R.id.show_toast).setOnClickListener((view) -> {
            Toast.makeText(ClassicUIActivity.this,"我是长时间Toast",Toast.LENGTH_LONG).show();
            Toast.makeText(ClassicUIActivity.this,"我是短时间Toast",Toast.LENGTH_SHORT).show();
        });
        findViewById(R.id.show_dialog).setOnClickListener((view) -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(ClassicUIActivity.this);
            builder.setTitle("这是一个警告对话框");
            builder.setMessage("正在显示的是包含多个按钮以及一个美女图片的警告对话框");
            builder.setIcon(R.drawable.meinv);
            builder.setPositiveButton("确定",(dialog,which) -> {
                Toast.makeText(ClassicUIActivity.this,"警告对话框的\"确定\"按钮被点击",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            });
            builder.setNegativeButton("以后再说",(dialog,which) -> {
                Toast.makeText(ClassicUIActivity.this,"警告对话框的\"以后再说\"按钮被点击",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            });
            builder.setNeutralButton("忽略",(dialog,which) -> {
                Toast.makeText(ClassicUIActivity.this,"警告对话框的\"忽略\"按钮被点击",Toast.LENGTH_LONG).show();
                dialog.cancel();
            });
            builder.setCancelable(false);//使用模态,必须对按钮操作才能使流程继续
            builder.show();
        });
        findViewById(R.id.short_click).setOnClickListener((view) -> Toast.makeText(ClassicUIActivity.this,"常规点击事件触发",Toast.LENGTH_LONG).show());
        findViewById(R.id.long_click).setOnLongClickListener((view) -> {
            Toast.makeText(ClassicUIActivity.this,"长按事件触发",Toast.LENGTH_LONG).show();
            return true;
        });
        findViewById(R.id.touch).setOnTouchListener((view,event) -> {
            Toast.makeText(ClassicUIActivity.this,"触摸事件触发",Toast.LENGTH_LONG).show();
            return false;
        });
        findViewById(R.id.key_event).setOnKeyListener((view,keyCode,event) -> {
            switch(event.getAction()){
                case KeyEvent.ACTION_DOWN:
                    Toast.makeText(ClassicUIActivity.this,"按键事件触发,按键落下",Toast.LENGTH_LONG).show();
                    break;
                case KeyEvent.ACTION_UP:
                    EditText tet=(EditText)view;
                    Toast.makeText(ClassicUIActivity.this,"按键事件触发,按键弹起,键入的是:"+tet.getText().toString(),Toast.LENGTH_LONG).show();
            }
            return false;
        });
        Spinner sp=findViewById(R.id.selector);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ClassicUIActivity.this, "下拉选事件触发,当前位置为:" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ClassicUIActivity.this, "什么也没有被选中" , Toast.LENGTH_LONG).show();
            }
        });
        RadioGroup rg=findViewById(R.id.radios);
        rg.setOnCheckedChangeListener((group,checkedId) -> {
            RadioButton rb=findViewById(checkedId);
            Toast.makeText(ClassicUIActivity.this,"单选事件触发,当前选择为:"+rb.getText().toString(),Toast.LENGTH_LONG).show();
            rb.setOnFocusChangeListener((view,hasFocus) -> {
                if(hasFocus)
                    Toast.makeText(ClassicUIActivity.this,"焦点事件触发,选项"+rb.getText().toString()+"获得焦点",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ClassicUIActivity.this,"焦点事件触发,选项"+rb.getText().toString()+"失去焦点",Toast.LENGTH_SHORT).show();
            });
        });
        findViewById(R.id.btn_cuc_return).setOnClickListener((view) -> finish());
    }

}

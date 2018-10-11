package com.hunt.cn.helloandroidworld.fromstudytoproduct.activity.startmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.hunt.cn.helloandroidworld.R;

public class StartModelActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        //启动模式与Activity是一对一的关系,每个Activity的模式都需单独设置,默认为standard模式无需设置
        //standard模式,每次点击都会生成新的实例,共存于同一个任务中
        Button btn=findViewById(R.id.life_btn);
        btn.setOnClickListener((view) -> {
            Intent intent=new Intent(StartModelActivity.this,StartModelActivity.class);
            startActivity(intent);
        });
        //singleTop模式,在manifests文件对应Activity节点上添加android:launchMode属性并设置值为singleTop,在Intent中跳转自己时不会新实例化对象,但在与其他Activity之间跳转时还是会重复实例化
        //singleTask模式,将launchMode属性的值改为singleTask,在任务中先寻找是否存在已经被实例化的对象,如果存在则不会重复实例化,无论如何跳转
        //               如果将要跳转的Activity不在当前任务中存在实例,则会新建任务并将其实例化放入该任务栈底
        //               如果存在,则会直接调用该Activity的onNewIntent()方法将其上面其他实例统统出栈使之浮上栈顶
        //               故而只能保证只有一个该Activity实例,但不一定是之前的那个实例
        //singleInstance模式,将launchMode属性的值改为singleTask
        //                   该模式限制每个Task任务仅允许存在一个Activity实例,则只要跳转到其他Activity就会在其他任务中寻找是否存在该对象,如果存在直接跳转,如果不存在则新建任务将其实例化到栈底
        //                   该模式解决了多个应用访问同一个Activity的共享实例问题,使得不同的应用访问都可以回退到自己的Activity界面
    }
}

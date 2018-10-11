package com.hunt.cn.helloandroidworld.fromstudytoproduct.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.hunt.cn.helloandroidworld.R;

public class DynamicFrag extends Activity implements View.OnClickListener {

    private Button firstPage;
    private Button newsCenter;
    private Button personCenter;
    private Fragment contentFragment;
    private Fragment firstPageFragment;
    private Fragment personCenterFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamicfrag);
        firstPage=findViewById(R.id.dnfm_fp);
        newsCenter=findViewById(R.id.dnfm_nc);
        personCenter=findViewById(R.id.dnfm_pc);
        firstPage.setOnClickListener(this);
        newsCenter.setOnClickListener(this);
        personCenter.setOnClickListener(this);
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.dnfm_content,firstPageFragment);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        switch (view.getId()){
            case R.id.dnfm_fp:
            case R.id.dnfm_nc:
            case R.id.dnfm_pc:

        }
        ft.commit();
    }
}

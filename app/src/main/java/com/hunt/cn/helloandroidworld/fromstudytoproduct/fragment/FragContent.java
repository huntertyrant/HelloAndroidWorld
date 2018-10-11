package com.hunt.cn.helloandroidworld.fromstudytoproduct.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hunt.cn.helloandroidworld.R;

public class FragContent extends Fragment{

    private TextView text;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fv=inflater.inflate(R.layout.content_staticfrag,container,false);
        text=fv.findViewById(R.id.content_staticfrag);
        btn=fv.findViewById(R.id.cbtn_staticfrag);
        btn.setOnClickListener((v) -> text.setText("中国羽毛球队获得了奥运冠军"));
        return fv;
    }

}

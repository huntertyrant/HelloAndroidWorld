package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.ViewPager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.hunt.cn.helloandroidworld.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        initView();
    }

    private void initView() {
        ViewPager viewPager=findViewById(R.id.viewPager);
        LayoutInflater layoutInflater=getLayoutInflater();

        View first=layoutInflater.inflate(R.layout.viewpage_first,null),
             second=layoutInflater.inflate(R.layout.viewpage_second,null),
             third=layoutInflater.inflate(R.layout.viewpage_third,null);

        List<View> list=new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        FirstViewPagerAdapter firstViewPagerAdapter=new FirstViewPagerAdapter(list);
        viewPager.setAdapter(firstViewPagerAdapter);

    }
}

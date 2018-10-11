package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.VPWithTabLayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hunt.cn.helloandroidworld.R;
import com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.VPWithFragment.FirstFrag;
import com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.VPWithFragment.SecondFrag;
import com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.VPWithFragment.ThirdFrag;

import java.util.ArrayList;
import java.util.List;

public class VPWTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vpwt);
        initViewForFregment();
    }

    private void initViewForFregment() {

        FragmentManager fragmentManager=getSupportFragmentManager();

        List<Fragment> list=new ArrayList<>();
        list.add(new FirstFrag());
        list.add(new SecondFrag());
        list.add(new ThirdFrag());

        List<String> tabs=new ArrayList<>();
        tabs.add("首页");
        tabs.add("新闻");
        tabs.add("个人中心");
        FragmentAdapter fragmentAdapter=new FragmentAdapter(fragmentManager,list,tabs);

        ViewPager viewPager=findViewById(R.id.vpwt);
        viewPager.setAdapter(fragmentAdapter);
        TabLayout tabLayout=findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

}

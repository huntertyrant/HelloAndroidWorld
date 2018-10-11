package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.VPWithFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.hunt.cn.helloandroidworld.R;
import com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_basic_controller_or_event.ClassicUIActivity;
import com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.ViewPager.FirstViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VPWFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        initViewForFregment();
    }

    private void initViewForFregment() {
        ViewPager viewPager=findViewById(R.id.viewPager);

        FragmentManager fragmentManager=getSupportFragmentManager();
        List<Fragment> list=new ArrayList<>();
        list.add(new FirstFrag());
        list.add(new SecondFrag());
        list.add(new ThirdFrag());
        FragmentAdapter fragmentAdapter=new FragmentAdapter(fragmentManager,list);
        viewPager.setAdapter(fragmentAdapter);

    }
}

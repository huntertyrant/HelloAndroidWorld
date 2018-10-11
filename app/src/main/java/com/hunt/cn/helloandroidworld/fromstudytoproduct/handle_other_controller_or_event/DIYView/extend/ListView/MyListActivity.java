package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.extend.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hunt.cn.helloandroidworld.R;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    private MyListView myListView;
    private List<String> list;
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        initList();
        myListView=findViewById(R.id.my_list_view);
        myListAdapter=new MyListAdapter(this,list);
        myListView.setAdapter(myListAdapter);
        myListView.setOnDeleteListener(index -> {
            list.remove(index);
            myListAdapter.notifyDataSetChanged();
        });
    }

    private void initList() {
        list=new ArrayList<>();
        for(int i=0;i<20;i++)list.add("第"+(i+1)+"行");
    }


}

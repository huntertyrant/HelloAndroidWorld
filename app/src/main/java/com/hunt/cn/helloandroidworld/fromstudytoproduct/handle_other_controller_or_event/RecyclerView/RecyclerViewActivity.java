package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.RecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.hunt.cn.helloandroidworld.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.gmariotti.recyclerview.itemanimator.SlideInOutRightItemAnimator;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {

        List<Map<String,String>> mapList=new ArrayList<>();
        Map<String,String> map;
        for(int i=0;i<10;i++){
            map=new HashMap<>();
            map.put("name","姓名为:"+i);
            map.put("age","年龄为:"+i);
            mapList.add(map);
        }
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(mapList,this);
        RecyclerView recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerAdapter.setmOnItemClickListenernItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "longClick", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.delBtn).setOnClickListener((view) -> recyclerAdapter.removeData());
        recyclerView.setItemAnimator(new SlideInOutRightItemAnimator(recyclerView));
        recyclerView.addItemDecoration(new GridItemDecoration(this));
        recyclerView.setAdapter(recyclerAdapter);

    }
    
    
    
}

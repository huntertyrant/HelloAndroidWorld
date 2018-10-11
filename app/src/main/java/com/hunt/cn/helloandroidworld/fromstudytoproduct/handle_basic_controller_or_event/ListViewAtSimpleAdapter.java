package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_basic_controller_or_event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hunt.cn.helloandroidworld.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewAtSimpleAdapter extends AppCompatActivity {

    private ListView listView;
    private List<Map<String,Object>> dataList=new ArrayList<>();
    private int[] itemIdArr=new int[]{R.id.salv_item_text,R.id.salv_item_draw};
    private String[] dataKeyArr=new String[]{"name","draw"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salv);
        Map<String,Object> map;
        for(int i=0;i<15;i++){
            map=new HashMap<>();
            String formula="";
            for (int j=1;j<=i+1;j++)
                formula+=j+"*"+j+"="+j*j+"\t\t";
            map.put("name",formula);
            map.put("draw",R.drawable.meinv);
            dataList.add(map);
        }
        listView=findViewById(R.id.salv);
        listView.setAdapter(new SimpleAdapter(this,dataList,R.layout.salv_item,dataKeyArr,itemIdArr));
    }
}

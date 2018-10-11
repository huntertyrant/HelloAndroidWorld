package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_basic_controller_or_event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hunt.cn.helloandroidworld.R;

public class ListViewAtArrayAdapter extends AppCompatActivity {

    private ListView listView;
    String[] dataArr = new String[15];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aalv);
        for (int i=0;i<15;i++) {
            dataArr[i]="";
            for (int j = 1; j <= i + 1; j++)
                dataArr[i] += j + "*" + j + "=" + j * j + "\t\t";
        }
        listView=findViewById(R.id.aalv);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, dataArr));
    }
}

package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_basic_controller_or_event;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hunt.cn.helloandroidworld.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewAtBaseAdapter extends AppCompatActivity {

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
        MyAdapter ma=new MyAdapter(this,dataList);
        listView.setAdapter(ma);
        listView.setOnItemClickListener((parent,v,i,id) -> {
            Toast.makeText(this,"点击事件触发,点击了第"+(i+1)+"行,触发事件执行删除操作",Toast.LENGTH_LONG).show();
            dataList.remove(i);
            ma.notifyDataSetChanged();
        });
        listView.setOnItemLongClickListener((parent,v,i,id) -> {
            Toast.makeText(this,"长按事件触发,长按了第"+(i+1)+"行",Toast.LENGTH_LONG).show();
            return true;
        });
    }

    private class MyAdapter extends BaseAdapter{

        private Context context;
        private List<Map<String,Object>> dataList;

        public MyAdapter(Context context, List<Map<String, Object>> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int i) {
            return dataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder vh=null;
            if(view==null){
                vh=new ViewHolder();
                view= LayoutInflater.from(context).inflate(R.layout.balv_item,null);
                vh.img=view.findViewById(R.id.balv_item_draw);
                vh.text=view.findViewById(R.id.balv_item_text);
                vh.btn=view.findViewById(R.id.balv_item_btn);
                view.setTag(vh);
            }else
                vh=(ViewHolder)view.getTag();
            Map<String,Object> map=dataList.get(i);
            vh.img.setImageResource((Integer)map.get("draw"));
            vh.text.setText((String)map.get("name"));
            vh.btn.setOnClickListener((v) -> {
                Toast.makeText(context,"删除了第"+i+"行",Toast.LENGTH_LONG).show();
                dataList.remove(i);
                notifyDataSetChanged();
            });
            return view;
        }

        private class ViewHolder{
            private TextView text;
            private Button btn;
            private ImageView img;
        }

    }

}

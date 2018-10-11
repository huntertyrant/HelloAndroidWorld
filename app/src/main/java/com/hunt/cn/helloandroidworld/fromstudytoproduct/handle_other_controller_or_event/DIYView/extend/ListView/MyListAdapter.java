package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.extend.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hunt.cn.helloandroidworld.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public MyListAdapter(Context context, List<String> list) {
        this.context=context;
        this.list = list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(null==convertView){
            convertView=inflater.inflate(R.layout.my_list_view_item,null);
            holder=new ViewHolder();
            holder.text=convertView.findViewById(R.id.my_list_view_item);
            convertView.setTag(holder);
        }else
            holder= (ViewHolder) convertView.getTag();
        holder.text.setText(list.get(position));
        return convertView;

    }

    static class ViewHolder{ TextView text;}

}

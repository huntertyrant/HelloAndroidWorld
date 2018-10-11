package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hunt.cn.helloandroidworld.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerAdapter extends RecyclerView.Adapter {

    private List<Map<String,String>> mapList;
    private Context context;

    public RecyclerAdapter(List<Map<String, String>> mapList, Context context) {
        this.mapList = mapList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Map<String,String> map=mapList.get(i);
        MyViewHolder myViewHolder= (MyViewHolder) viewHolder;
        myViewHolder.name.setText(map.get("name"));
        myViewHolder.age.setText(map.get("age"));
        if(mOnItemClickListener!=null){
            myViewHolder.itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(myViewHolder.itemView,myViewHolder.getLayoutPosition()));
            myViewHolder.itemView.setOnLongClickListener(v -> {
                mOnItemClickListener.onItemLongClick(myViewHolder.itemView,myViewHolder.getLayoutPosition());
                return false;
            });
        }
    }

    @Override
    public int getItemCount() {
        return mapList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,age;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.age = itemView.findViewById(R.id.age);
        }

    }

    public void removeData(){
        int last=mapList.size()-1;
        mapList.remove(last);
        notifyItemRemoved(last);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListenernItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

}

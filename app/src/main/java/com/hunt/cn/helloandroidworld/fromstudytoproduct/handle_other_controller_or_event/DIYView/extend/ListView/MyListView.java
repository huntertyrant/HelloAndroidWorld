package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.extend.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.hunt.cn.helloandroidworld.R;

public class MyListView extends ListView implements View.OnTouchListener,GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;
    private OnDeleteListener listener;
    private View deleteButton;
    private ViewGroup itemLayout;
    private int selectedItem;
    private boolean isDeleteShown;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector=new GestureDetector(getContext(),this);
        setOnTouchListener(this);
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.listener = onDeleteListener;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if(!isDeleteShown)
            selectedItem=pointToPosition((int)e.getX(),(int)e.getY());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(!isDeleteShown&&Math.abs(velocityX)>Math.abs(velocityY)){
            deleteButton=LayoutInflater.from(getContext()).inflate(R.layout.del_btn,null);
            deleteButton.setOnClickListener(v -> {
                itemLayout.removeView(v);
                deleteButton=null;
                isDeleteShown=false;
                listener.onDelete(selectedItem);
            });
            itemLayout= (ViewGroup) getChildAt(selectedItem-getFirstVisiblePosition());
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            itemLayout.addView(deleteButton,params);
            isDeleteShown=true;
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(isDeleteShown){
            itemLayout.removeView(deleteButton);
            deleteButton=null;
            isDeleteShown=false;
            return false;
        }else
            return gestureDetector.onTouchEvent(event);
    }

    public interface OnDeleteListener{
        void onDelete(int index);
    }

}

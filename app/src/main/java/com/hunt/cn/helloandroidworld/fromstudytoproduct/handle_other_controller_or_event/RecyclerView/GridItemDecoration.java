package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.RecyclerView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS=new int[]{android.R.attr.listDivider};
    private Drawable mDivider;

    public GridItemDecoration(Context context) {
        final TypedArray a=context.obtainStyledAttributes(ATTRS);
        this.mDivider = a.getDrawable(0);
        a.recycle();

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        drawHorizontalOrVertical(c,parent,1);
        drawHorizontalOrVertical(c,parent,-1);

    }

    private int getSpanCount(RecyclerView parent){
        int spanCount=-1;
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager)
            spanCount=((GridLayoutManager) layoutManager).getSpanCount();
        else if (layoutManager instanceof StaggeredGridLayoutManager)
            spanCount=((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        return spanCount;
    }

    private void drawHorizontalOrVertical(Canvas c,RecyclerView parent,int type){
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            final View child=parent.getChildAt(i);
            final RecyclerView.LayoutParams layoutParams= (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left=
                        type==1?
                                child.getLeft()-layoutParams.leftMargin:
                                child.getRight()+layoutParams.rightMargin,
                    right=
                        type==1?
                                child.getRight()+layoutParams.rightMargin+mDivider.getIntrinsicWidth():
                                left+mDivider.getIntrinsicWidth(),
                    top=child.getTop()+
                            type==1?
                                layoutParams.bottomMargin:
                                -layoutParams.topMargin,
                    bottom=
                        type==1?
                                top+mDivider.getIntrinsicHeight():
                                child.getBottom()+layoutParams.bottomMargin;
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int spanCount=getSpanCount(parent),childCount=parent.getAdapter().getItemCount();
        boolean isLastRaw = isLastRaw(parent,parent.getChildAdapterPosition(view),spanCount,childCount),
                isLastColum = isLastColum(parent,parent.getChildAdapterPosition(view),spanCount,childCount);
        if(isLastRaw)
            outRect.set(0,0,mDivider.getIntrinsicWidth(),0);
        else if(isLastRaw(parent,view.getId(),spanCount,childCount))
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        else
            outRect.set(0,0,mDivider.getIntrinsicWidth(),mDivider.getIntrinsicHeight());
    }

    private boolean isLastRaw(RecyclerView parent,int id,int spanCount,int childCount){
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            childCount=childCount-childCount%spanCount;
            if(id>=childCount)return true;
        }else if(layoutManager instanceof StaggeredGridLayoutManager){
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if (orientation==StaggeredGridLayoutManager.VERTICAL){
                childCount=childCount-childCount%spanCount;
                if(id>=childCount)return true;
            }else if((id+1)%spanCount==0)return true;
        }
        return false;
    }

    private boolean isLastColum(RecyclerView parent,int id,int spanCount,int childCount){
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager)
            if((id+1)%spanCount==0)return true;
        else if(layoutManager instanceof StaggeredGridLayoutManager){
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if (orientation==StaggeredGridLayoutManager.VERTICAL)
                if((id+1)%spanCount==0)return true;
            else{
                childCount=childCount-childCount%spanCount;
                if(id>=childCount)return true;
            }
        }
        return false;
    }

}

package com.hunt.cn.helloandroidworld.fromstudytoproduct.handle_other_controller_or_event.DIYView.create;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View;

import com.hunt.cn.helloandroidworld.R;

public class MyView extends View implements View.OnClickListener {

    private Paint mPaint;
    private Rect mBounds;
    private String viewText;
    private int textSize;

    public MyView(Context context, AttributeSet attrs) {

        super(context,attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds=new Rect();
        TypedArray typedArray=context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyView,0,0);
        setAttrs(typedArray);

    }

    private void setAttrs(TypedArray typedArray) {

        int n=typedArray.getIndexCount();
        for(int i=0;i<n;i++){
            int attr=typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MyView_ViewText:
                    viewText=typedArray.getString(attr);
                    break;
                case R.styleable.MyView_ViewTextSize:
                    textSize=typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,24,getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(textSize);
        String text=String.valueOf(viewText);
        mPaint.getTextBounds(text,0,text.length(),mBounds);
        float textWidth=mBounds.width(),textHeight=mBounds.height();
        canvas.drawText(text,(getWidth()-textWidth)/2,(getHeight()+textHeight)/2,mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode=MeasureSpec.getMode(widthMeasureSpec),widthSize=MeasureSpec.getSize(widthMeasureSpec),
            heightMode=MeasureSpec.getMode(heightMeasureSpec),heightSize=MeasureSpec.getSize(heightMeasureSpec),
            width,height;
        if(widthMode==MeasureSpec.EXACTLY)
            width=widthSize;
        else{
            mPaint.setTextSize(textSize);
            mPaint.getTextBounds(viewText,0,viewText.length(),mBounds);
            float textWidth=mBounds.width();
            width=(int)(getPaddingLeft()+textWidth+getPaddingRight());
        }
        if(heightMode==MeasureSpec.EXACTLY)
            height=heightSize;
        else{
            mPaint.setTextSize(textSize);
            mPaint.getTextBounds(viewText,0,viewText.length(),mBounds);
            float textHeight=mBounds.height();
            height=(int)(getPaddingTop()+textHeight+getPaddingBottom());
        }
        setMeasuredDimension(width,height);

    }

    @Override
    public void onClick(View v) {
        v.setOnClickListener(this);
    }



}

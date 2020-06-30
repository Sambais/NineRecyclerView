package com.sam.ninerecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidth = getMeasuredWidth();//得到宽度
        int childHeight = getMeasuredHeight();//得到高度

        //如果宽度比高度小
        if (childWidth<childHeight){
            //高度和宽度一样
            widthMeasureSpec = heightMeasureSpec = MeasureSpec
                    .makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }else {
            //宽度和高度一样
            heightMeasureSpec = widthMeasureSpec = MeasureSpec
                    .makeMeasureSpec(childWidth, MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}

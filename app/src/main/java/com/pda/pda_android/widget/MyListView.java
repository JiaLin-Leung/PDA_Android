package com.pda.pda_android.widget;

import android.widget.ListView;

/**
 * 梁佳霖创建于：2018/11/13 14:30
 * 功能：
 */
public class MyListView extends ListView {
    public MyListView(android.content.Context context,android.util.AttributeSet attrs){
        super(context, attrs);
    }
    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}

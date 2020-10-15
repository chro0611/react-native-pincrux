package com.pincrux

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup
import android.widget.LinearLayout

import java.lang.Runnable

class PincruxView(context: Context) : LinearLayout(context) {

    override fun requestLayout(){
        post(measureAndLayout)
    }

    val measureAndLayout : Runnable = Runnable{
            measure(
                MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY))
            layout(getLeft(), getTop(), getRight(), getBottom())
        }
}
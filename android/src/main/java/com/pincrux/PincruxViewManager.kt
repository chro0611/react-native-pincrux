package com.pincrux

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.annotations.ReactProp


import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager

import com.pincrux.offerwall.PincruxOfferwall
import com.pincrux.offerwall.PincruxOfferwallReqCloseListener

import com.pincrux.PincruxView

import android.view.View
import android.widget.TextView
import android.widget.LinearLayout
import android.graphics.Color
import android.content.Context
import android.view.ViewGroup.LayoutParams
import android.os.Handler

import javax.annotation.Nullable

import java.util.Timer

import java.lang.Thread
import java.lang.Runnable

class PincruxViewManager() : ViewGroupManager<PincruxView>() {
    var offerwall : PincruxOfferwall = PincruxOfferwall.getInstance()
    var reactContext : Context? = null

    override fun getName() : String{
        return "Pincrux"
    }

    override fun createViewInstance(context: ThemedReactContext) : PincruxView{
        reactContext = context

        var lnLayout = PincruxView(context)

        return lnLayout
    }

    @ReactProp(name="user")
    fun setPincurxInit(view: PincruxView, user: String){
        offerwall.init(reactContext, "911055", user)
        var offerwallView = offerwall.getPincruxOfferwallView(reactContext, PincruxOfferwallReqCloseListener(){ })

        view.addView(offerwallView)
    }

    @ReactProp(name="height")
    fun setLayout(view: PincruxView, height: Int){
        var offerwallView = view.getChildAt(0)

        if(offerwallView != null)
        {
            view.layout(0, 0, offerwallView.width, offerwallView.height)
        }
    }
}

package com.reacttutorialapp;

import android.app.Activity;
import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.visioncritical.touchpointkit.utils.TouchPointActivity;

public class TouchPointKitBridge extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    TouchPointKitBridge(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return "TouchPointKitBridge";
    }

    @ReactMethod
    public void setScreen(String screenName, Boolean banner) {
        Context context = getCurrentActivity();

        if (context == null) {
            context = reactContext;
        }

        TouchPointActivity.Companion.getShared().setCurrentScreen(context, screenName, banner);
    }

    @ReactMethod
    public void openActivity(String screenName) {
        if(TouchPointActivity.Companion.getShared().shouldShowActivity(screenName)) {
            Context context = getCurrentActivity();

            if (context == null) {
                context = reactContext;
            }
            TouchPointActivity.Companion.getShared().openActivity(context, screenName, null);
        }
    }
}

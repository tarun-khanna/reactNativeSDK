package com.example.sdksampleapp;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;

import java.util.List;

public class App extends Application implements ReactApplication {
    private final ReactNativeHost mReactNativeHost =
            new ReactNativeHost(this) {

                @Override
                public boolean getUseDeveloperSupport() {
                    return false;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    return null;
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }
            };
    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }
}

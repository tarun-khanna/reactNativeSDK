package com.example.sdksampleapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sdksampleapp.R;
import com.facebook.react.PackageList;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.soloader.SoLoader;

import java.util.List;

public class HomeFragment extends Fragment {


    private ReactRootView mReactRootView = null;
    private ReactInstanceManager mReactInstanceManager = null;
    private FrameLayout frameLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SoLoader.init(getContext(), false);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        frameLayout=root.findViewById(R.id.frameLayout);
        mReactRootView = new ReactRootView(getContext());
        List<ReactPackage> packages = new PackageList(getActivity().getApplication()).getPackages();
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(new MyReactNativePackage());
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getActivity().getApplication())
                .setCurrentActivity(getActivity())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackages(packages)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AppReplica", null);
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        frameLayout.addView(mReactRootView);
        super.onViewCreated(view, savedInstanceState);
    }
}
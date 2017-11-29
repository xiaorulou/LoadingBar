package com.dyhdyh.loadingbar.example.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dyhdyh.loadingbar.example.R;
import com.dyhdyh.widget.loading.factory.LoadingFactory;

/**
 * 自定义样式LoadingBar的例子
 * author  dengyuhan
 * created 2017/4/16 05:13
 */
public class CustomLoadingFactory implements LoadingFactory {

    @Override
    public View onCreateView(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_process_dialog_color, parent, false);
        return view;
    }
}

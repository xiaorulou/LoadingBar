package com.dyhdyh.loadingbar.example;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import com.dyhdyh.widget.loading.bar.LoadingBar;

/**
 * author  dengyuhan
 * created 2017/4/16 15:35
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title + " - Android" + Build.VERSION.RELEASE, color);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoadingBar.release();
    }
}

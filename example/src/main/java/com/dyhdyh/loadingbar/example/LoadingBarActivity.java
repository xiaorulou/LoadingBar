package com.dyhdyh.loadingbar.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dyhdyh.loadingbar.example.factory.CustomLoadingFactory;
import com.dyhdyh.widget.loading.LoadingConfig;
import com.dyhdyh.widget.loading.bar.LoadingBar;
import com.dyhdyh.widget.loading.bar.OnLoadingBarListener;

/**
 * LoadingBar的例子
 * author  dengyuhan
 * created 2017/4/16 11:38
 */
public class LoadingBarActivity extends BaseActivity {
    private View mParent;
    RelativeLayout mLayout;
    View mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingbar);
        mParent = findViewById(R.id.loading_container);
        mLayout = (RelativeLayout)findViewById(R.id.loading_container);
        mLoadingView = LayoutInflater.from(mLayout.getContext()).inflate(R.layout.loading_progressbar_vertical_material, mLayout, false);
    }

    /**
     * 默认的LoadingBar
     * @param v
     */
    public void clickLoading(View v) {
        //方式一
        LoadingBar.make(mParent).show();  //等同于LoadingBar.make(mParent, LoadingConfig.getLoadingFactory()).show();

        //方式二
        //LoadingBar.make(mParent,mLoadingView).show();

        //方式三
        //LoadingBar.make(mParent,R.layout.loading_progressbar_vertical_material).show();
    }

    /**
     * 自定义的LoadingBar
     * @param v
     */
    public void clickCustomLoading(View v) {
        LoadingBar.make(mParent, new CustomLoadingFactory()).show();
        LoadingBar loadingBar = LoadingBar.make(mParent,new CustomLoadingFactory());

        loadingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoadingBarActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });

        loadingBar.setOnLoadingBarListener(new OnLoadingBarListener() {
            @Override
            public void onCancel(View parent) {
                Toast.makeText(LoadingBarActivity.this, "Loading取消了", Toast.LENGTH_SHORT).show();
            }
        });

        loadingBar.show();
    }


    public void clickCancelLoading(View v) {
        LoadingBar.cancel(mParent);
    }


    public void clickListLoading(View v) {
        startActivity(new Intent(this, ListLoadingActivity.class));
    }

}

package com.zhaoshe.democustomimageview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomView view = (CustomView) findViewById(R.id.custom);
        // demo1 和 demo2 是我事先放在 drawable 文件夹下的两张图片
//        view.setLeftImage(getResources().getDrawable(R.drawable.demo1));
//        view.setRightImage(getResources().getDrawable(R.drawable.demo2));
    }
}

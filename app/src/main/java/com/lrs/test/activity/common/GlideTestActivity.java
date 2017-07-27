package com.lrs.test.activity.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/27.
 */

public class GlideTestActivity extends BaseActivity {


    private ImageView mImageView;
    private static final String url = "http://img4.imgtn.bdimg.com/it/u=3681783599,746858373&fm=26&gp=0.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageView = (ImageView) findViewById(R.id.circle_image);

        Glide.with(this).load(url).into(mImageView);
    }
}

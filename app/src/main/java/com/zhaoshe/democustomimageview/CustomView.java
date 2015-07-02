package com.zhaoshe.democustomimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by august on 7/2/15.
 */
public class CustomView extends LinearLayout {
    // 横向并排的两个 imageview
    private ImageView mLeftImage;
    private ImageView mRightImage;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.customViewStyle);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView(context, attrs, defStyleAttr);
    }

    private void setupView(Context context, AttributeSet attrs, int defStyleAttr) {
        // 设置为横向排列
        setOrientation(HORIZONTAL);

        // 初始化 imageview
        mLeftImage = new ImageView(context);
        mRightImage = new ImageView(context);

        // 两个图片都拉伸匹配 xy
        mLeftImage.setScaleType(ImageView.ScaleType.FIT_XY);
        mRightImage.setScaleType(ImageView.ScaleType.FIT_XY);

        // 两个图片各占一半
        LinearLayout.LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;

        // 添加两个imageview
        addView(mLeftImage, params);
        addView(mRightImage, params);

        // 处理自定义属性标签
//        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);
        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, R.style.CustomViewStyle);
        if (array != null) {
            Drawable leftDrawable = array.getDrawable(R.styleable.CustomView_left_img);
            if (leftDrawable != null) {
                mLeftImage.setImageDrawable(leftDrawable);
            }
            Drawable rightDrawable = array.getDrawable(R.styleable.CustomView_right_img);
            if (rightDrawable != null) {
                mRightImage.setImageDrawable(rightDrawable);
            }

            array.recycle();
        }
    }

    /**
     * 设置左边图片
     * @param drawable
     */
    public void setLeftImage(Drawable drawable) {
        mLeftImage.setImageDrawable(drawable);
    }

    /**
     * 设置右边图片
     * @param drawable
     */
    public void setRightImage(Drawable drawable) {
        mRightImage.setImageDrawable(drawable);
    }
}

package com.rxjavasample.view.viewholder;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rxjavasample.R;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.injection.module.GlideApp;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawerHeaderViewHolder implements View.OnClickListener {
    @Inject
    transient Context mContext;

    private View.OnClickListener mOnClickListener;

    public DrawerHeaderViewHolder(AppComponent appComponent, View view,
            View.OnClickListener onClickListener) {
        appComponent.inject(this);
        ButterKnife.bind(this, view);

        mOnClickListener = onClickListener;
    }


    public void setHeaderBackground(int resId, int placeHolderResId) {
        GlideApp.with(mContext)
                .load(resId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(placeHolderResId)
                .into(mHeaderBackground);
    }

    public void setProfilePic(String url, int placeHolderResId) {
        GlideApp.with(mContext)
                .load(url)
                .thumbnail(0.5f)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(placeHolderResId)
                .into(mProfilePic);
    }

    public void setName(String name) {
        mName.setText(name);
    }

    public void setProfileUrl(String profileUrl) {
        mProfileUrl.setText(profileUrl);
    }

    @OnClick(R.id.nav_header_user_activity_profile_url)
    @Override
    public void onClick(View view) {
        if (mOnClickListener != null) {
            mOnClickListener.onClick(view);
        }
    }

    @BindView(R.id.nav_header_user_activity_header_background) ImageView mHeaderBackground;
    @BindView(R.id.nav_header_user_activity_profile_pic) ImageView mProfilePic;
    @BindView(R.id.nav_header_user_activity_name) AppCompatTextView mName;
    @BindView(R.id.nav_header_user_activity_profile_url) AppCompatTextView mProfileUrl;
}
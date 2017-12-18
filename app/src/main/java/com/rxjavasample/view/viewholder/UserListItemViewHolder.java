package com.rxjavasample.view.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rxjavasample.R;
import com.rxjavasample.injection.module.GlideApp;


import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListItemViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;

    public UserListItemViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void setName(String name) {
        mName.setText(name);
    }

    public void setProfilePic(String url) {
        GlideApp.with(mContext)
                .load(url)
                .thumbnail(0.5f)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_person_black_24dp)
                .placeholder(R.drawable.ic_person_black_24dp)
                .into(mProfilePic);
    }

    @BindView(R.id.item_user_name) AppCompatTextView mName;
    @BindView(R.id.item_user_profile_pic) ImageView mProfilePic;
}
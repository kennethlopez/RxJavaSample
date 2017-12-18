package com.rxjavasample.view.adapter;


import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxjavasample.R;
import com.rxjavasample.data.model.User;
import com.rxjavasample.view.viewholder.UserListItemViewHolder;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class UserListAdapter extends RealmRecyclerViewAdapter<User, UserListItemViewHolder> {
    private Context mContext;

    public UserListAdapter(Context context, @Nullable OrderedRealmCollection<User> data, boolean autoUpdate) {
        super(data, autoUpdate);
        mContext = context;
    }

    @Override
    public UserListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_user, parent, false);
        return new UserListItemViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(UserListItemViewHolder holder, int position) {
        User user = getItem(position);
        assert user != null;
        holder.setName(user.getLogin());
        holder.setProfilePic(user.getAvatarUrl());
    }
}

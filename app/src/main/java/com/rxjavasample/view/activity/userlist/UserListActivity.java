package com.rxjavasample.view.activity.userlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rxjavasample.R;
import com.rxjavasample.base.BaseActivity;
import com.rxjavasample.constants.AppConstants;
import com.rxjavasample.data.model.User;
import com.rxjavasample.util.RecyclerTouchListener;
import com.rxjavasample.view.activity.user.UserActivity;
import com.rxjavasample.view.adapter.UserListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;

public class UserListActivity extends BaseActivity implements UserListView {
    private UserListPresenter mPresenter;
    private UserListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        setPresenter();
    }

    @Override
    public void setPresenter() {
        super.setPresenter(mPresenter = new UserListPresenterImpl(getComponent(), this));
    }

    @Override
    public void initRecyclerView(OrderedRealmCollection<User> users) {
        mAdapter = new UserListAdapter(this, users, true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                mRecyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        mPresenter.onRecyclerViewItemClick(mAdapter.getItem(position));
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
    }

    @Override
    public void startUserActivity(User user) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra(AppConstants.EXTRA_USER_ID, user.getId());
        startActivity(intent);
    }

    @BindView(R.id.activity_user_list_recycler_view) RecyclerView mRecyclerView;
}
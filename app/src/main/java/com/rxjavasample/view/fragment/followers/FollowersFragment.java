package com.rxjavasample.view.fragment.followers;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxjavasample.R;
import com.rxjavasample.base.BaseFragment;
import com.rxjavasample.constants.AppConstants;

public class FollowersFragment extends BaseFragment {

    public static FollowersFragment newInstance(int userId) {
        Bundle args = new Bundle();
        args.putInt(AppConstants.EXTRA_USER_ID, userId);

        FollowersFragment fragment = new FollowersFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_followers, null);

        return view;
    }
}

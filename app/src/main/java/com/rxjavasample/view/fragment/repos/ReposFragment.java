package com.rxjavasample.view.fragment.repos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxjavasample.R;
import com.rxjavasample.base.BaseFragment;
import com.rxjavasample.constants.AppConstants;

public class ReposFragment extends BaseFragment {

    public static ReposFragment newInstance(int userId) {
        Bundle args = new Bundle();
        args.putInt(AppConstants.EXTRA_USER_ID, userId);

        ReposFragment fragment = new ReposFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_repos, null);

        return view;
    }

}

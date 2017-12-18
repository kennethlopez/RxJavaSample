package com.rxjavasample.view.fragment.about;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.rxjavasample.R;
import com.rxjavasample.base.BaseFragment;
import com.rxjavasample.constants.AppConstants;
import com.rxjavasample.injection.module.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutFragment extends BaseFragment implements AboutView, View.OnClickListener {
    private AboutPresenter mPresenter;

    public static AboutFragment newInstance(int userId) {
        Bundle args = new Bundle();
        args.putInt(AppConstants.EXTRA_USER_ID, userId);

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_about, null);
        ButterKnife.bind(this, view);

        setPresenter();
        return view;
    }

    @Override
    public void setPresenter() {
        super.setPresenter(mPresenter = new AboutPresenterImpl(getComponent(), this));
    }

    @OnClick(R.id.fragment_about_profile_url)
    @Override
    public void onClick(View view) {
        mPresenter.onClick(view.getId());
    }

    @Override
    public void setProfilePic(String url) {
        GlideApp.with(getContext())
                .load(url)
                .thumbnail(0.5f)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_person_black_24dp)
                .into(mProfilePic);
    }

    @Override
    public void setName(int labelResId, String name) {
        String label = getString(labelResId).concat(" " + name);
        mName.setText(label);
    }

    @Override
    public void setProfileUrl(int labelResId, String profileUrl) {
        String label = getString(labelResId).concat(" " + profileUrl);
        mProfileUrl.setText(label);
    }

    @Override
    public void setLocation(int labelResId, String location) {
        String label = getString(labelResId).concat(" " + location);
        mLocation.setText(label);
    }

    @Override
    public void setCompany(int labelResId, String company) {
        String label = getString(labelResId).concat(" " + company);
        mCompany.setText(label);
    }

    @Override
    public void setRepos(int labelResId, String repos) {
        String label = getString(labelResId).concat(" " + repos);
        mRepos.setText(label);
    }

    @Override
    public void setFollowers(int labelResId, String followers) {
        String label = getString(labelResId).concat(" " + followers);
        mFollowers.setText(label);
    }

    @Override
    public void setFollowing(int labelResId, String following) {
        String label = getString(labelResId).concat(" " + following);
        mFollowing.setText(label);
    }

    @Override
    public int getExtraUserId() {
        return getArguments().getInt(AppConstants.EXTRA_USER_ID);
    }

    @Override
    public void openOnBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    @BindView(R.id.fragment_about_profile_pic) ImageView mProfilePic;
    @BindView(R.id.fragment_about_name) AppCompatTextView mName;
    @BindView(R.id.fragment_about_profile_url) AppCompatTextView mProfileUrl;
    @BindView(R.id.fragment_about_location) AppCompatTextView mLocation;
    @BindView(R.id.fragment_about_company) AppCompatTextView mCompany;
    @BindView(R.id.fragment_about_repos) AppCompatTextView mRepos;
    @BindView(R.id.fragment_about_followers) AppCompatTextView mFollowers;
    @BindView(R.id.fragment_about_following) AppCompatTextView mFollowing;
}

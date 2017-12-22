package com.rxjavasample.view.activity.home;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.rxjavasample.R;
import com.rxjavasample.base.BaseActivity;
import com.rxjavasample.base.BaseView;
import com.rxjavasample.data.SyncService;
import com.rxjavasample.util.AndroidComponentUtil;
import com.rxjavasample.view.activity.userlist.UserListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class HomeActivity extends BaseActivity implements HomeView, View.OnClickListener,
        BaseView.OnTextChangedListener {
    private static final String EXTRA_TRIGGER_SYNC_FLAG = "HomeActivity.EXTRA_TRIGGER_SYNC_FLAG";

    private HomePresenter mPresenter;
    private ProgressDialog mProgressDialog;

    /**
     * Return an Intent to start this Activity.
     * triggerDataSyncOnCreate allows disabling the background sync service onCreate. Should
     * only be set to false during testing.
     */
    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setPresenter();

        if (getIntent().getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(SyncService.getStartIntent(this));
        }
    }

    @Override
    public void setPresenter() {
        super.setPresenter(mPresenter = new HomePresenterImpl(getComponent(), this));
    }

    @OnClick(R.id.activity_main_search)
    @Override
    public void onClick(View view) {
        mPresenter.onClick(view.getId());
    }

    @OnTextChanged(
            value = R.id.activity_main_username,
            callback = OnTextChanged.Callback.TEXT_CHANGED
    )
    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        mPresenter.onTextChangedUsername(charSequence, start, before, count);
    }

    @Override
    public String getUsername() {
        return mUsername.getText().toString();
    }

    @Override
    public void disableSearch() {
        mSearch.setEnabled(false);
    }

    @Override
    public void enableSearch() {
        mSearch.setEnabled(true);
    }

    @Override
    public void showProgressDialog(int resId) {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(resId));
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showConnectionErrorDialog(int resId) {
        super.showConnectionErrorDialog(getString(resId));
    }

    @Override
    public void toastMessage(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void startUserListActivity() {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    @BindView(R.id.activity_main_search) AppCompatButton mSearch;
    @BindView(R.id.activity_main_username) AppCompatEditText mUsername;
}

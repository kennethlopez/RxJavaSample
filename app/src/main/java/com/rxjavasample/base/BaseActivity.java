package com.rxjavasample.base;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rxjavasample.R;
import com.rxjavasample.data.manger.RealmManager;
import com.rxjavasample.injection.component.ActivityComponent;
import com.rxjavasample.injection.component.DaggerActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent mComponent;
    private BasePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComponent = DaggerActivityComponent.builder()
                .appComponent(getApp().getAppComponent())
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onStart();
        }
        RealmManager.incrementCount();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        if (mPresenter != null) {
            mPresenter.onPause();
        }

        super.onPause();
    }

    @Override
    protected void onStop() {
        if (mPresenter != null) {
            mPresenter.onStop();
        }

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        RealmManager.decrementCount();

        super.onDestroy();
    }

    protected void showConnectionErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok_text, (dialogInterface, i) -> dialogInterface.dismiss());

        builder.create().show();
    }

    protected void setPresenter(BasePresenter presenter) {
        mPresenter = presenter;
    }

    public ActivityComponent getComponent() {
        return mComponent;
    }

    protected App getApp() {
        return (App) getApplicationContext();
    }
}
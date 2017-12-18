package com.rxjavasample.view.activity.home;


import com.rxjavasample.base.BaseView;

public interface HomeView extends BaseView {
    String getUsername();

    void disableSearch();

    void enableSearch();

    void startUserListActivity();

    void showProgressDialog(int resId);

    void hideProgressDialog();

    void showConnectionErrorDialog(int resId);

    void toastMessage(int resId);

    void startSyncService();
}

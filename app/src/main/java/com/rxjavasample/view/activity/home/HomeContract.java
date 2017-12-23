package com.rxjavasample.view.activity.home;


import com.rxjavasample.base.BaseView;

public interface HomeContract {
    interface View extends BaseView {
        String getUsername();

        void disableSearch();

        void enableSearch();

        void startUserListActivity();

        void showProgressDialog(int resId);

        void hideProgressDialog();

        void showConnectionErrorDialog(int resId);

        void toastMessage(int resId);
    }

    interface Presenter {
        void onTextChangedUsername(CharSequence charSequence, int start, int before, int count);
    }
}
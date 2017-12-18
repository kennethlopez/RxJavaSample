package com.rxjavasample.base;


public interface BaseView {
    void setPresenter();

    interface OnTextChangedListener {
        void onTextChanged(CharSequence charSequence, int start, int before, int count);
    }
}
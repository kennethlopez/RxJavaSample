// Generated code from Butter Knife. Do not modify!
package com.rxjavasample.view.activity.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rxjavasample.R;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding implements Unbinder {
  private HomeActivity target;

  private View view2131296283;

  private View view2131296284;

  private TextWatcher view2131296284TextWatcher;

  @UiThread
  public HomeActivity_ViewBinding(HomeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeActivity_ViewBinding(final HomeActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.activity_main_search, "field 'mSearch' and method 'onClick'");
    target.mSearch = Utils.castView(view, R.id.activity_main_search, "field 'mSearch'", AppCompatButton.class);
    view2131296283 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.activity_main_username, "field 'mUsername' and method 'onTextChanged'");
    target.mUsername = Utils.castView(view, R.id.activity_main_username, "field 'mUsername'", AppCompatEditText.class);
    view2131296284 = view;
    view2131296284TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        target.onTextChanged(p0, p1, p2, p3);
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
      }
    };
    ((TextView) view).addTextChangedListener(view2131296284TextWatcher);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSearch = null;
    target.mUsername = null;

    view2131296283.setOnClickListener(null);
    view2131296283 = null;
    ((TextView) view2131296284).removeTextChangedListener(view2131296284TextWatcher);
    view2131296284TextWatcher = null;
    view2131296284 = null;
  }
}

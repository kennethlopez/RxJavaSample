// Generated code from Butter Knife. Do not modify!
package com.rxjavasample.view.activity.userlist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rxjavasample.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserListActivity_ViewBinding implements Unbinder {
  private UserListActivity target;

  @UiThread
  public UserListActivity_ViewBinding(UserListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserListActivity_ViewBinding(UserListActivity target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.activity_user_list_recycler_view, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
  }
}

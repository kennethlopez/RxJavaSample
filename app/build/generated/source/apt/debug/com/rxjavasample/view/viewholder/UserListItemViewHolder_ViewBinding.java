// Generated code from Butter Knife. Do not modify!
package com.rxjavasample.view.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rxjavasample.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserListItemViewHolder_ViewBinding implements Unbinder {
  private UserListItemViewHolder target;

  @UiThread
  public UserListItemViewHolder_ViewBinding(UserListItemViewHolder target, View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.item_user_name, "field 'mName'", AppCompatTextView.class);
    target.mProfilePic = Utils.findRequiredViewAsType(source, R.id.item_user_profile_pic, "field 'mProfilePic'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserListItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mProfilePic = null;
  }
}

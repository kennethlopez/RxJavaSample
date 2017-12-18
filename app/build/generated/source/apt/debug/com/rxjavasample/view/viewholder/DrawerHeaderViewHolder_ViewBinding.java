// Generated code from Butter Knife. Do not modify!
package com.rxjavasample.view.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rxjavasample.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DrawerHeaderViewHolder_ViewBinding implements Unbinder {
  private DrawerHeaderViewHolder target;

  private View view2131296380;

  @UiThread
  public DrawerHeaderViewHolder_ViewBinding(final DrawerHeaderViewHolder target, View source) {
    this.target = target;

    View view;
    target.mHeaderBackground = Utils.findRequiredViewAsType(source, R.id.nav_header_user_activity_header_background, "field 'mHeaderBackground'", ImageView.class);
    target.mProfilePic = Utils.findRequiredViewAsType(source, R.id.nav_header_user_activity_profile_pic, "field 'mProfilePic'", ImageView.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.nav_header_user_activity_name, "field 'mName'", AppCompatTextView.class);
    view = Utils.findRequiredView(source, R.id.nav_header_user_activity_profile_url, "field 'mProfileUrl' and method 'onClick'");
    target.mProfileUrl = Utils.castView(view, R.id.nav_header_user_activity_profile_url, "field 'mProfileUrl'", AppCompatTextView.class);
    view2131296380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DrawerHeaderViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHeaderBackground = null;
    target.mProfilePic = null;
    target.mName = null;
    target.mProfileUrl = null;

    view2131296380.setOnClickListener(null);
    view2131296380 = null;
  }
}

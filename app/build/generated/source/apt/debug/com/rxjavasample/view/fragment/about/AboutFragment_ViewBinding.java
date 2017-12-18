// Generated code from Butter Knife. Do not modify!
package com.rxjavasample.view.fragment.about;

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

public class AboutFragment_ViewBinding implements Unbinder {
  private AboutFragment target;

  private View view2131296341;

  @UiThread
  public AboutFragment_ViewBinding(final AboutFragment target, View source) {
    this.target = target;

    View view;
    target.mProfilePic = Utils.findRequiredViewAsType(source, R.id.fragment_about_profile_pic, "field 'mProfilePic'", ImageView.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.fragment_about_name, "field 'mName'", AppCompatTextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_about_profile_url, "field 'mProfileUrl' and method 'onClick'");
    target.mProfileUrl = Utils.castView(view, R.id.fragment_about_profile_url, "field 'mProfileUrl'", AppCompatTextView.class);
    view2131296341 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mLocation = Utils.findRequiredViewAsType(source, R.id.fragment_about_location, "field 'mLocation'", AppCompatTextView.class);
    target.mCompany = Utils.findRequiredViewAsType(source, R.id.fragment_about_company, "field 'mCompany'", AppCompatTextView.class);
    target.mRepos = Utils.findRequiredViewAsType(source, R.id.fragment_about_repos, "field 'mRepos'", AppCompatTextView.class);
    target.mFollowers = Utils.findRequiredViewAsType(source, R.id.fragment_about_followers, "field 'mFollowers'", AppCompatTextView.class);
    target.mFollowing = Utils.findRequiredViewAsType(source, R.id.fragment_about_following, "field 'mFollowing'", AppCompatTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AboutFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProfilePic = null;
    target.mName = null;
    target.mProfileUrl = null;
    target.mLocation = null;
    target.mCompany = null;
    target.mRepos = null;
    target.mFollowers = null;
    target.mFollowing = null;

    view2131296341.setOnClickListener(null);
    view2131296341 = null;
  }
}

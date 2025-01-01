// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomAppbarBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final LinearLayout bottomAppBar;

  @NonNull
  public final View circle0;

  @NonNull
  public final View circle1;

  @NonNull
  public final View circle2;

  @NonNull
  public final View circle3;

  @NonNull
  public final View circle4;

  @NonNull
  public final FrameLayout container;

  private BottomAppbarBinding(@NonNull CoordinatorLayout rootView,
      @NonNull LinearLayout bottomAppBar, @NonNull View circle0, @NonNull View circle1,
      @NonNull View circle2, @NonNull View circle3, @NonNull View circle4,
      @NonNull FrameLayout container) {
    this.rootView = rootView;
    this.bottomAppBar = bottomAppBar;
    this.circle0 = circle0;
    this.circle1 = circle1;
    this.circle2 = circle2;
    this.circle3 = circle3;
    this.circle4 = circle4;
    this.container = container;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomAppbarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomAppbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_appbar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomAppbarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomAppBar;
      LinearLayout bottomAppBar = ViewBindings.findChildViewById(rootView, id);
      if (bottomAppBar == null) {
        break missingId;
      }

      id = R.id.circle0;
      View circle0 = ViewBindings.findChildViewById(rootView, id);
      if (circle0 == null) {
        break missingId;
      }

      id = R.id.circle1;
      View circle1 = ViewBindings.findChildViewById(rootView, id);
      if (circle1 == null) {
        break missingId;
      }

      id = R.id.circle2;
      View circle2 = ViewBindings.findChildViewById(rootView, id);
      if (circle2 == null) {
        break missingId;
      }

      id = R.id.circle3;
      View circle3 = ViewBindings.findChildViewById(rootView, id);
      if (circle3 == null) {
        break missingId;
      }

      id = R.id.circle4;
      View circle4 = ViewBindings.findChildViewById(rootView, id);
      if (circle4 == null) {
        break missingId;
      }

      id = R.id.container;
      FrameLayout container = ViewBindings.findChildViewById(rootView, id);
      if (container == null) {
        break missingId;
      }

      return new BottomAppbarBinding((CoordinatorLayout) rootView, bottomAppBar, circle0, circle1,
          circle2, circle3, circle4, container);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

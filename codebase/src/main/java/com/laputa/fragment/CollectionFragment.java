/**
 * Created by YuGang Yang on December 24, 2014.
 * Copyright 2007-2015 Loopeer.com. All rights reserved.
 */
package com.laputa.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laputa.R;
import com.laputa.widget.CollectionView;

public class CollectionFragment extends ListFragment {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.collection_content, container, false);
  }

  @Override
  public CollectionView getListView() {
    return (CollectionView) super.getListView();
  }


}

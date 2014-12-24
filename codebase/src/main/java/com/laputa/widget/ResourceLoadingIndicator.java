/**
 * Created by YuGang Yang on August 31, 2014.
 * Copyright 2007-2015 Loopeer.com. All rights reserved.
 */
package com.laputa.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.laputa.R;

public class ResourceLoadingIndicator {
    private ListView mListView;
    private boolean showing;
    private final View view;
    private final TextView textView;

    public ResourceLoadingIndicator(final Context context) {
        this(context, 0);
    }

    /**
     * Create indicator using given inflater
     *
     * @param context
     * @param loadingResId
     *            string resource id to show when loading
     */
    public ResourceLoadingIndicator(final Context context, final int loadingResId) {
        view = LayoutInflater.from(context).inflate(R.layout.loading_indicator, null);
        textView = (TextView) view.findViewById(R.id.text_loading);
        if (loadingResId > 0) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(loadingResId);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    /**
     * Set the adapter that this indicator should be added as a footer to
     *
     * @param listView
     * @return this indicator
     */
    public ResourceLoadingIndicator setList(ListView listView) {
        mListView = listView;
        showing = false;
        return this;
    }

    /**
     * Set visibility of entire indicator view
     *
     * @param visible
     * @return this indicator
     */
    public ResourceLoadingIndicator setVisible(final boolean visible) {
        if (showing != visible && mListView != null)
            if (visible)
                mListView.addFooterView(view);
            else
                mListView.removeFooterView(view);
        showing = visible;
        return this;
    }


}

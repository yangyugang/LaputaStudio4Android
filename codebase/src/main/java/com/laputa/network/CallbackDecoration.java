/**
 * Created by YuGang Yang on September 19, 2014.
 * Copyright 2007-2015 Loopeer.com. All rights reserved.
 */
package com.laputa.network;

import retrofit.RetrofitError;

public class CallbackDecoration<T> implements retrofit.Callback<Response<T>> {

    protected final Callbacks.RequestCallback<T> mRequestCallback;

    public CallbackDecoration(Callbacks.RequestCallback<T> requestCallback) {
        mRequestCallback = requestCallback;
    }

    @Override public void success(Response<T> result, retrofit.client.Response response) {
        if (mRequestCallback == null) return;

        if (result.isSuccessed()) {
            if (mRequestCallback.canCache() && result.mData != null) {
                mRequestCallback.handleLocalCache(result.mData);
            }
            mRequestCallback.onRequestComplete(result);
        } else {
            mRequestCallback.onRequestFailure(result);
        }

        mRequestCallback.onFinish();
    }

    @Override public void failure(RetrofitError error) {
        if (mRequestCallback == null) return;

        if (error.isNetworkError()) {
            mRequestCallback.onRequestNetworkError();
        } else {
            mRequestCallback.onRequestFailure(error);
        }

        mRequestCallback.onFinish();
    }
}

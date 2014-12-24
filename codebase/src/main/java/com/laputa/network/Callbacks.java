/**
 * Created by YuGang Yang on September 19, 2014.
 * Copyright 2007-2015 Loopeer.com. All rights reserved.
 */
package com.laputa.network;

import retrofit.RetrofitError;

public class Callbacks {

    public interface RequestCallback<T> {
        public void onRequestComplete(Response<T> response);
        public void onRequestFailure(Response<T> response);
        public void onRequestFailure(RetrofitError error);
        public void onRequestNetworkError();
        public void onFinish();

        public boolean canCache();
        public void handleLocalCache(T data);
        public void onCacheLoaded(T localData);
    }

    public class ApiBaseCallback<T> implements RequestCallback<T> {
        @Override public void onRequestComplete(Response<T> response) {}
        @Override public void onRequestFailure(Response<T> response) {}
        @Override public void onRequestFailure(RetrofitError error) {}

        @Override public void onRequestNetworkError() {}
        @Override public void onFinish() {}

        @Override public boolean canCache() {
            return false;
        }
        @Override public void handleLocalCache(T data) {}
        @Override public void onCacheLoaded(T localData) {}
    }

}

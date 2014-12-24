/**
 * Created by YuGang Yang on September 19, 2014.
 * Copyright 2007-2015 Loopeer.com. All rights reserved.
 */
package com.laputa.network;

import java.util.ArrayList;

public abstract class PaginatorCallbackDecoration<T> extends CallbackDecoration<ArrayList<T>> {

    public PaginatorCallbackDecoration(Callbacks.RequestCallback<ArrayList<T>> requestCallback) {
        super(requestCallback);
    }

    @Override
    public void success(Response<ArrayList<T>> result, retrofit.client.Response response) {
        if (result.isSuccessed()) {
            handleData(result);
        } else {
            onCodeNotSuccessed(result);
        }
        super.success(result, response);
    }

    protected abstract void onCodeNotSuccessed(Response<ArrayList<T>> response);

    protected abstract void handleData(Response<ArrayList<T>> response);

}

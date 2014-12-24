/**
 * Created by YuGang Yang on September 19, 2014.
 * Copyright 2007-2015 Loopeer.com. All rights reserved.
 */
package com.laputa.network;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Response<T> implements Serializable {

    public int code;
    public String message;

    @SerializedName("page") public long page;
    @SerializedName("page_size") public long pageSize;
    @SerializedName("total_size") public long totalSize;

    @SerializedName("data") public T mData;

    public boolean isSuccessed() {
        return code == 0;
    }

}

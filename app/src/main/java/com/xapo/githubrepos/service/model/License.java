package com.xapo.githubrepos.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("spdx_id")
    @Expose
    private String spdx_id;
    @SerializedName("url")
    @Expose
    private String url;
}

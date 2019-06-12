package com.xapo.githubrepos.service.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsOwner implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;
    @SerializedName("gravatar_id")
    @Expose
    private String gravatar_id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String html_url;

    public ItemsOwner(int id, String login, String avatar_url, String gravatar_id, String url, String html_url) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
    }

    ItemsOwner(Parcel parcel){
        id = parcel.readInt();
        login = parcel.readString();
        avatar_url = parcel.readString();
        gravatar_id = parcel.readString();
        url = parcel.readString();
        html_url = parcel.readString();
    }

    public static final Creator<ItemsOwner> CREATOR = new Creator<ItemsOwner>() {
        @Override
        public ItemsOwner createFromParcel(Parcel in) {
            return new ItemsOwner(in);
        }

        @Override
        public ItemsOwner[] newArray(int size) {
            return new ItemsOwner[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(login);
        dest.writeString(avatar_url);
        dest.writeString(gravatar_id);
        dest.writeString(url);
        dest.writeString(html_url);
    }
}

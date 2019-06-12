package com.xapo.githubrepos.service.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("private")
    @Expose
    private boolean isPrivate;
    @SerializedName("owner")
    @Expose
    private ItemsOwner owner;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("fork")
    @Expose
    private boolean isFork;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pushed_at")
    @Expose
    private String pushedAt;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("open_issues_count")
    @Expose
    private int openIssuesCount;
    @SerializedName("forks")
    @Expose
    private int forks;
    @SerializedName("open_issues")
    @Expose
    private int openIssues;
    @SerializedName("watchers")
    @Expose
    private int watchers;
    @SerializedName("default_branch")
    @Expose
    private String defaultBranch;
    @SerializedName("score")
    @Expose
    private double score;
    @SerializedName("stargazers_count")
    @Expose
    private int stars;
    @SerializedName("clone_url")
    @Expose
    private String cloneUrl;

    public Items(int id, String name, String fullName, boolean isPrivate, ItemsOwner owner, String htmlUrl, String description, boolean isFork, String createdAt, String updatedAt, String pushedAt, String language, int openIssuesCount, int forks, int openIssues, int watchers, String defaultBranch, double score, int stars, String cloneUrl) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.isPrivate = isPrivate;
        this.owner = owner;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.isFork = isFork;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
        this.language = language;
        this.openIssuesCount = openIssuesCount;
        this.forks = forks;
        this.openIssues = openIssues;
        this.watchers = watchers;
        this.defaultBranch = defaultBranch;
        this.score = score;
        this.stars = stars;
        this.cloneUrl = cloneUrl;
    }


    protected Items(Parcel in) {
        id = in.readInt();
        name = in.readString();
        fullName = in.readString();
        isPrivate = in.readByte() != 0;
        owner = in.readParcelable(ItemsOwner.class.getClassLoader());
        htmlUrl = in.readString();
        description = in.readString();
        isFork = in.readByte() != 0;
        createdAt = in.readString();
        updatedAt = in.readString();
        pushedAt = in.readString();
        language = in.readString();
        openIssuesCount = in.readInt();
        forks = in.readInt();
        openIssues = in.readInt();
        watchers = in.readInt();
        defaultBranch = in.readString();
        score = in.readDouble();
        stars = in.readInt();
        cloneUrl = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ItemsOwner getOwner() {
        return owner;
    }

    public void setOwner(ItemsOwner owner) {
        this.owner = owner;
    }

    public int getStars() {
        return stars;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeByte((byte) (isPrivate ? 1 : 0));
        dest.writeParcelable(owner, flags);
        dest.writeString(htmlUrl);
        dest.writeString(description);
        dest.writeByte((byte) (isFork ? 1 : 0));
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(pushedAt);
        dest.writeString(language);
        dest.writeInt(openIssuesCount);
        dest.writeInt(forks);
        dest.writeInt(openIssues);
        dest.writeInt(watchers);
        dest.writeString(defaultBranch);
        dest.writeDouble(score);
        dest.writeInt(stars);
        dest.writeString(cloneUrl);
    }
}

package com.xapo.githubrepos.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubRepo {
    @SerializedName("total_count")
    @Expose
    private int totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private boolean isIncompleteResults;
    @SerializedName("items")
    @Expose
    private List<Items> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return isIncompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        isIncompleteResults = incompleteResults;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}

package com.xapo.githubrepos.datasource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

public class RepoDataFactory extends DataSource.Factory {
    //creating the mutable live data
    private MutableLiveData<RepoDataSource> mutableLiveData;
    private RepoDataSource repoDataSource;

    public RepoDataFactory() {
        this.mutableLiveData = new MutableLiveData<RepoDataSource>();
    }

    @Override
    public DataSource create() {
        //getting our data source object
        repoDataSource = new RepoDataSource();
        //posting the datasource to get the values
        mutableLiveData.postValue(repoDataSource);
        //returning the datasource
        return repoDataSource;
    }

    //getter for itemlivedatasource
    public MutableLiveData<RepoDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}

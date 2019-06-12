package com.xapo.githubrepos.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.xapo.githubrepos.datasource.RepoDataFactory;
import com.xapo.githubrepos.service.model.Items;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ItemViewModel extends ViewModel {

    private Executor executor;
    private LiveData<PagedList<Items>> itemPagedList;

    public ItemViewModel() {
        init();
    }

    /**
     * Get instance of datasource factory and build pagelist
     */
    private void init() {
        //Initializing an Executor class
        executor = Executors.newFixedThreadPool(5);
        //Get Instance of DataSourceFactory class
        RepoDataFactory repoDataFactory = new RepoDataFactory();
        //Getting Pagelist config
        PagedList.Config pagedListConfig = (new PagedList.Config.Builder()).setEnablePlaceholders(false).setInitialLoadSizeHint(10).setPageSize(10).build();
        //Building the pagelist
        itemPagedList = (new LivePagedListBuilder(repoDataFactory, pagedListConfig)).setFetchExecutor(executor).build();
    }

    /*
     * Getter method for the pageList
     */
    public LiveData<PagedList<Items>> getItemLiveData() {
        return itemPagedList;
    }
}

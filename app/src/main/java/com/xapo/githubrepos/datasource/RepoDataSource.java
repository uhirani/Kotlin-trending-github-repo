package com.xapo.githubrepos.datasource;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.xapo.githubrepos.service.model.GithubRepo;
import com.xapo.githubrepos.service.model.Items;
import com.xapo.githubrepos.service.repository.GithubRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoDataSource extends PageKeyedDataSource<Integer, Items> {
    private static final String TAG = RepoDataSource.class.getSimpleName();

    private GithubRepository repository;
    private static final int FIRST_PAGE = 1;

    public RepoDataSource() {
        this.repository = GithubRepository.getInstance();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Items> callback) {
        GithubRepository.getApi().getTrendingRepositories("kotlin", FIRST_PAGE).enqueue(new Callback<GithubRepo>() {
            @Override
            public void onResponse(Call<GithubRepo> call, Response<GithubRepo> response) {
                if (response.isSuccessful()) {
                    if(response.body() !=null && response.body().getItems() != null && response.body().getItems().size()>0){
                        callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);}
                }
            }

            @Override
            public void onFailure(Call<GithubRepo> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Items> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Items> callback) {
        GithubRepository.getApi().getTrendingRepositories("kotlin", params.key).enqueue(new Callback<GithubRepo>() {
            @Override
            /*
             * If the request is successful, then it will update the callback with the latest repo items and
             * "params.key+1" -> set the next key for the next iteration.
             **/
             public void onResponse(Call<GithubRepo> call, Response<GithubRepo> response) {
                if (response.isSuccessful()) {
                    int nextKey = (params.key == response.body().getTotalCount()) ? null : params.key + 1;
                    if(response.body() !=null && response.body().getItems() != null && response.body().getItems().size()>0){
                        callback.onResult(response.body().getItems(), nextKey); }
                }
             }

            @Override
            public void onFailure(Call<GithubRepo> call, Throwable t) {

            }
        });
    }
}

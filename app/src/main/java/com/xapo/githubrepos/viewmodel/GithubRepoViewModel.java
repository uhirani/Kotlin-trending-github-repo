package com.xapo.githubrepos.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.xapo.githubrepos.service.model.GithubRepo;
import com.xapo.githubrepos.service.repository.GithubRepository;

public class GithubRepoViewModel extends AndroidViewModel {
    private LiveData<GithubRepo> githubRepoLiveData;
    public ObservableField<GithubRepo> repo = new ObservableField<>();

    public GithubRepoViewModel(@NonNull Application application) {
        super(application);
        githubRepoLiveData = GithubRepository.getInstance().getTrendingRepositories("kotlin", 10);
    }

    public LiveData<GithubRepo> getObservableTrendingRepos() {
        return githubRepoLiveData;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory{

        @NonNull
        private final Application application;

        public Factory(@NonNull Application application) {
            this.application = application;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new GithubRepoViewModel(application);
        }
    }
}

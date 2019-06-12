package com.xapo.githubrepos.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.xapo.githubrepos.service.model.GithubRepo;
import com.xapo.githubrepos.utility.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRepository {

    private GithubService githubService;
    private static GithubRepository githubRepository;

    public GithubRepository() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
////                Request original = chain.request();
////                HttpUrl originalHttpUrl = original.url();
////                HttpUrl url = originalHttpUrl.newBuilder()
////                        .build();
////                Request request = original.newBuilder()
////                        .url(url).build();
//                Request.Builder builder = chain.request().newBuilder();
//                return chain.proceed(builder.build());
//            }
//        });

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubService = mRetrofit.create(GithubService.class);
    }

    public synchronized static GithubRepository getInstance() {
        if (githubRepository == null) {
                githubRepository = new GithubRepository();
        }
        return githubRepository;
    }

    public static GithubService getApi(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mRetrofit.create(GithubService.class);
    }

    public LiveData<GithubRepo> getTrendingRepositories(String q, int page){
        final MutableLiveData<GithubRepo> data = new MutableLiveData<>();
        githubService.getTrendingRepositories(q, page).enqueue(new Callback<GithubRepo>() {
            @Override
            public void onResponse(Call<GithubRepo> call, retrofit2.Response<GithubRepo> response) {
                if (response.isSuccessful())
                    Log.v("Success", new Gson().toJson(response.body()));
                else
                    Log.v("unSuccess", new Gson().toJson(response.errorBody()));
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GithubRepo> call, Throwable t) {
                Log.e("Failure", t.toString());
                data.setValue(null);
            }
        });
        return data;
    }
}

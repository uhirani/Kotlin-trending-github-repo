package com.xapo.githubrepos.service.repository;


import com.xapo.githubrepos.service.model.GithubRepo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    /**
     * Get trending github repos of "kotlin"
     * @param q query param
     * @param page  page number
     * @return list of github repositiory list
     */
    @GET("search/repositories?sort=stars&order=desc&per_page=10")
    Call<GithubRepo> getTrendingRepositories(@Query("q") String q,
                                             @Query("page") int page);
}

package com.example.testappandroidjetback.MVVMTest.repository;

import com.example.testappandroidjetback.MVVMTest.model.News;
import com.example.testappandroidjetback.constants.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface NewsService {
    String URL = Constants.API_URL;

    @GET("top-headlines")
    Call<News> getNews(@Query("sources") String source);
}

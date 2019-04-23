package com.example.testappandroidjetback.MVVMTest.repository;

import android.util.Log;

import com.example.testappandroidjetback.BuildConfig;
import com.example.testappandroidjetback.MVVMTest.model.News;

import java.io.IOException;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {
    private NewsService newsService;
    private static NewsRepository newsRepository;

    public synchronized static NewsRepository getInstance() {
        if (newsRepository == null) {
            synchronized (NewsRepository.class) {
                if (newsRepository == null) {
                    newsRepository = new NewsRepository();
                }
            }
        }
        return newsRepository;
    }

    private NewsRepository() {

        OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder();

        addInterceptor(httpClient);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsService.URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsService = retrofit.create(NewsService.class);

    }

    private void addInterceptor(OkHttpClient.Builder httpClient) {
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apiKey", BuildConfig.NewsApiKey)
                        .build();

                Request request = original.newBuilder()
                        .url(url).build();
                return chain.proceed(request);
            }
        });
    }

    public LiveData<News> getNews(String source) {
        final MutableLiveData<News> mutableLiveData = new MutableLiveData<>();
        newsService.getNews(source).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                mutableLiveData.setValue(response.body());
                Log.i("Response", response.body().toString());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.i("Network", t.toString());
            }
        });
        return mutableLiveData;
    }
}

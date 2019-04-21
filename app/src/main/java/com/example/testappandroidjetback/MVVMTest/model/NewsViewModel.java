package com.example.testappandroidjetback.MVVMTest.model;

import android.app.Application;

import com.example.testappandroidjetback.MVVMTest.repository.NewsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NewsViewModel extends AndroidViewModel {

    private final LiveData<News> newsLiveData;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsLiveData = NewsRepository.getInstance().getNews("cnbc");
    }

    public LiveData<News> getObservableObject(){
        return newsLiveData;
    }

    /*public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        public Factory(@NonNull Application application) {
            this.application = application;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new NewsViewModel(Application);
        }
    }*/
}

package com.example.testappandroidjetback.MVVMTest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.testappandroidjetback.MVVMTest.model.News;
import com.example.testappandroidjetback.MVVMTest.model.NewsViewModel;
import com.example.testappandroidjetback.R;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activty);

        if(savedInstanceState == null){
            ArticleListFragment articleListFragment = new ArticleListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, articleListFragment, articleListFragment.TAG).commit();
        }

    }


}

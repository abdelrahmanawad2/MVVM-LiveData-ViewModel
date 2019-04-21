package com.example.testappandroidjetback.MVVMTest.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testappandroidjetback.MVVMTest.model.News;
import com.example.testappandroidjetback.MVVMTest.model.NewsViewModel;
import com.example.testappandroidjetback.R;
import com.example.testappandroidjetback.databinding.ArticlesFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class ArticleListFragment extends Fragment {

    public static final String TAG = "ARTICLES_FRAGMENT_TAG";
    private ArticlesFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.articles_fragment ,container, false);

        binding.projectList.setAdapter(new NewsAdapter());
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final NewsViewModel viewModel = ViewModelProviders.of(this)
                .get(NewsViewModel.class);

        binding.setIsLoading(true);

        observeViewModel(viewModel);

    }

    private void observeViewModel(NewsViewModel viewModel) {

        viewModel.getObservableObject().observe(this, new Observer<News>() {
            @Override
            public void onChanged(News news) {
                binding.setIsLoading(false);
            }
        });

    }
}

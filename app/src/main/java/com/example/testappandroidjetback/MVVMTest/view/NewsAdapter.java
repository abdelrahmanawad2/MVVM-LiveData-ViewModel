package com.example.testappandroidjetback.MVVMTest.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testappandroidjetback.R;
import com.example.testappandroidjetback.databinding.RecyclerRowBinding;
import com.gauravgoyal.mvvm_with_testing.service.model.Article;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<? extends Article> articleList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding recyclerRowBinding;

        public ViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.recyclerRowBinding = binding;
        }
    }

    public NewsAdapter(List<? extends Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerRowBinding recyclerRowBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_row, parent, false);

        return new ViewHolder(recyclerRowBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recyclerRowBinding.setArticle(articleList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleList == null ? 0 : articleList.size();
    }
}
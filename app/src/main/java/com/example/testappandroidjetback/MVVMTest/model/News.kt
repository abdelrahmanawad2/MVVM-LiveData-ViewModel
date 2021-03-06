package com.example.testappandroidjetback.MVVMTest.model

import com.gauravgoyal.mvvm_with_testing.service.model.Article
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class News {
    @SerializedName("status")
    @Expose
    val status: String? = null
    @SerializedName("totalResults")
    @Expose
    val totalResults: Int = 0
    @SerializedName("articles")
    @Expose
    val articles: List<Article>? = null

}
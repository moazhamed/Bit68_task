package com.example.bit68task.Api;

import com.example.bit68task.Api.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("task/categories")
    Call<List<Category>> getCategories();

}

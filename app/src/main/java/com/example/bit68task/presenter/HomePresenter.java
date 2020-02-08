package com.example.bit68task.presenter;

//import android.content.Context;

import com.example.bit68task.Api.NetworkManager;
import com.example.bit68task.Api.model.Category;
import com.example.bit68task.view.HomeView;
//import com.example.bit68task.database.CategoriesDataBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }


//
//    public List<Category> getCategoriesList() {
//        if (CategoriesDataBase.getInstance(context).DaoAccess().getCategories() != null) {
//            return CategoriesDataBase.getInstance(context).DaoAccess().getCategories();
//        } else {
//            callGetCategoriesApi();
//        }
//        return CategoriesDataBase.getInstance(context).DaoAccess().getCategories();
//
//    }


    public void callGetCategoriesApi() {
        view.showLoading();
        NetworkManager.getApi().getCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                view.hideLoading();
                view.renderCategories(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                view.hideLoading();
            }
        });

    }

}

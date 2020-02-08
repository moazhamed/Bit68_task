package com.example.bit68task.view;

import com.example.bit68task.Api.model.Category;

import java.util.List;

public interface HomeView {
    void renderCategories(List<Category> categories);
    void showLoading();
    void hideLoading();
}

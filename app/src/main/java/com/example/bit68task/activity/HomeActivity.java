package com.example.bit68task.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.bit68task.Api.model.Category;
import com.example.bit68task.view.HomeView;
import com.example.bit68task.R;
import com.example.bit68task.fragment.CategoriesFragment;
import com.example.bit68task.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView {

    ProgressBar progressBar;
    public static final String KEY_CATEGORY = "category";
    HomePresenter presenter = new HomePresenter(this);
    Bundle bundle = new Bundle();
    CategoriesFragment fragmet = new CategoriesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressBar = findViewById(R.id.progressBar);
        presenter.callGetCategoriesApi();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
    }

    @Override
    public void renderCategories(List<Category> categories) {
        bundle.putParcelableArrayList(KEY_CATEGORY, (ArrayList<? extends Parcelable>) categories);
        fragmet.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmet)
                .commit();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
}

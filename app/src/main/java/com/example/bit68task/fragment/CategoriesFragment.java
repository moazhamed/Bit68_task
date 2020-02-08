package com.example.bit68task.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.bit68task.Api.model.Category;
import com.example.bit68task.R;
import com.example.bit68task.activity.HomeActivity;
import com.example.bit68task.adapter.CategoriesAdapter;
import com.example.bit68task.adapter.ImageAdapter;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;

import static com.example.bit68task.activity.HomeActivity.KEY_CATEGORY;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {

    private List<Category> categories;
    private Bundle bundle = new Bundle();
    private ProductsFragment fragment = new ProductsFragment();


    public CategoriesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        categories = getArguments().getParcelableArrayList(KEY_CATEGORY);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager pager = view.findViewById(R.id.viewPager);
        CircleIndicator indicator = view.findViewById(R.id.indicator);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);


        CategoriesAdapter adapter = new CategoriesAdapter(categories, getContext(), new CategoriesAdapter.onItemClickListner() {
            @Override
            public void onItemClick(Category category) {
                bundle.putParcelable(KEY_CATEGORY, category);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, fragment).commit();
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        ImageAdapter imagesAdapter = new ImageAdapter(getContext());
        pager.setAdapter(imagesAdapter);
        indicator.setViewPager(pager);

    }

}

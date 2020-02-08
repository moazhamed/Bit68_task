package com.example.bit68task.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bit68task.Api.model.Category;
import com.example.bit68task.Api.model.Product;
import com.example.bit68task.R;
import com.example.bit68task.activity.HomeActivity;
import com.example.bit68task.adapter.ProductsAdapter;
import com.squareup.picasso.Picasso;

import static com.example.bit68task.activity.HomeActivity.KEY_CATEGORY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    public static final String KEY_PRODUCT_NAME = "";
    private Category category;

    public ProductsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_fragmet, container, false);
        category = getArguments().getParcelable(KEY_CATEGORY);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle(category.getName());
        ((HomeActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        return view;
    }

    @Override
    public void onStop() {
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("");
        ((HomeActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        super.onStop();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView categoryImage = view.findViewById(R.id.categoryIV);
        RecyclerView recyclerView = view.findViewById(R.id.productsRV);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ProductsAdapter adapter = new ProductsAdapter(getContext(), category.getProducts(), new ProductsAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_PRODUCT_NAME, product.getName());
                ProductDetailsFragment fragment = new ProductDetailsFragment();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });
        recyclerView.setAdapter(adapter);
        Picasso.with(getContext())
                .load(category.getCategory_img())
                .fit()
                .into(categoryImage);
    }
}

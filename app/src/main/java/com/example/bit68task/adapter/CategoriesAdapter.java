package com.example.bit68task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bit68task.Api.model.Category;
import com.example.bit68task.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<Category> list;
    Context context;
    onItemClickListner onItemClickListner;

    public CategoriesAdapter(List<Category> list, Context context, onItemClickListner onItemClickListner) {
        this.list = list;
        this.context = context;
        this.onItemClickListner = onItemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category item = list.get(position);
        holder.categoryName.setText(item.getName());
        Picasso.with(context)
                .load(item.getCategory_img())
                .fit()
                .into(holder.categoryImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListner.onItemClick( item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;

        public ViewHolder(View view) {
            super(view);
            categoryImage = view.findViewById(R.id.categoryIV);
            categoryName = view.findViewById(R.id.categoryTV);
        }
    }

    public interface onItemClickListner {
        void onItemClick(Category category);
    }
}

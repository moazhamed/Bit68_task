package com.example.bit68task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bit68task.Api.model.Product;
import com.example.bit68task.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    Context context;
    List<Product> list;
    onItemClickListener onItemClickListener;


    public ProductsAdapter(Context context, List<Product> list, onItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product item = list.get(position);
        holder.productName.setText(item.getName());
        holder.productPrice.setText(item.getPrice());
        holder.productWeight.setText(item.getWeight());
        Picasso.with(context)
                .load(item.getProduct_img())
                .fit()
                .into(holder.productImage);
        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(item);

            }
        });

        holder.icCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // only toggles the state of button
                v.setActivated(!v.isActivated());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage, icCheck;
        TextView productName, productWeight, productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productIV);
            productName = itemView.findViewById(R.id.productNameTV);
            productWeight = itemView.findViewById(R.id.productWeightTV);
            productPrice = itemView.findViewById(R.id.productPriceTV);
            icCheck = itemView.findViewById(R.id.ic_check);

        }
    }


    public interface onItemClickListener {
        void onItemClick(Product product);
    }
}

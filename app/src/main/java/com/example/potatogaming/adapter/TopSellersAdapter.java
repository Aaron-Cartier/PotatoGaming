package com.example.potatogaming.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.potatogaming.MainActivity;
import com.example.potatogaming.R;
import com.example.potatogaming.model.TopSellers;

import java.util.List;

public class TopSellersAdapter extends RecyclerView.Adapter<TopSellersAdapter.TopSellersViewHolder> {

    Context context;
    List<TopSellers> topSellersList;

    public TopSellersAdapter(Context context, List<TopSellers> topSellersList) {
        this.context = context;
        this.topSellersList = topSellersList;
    }

    @NonNull
    @Override
    public TopSellersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_seller_games, parent, false);
        return new TopSellersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSellersViewHolder holder, int i) {

        holder.topSellersImageView.setImageResource(topSellersList.get(i).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return topSellersList.size();
    }

    public static class TopSellersViewHolder extends RecyclerView.ViewHolder{

        ImageView topSellersImageView;

        public TopSellersViewHolder(@NonNull View itemView) {
            super(itemView);

            topSellersImageView = itemView.findViewById(R.id.topSellersImage);
        }
    }
}

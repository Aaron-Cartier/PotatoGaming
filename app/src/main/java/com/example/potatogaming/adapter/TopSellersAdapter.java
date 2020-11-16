package com.example.potatogaming.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.potatogaming.GameInfo;
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
    public void onBindViewHolder(@NonNull final TopSellersViewHolder holder, int i) {

        holder.topSellersImageView.setImageResource(topSellersList.get(i).getImage());
        holder.title.setText(topSellersList.get(i).getTitle());
        holder.description.setText(topSellersList.get(i).getDescription());
        holder.platform.setText(topSellersList.get(i).getPlatform());
        holder.developer.setText(topSellersList.get(i).getDeveloper());
        holder.price.setText(topSellersList.get(i).getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameInfo.class);
                intent.putExtra("Image", topSellersList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Title", topSellersList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("Description", topSellersList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Platform", topSellersList.get(holder.getAdapterPosition()).getPlatform());
                intent.putExtra("Developer", topSellersList.get(holder.getAdapterPosition()).getDeveloper());
                intent.putExtra("Price", topSellersList.get(holder.getAdapterPosition()).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return topSellersList.size(); }

    public static class TopSellersViewHolder extends RecyclerView.ViewHolder{
        TextView title, description, platform, developer, price, img;
        ImageView topSellersImageView;

        CardView cardView;

        public TopSellersViewHolder(@NonNull View itemView) {
            super(itemView);
            topSellersImageView = itemView.findViewById(R.id.topSellersImg);
            title = itemView.findViewById(R.id.ivTitle);
            description = itemView.findViewById(R.id.ivDescription);
            platform = itemView.findViewById(R.id.ivPlatform);
            developer = itemView.findViewById(R.id.ivDeveloper);
            price = itemView.findViewById(R.id.ivPrice);

            cardView = itemView.findViewById(R.id.myCardView);
        }
    }
}

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
import com.example.potatogaming.model.NewReleases;

import java.util.List;

public class NewReleasesAdapter extends RecyclerView.Adapter<NewReleasesAdapter.NewReleasesViewHolder> {

    Context context;
    List<NewReleases> newReleasesList;

    public NewReleasesAdapter(Context context, List<NewReleases> newReleasesList) {
        this.context = context;
        this.newReleasesList = newReleasesList;
    }

    @NonNull
    @Override
    public NewReleasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_releases, parent, false);
        return new NewReleasesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewReleasesViewHolder holder, int i) {
        holder.newReleasesImageView.setImageResource(newReleasesList.get(i).getImage());
        holder.title.setText(newReleasesList.get(i).getTitle());
        holder.description.setText(newReleasesList.get(i).getDescription());
        holder.platform.setText(newReleasesList.get(i).getPlatform());
        holder.developer.setText(newReleasesList.get(i).getDeveloper());
        holder.price.setText(newReleasesList.get(i).getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameInfo.class);
                intent.putExtra("Image", newReleasesList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Title", newReleasesList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("Description", newReleasesList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Platform", newReleasesList.get(holder.getAdapterPosition()).getPlatform());
                intent.putExtra("Developer", newReleasesList.get(holder.getAdapterPosition()).getDeveloper());
                intent.putExtra("Price", newReleasesList.get(holder.getAdapterPosition()).getPrice());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() { return newReleasesList.size(); }

    public static class NewReleasesViewHolder extends RecyclerView.ViewHolder{
        TextView title, description, platform, developer, price, img;
        ImageView newReleasesImageView;

        CardView cardView;

        public NewReleasesViewHolder(@NonNull View itemView) {
            super(itemView);
            newReleasesImageView = itemView.findViewById(R.id.newReleasesImg);
            title = itemView.findViewById(R.id.ivTitle);
            description = itemView.findViewById(R.id.ivDescription);
            platform = itemView.findViewById(R.id.ivPlatform);
            developer = itemView.findViewById(R.id.ivDeveloper);
            price = itemView.findViewById(R.id.ivPrice);

            cardView = itemView.findViewById(R.id.myCardView);

        }
    }
}

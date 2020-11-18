package com.example.potatogaming;

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
import com.example.potatogaming.model.NewReleases;

import java.util.List;

public class Ps4Adapter extends RecyclerView.Adapter<Ps4ViewHolder> {
    Context context;

    public Ps4Adapter(Context context, List<NewReleases> ps4GamesList) {
        this.context = context;
        this.ps4GamesList = ps4GamesList;
    }

    List<NewReleases> ps4GamesList;

    @NonNull
    @Override
    public Ps4ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ps4_layout, parent, false);
        return new Ps4ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Ps4ViewHolder holder, int i) {
        holder.ps4ImageView.setImageResource(ps4GamesList.get(i).getImage());
        holder.title.setText(ps4GamesList.get(i).getTitle());
        holder.description.setText(ps4GamesList.get(i).getDescription());
        holder.platform.setText(ps4GamesList.get(i).getPlatform());
        holder.developer.setText(ps4GamesList.get(i).getDeveloper());
        holder.price.setText(ps4GamesList.get(i).getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameInfo.class);
                intent.putExtra("Image", ps4GamesList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Title", ps4GamesList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("Description", ps4GamesList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Platform", ps4GamesList.get(holder.getAdapterPosition()).getPlatform());
                intent.putExtra("Developer", ps4GamesList.get(holder.getAdapterPosition()).getDeveloper());
                intent.putExtra("Price", ps4GamesList.get(holder.getAdapterPosition()).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return ps4GamesList.size(); }
}

class Ps4ViewHolder extends RecyclerView.ViewHolder{
    TextView title, description, platform, developer, price, img;
    ImageView ps4ImageView;

    CardView cardView;

    public Ps4ViewHolder(@NonNull View itemView) {
        super(itemView);
        ps4ImageView = itemView.findViewById(R.id.ps4Img);
        title = itemView.findViewById(R.id.ivTitle);
        description = itemView.findViewById(R.id.ivDescription);
        platform = itemView.findViewById(R.id.ivPlatform);
        developer = itemView.findViewById(R.id.ivDeveloper);
        price = itemView.findViewById(R.id.ivPrice);

        cardView = itemView.findViewById(R.id.myCardView);
    }
}

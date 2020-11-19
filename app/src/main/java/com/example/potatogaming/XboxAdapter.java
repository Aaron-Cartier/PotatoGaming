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

public class XboxAdapter extends RecyclerView.Adapter<XboxViewHolder> {
    Context context;
    List<NewReleases> xboxGamesList;

    public XboxAdapter(Context context, List<NewReleases> xboxGamesList) {
        this.context = context;
        this.xboxGamesList = xboxGamesList;
    }

    @NonNull
    @Override
    public XboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.xbox_layout, parent, false);
        return new XboxViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final XboxViewHolder holder, int i) {
        holder.xboxImageView.setImageResource(xboxGamesList.get(i).getImage());
        holder.title.setText(xboxGamesList.get(i).getTitle());
        holder.description.setText(xboxGamesList.get(i).getDescription());
        holder.platform.setText(xboxGamesList.get(i).getPlatform());
        holder.developer.setText(xboxGamesList.get(i).getDeveloper());
        holder.price.setText(xboxGamesList.get(i).getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameInfo.class);
                intent.putExtra("Image", xboxGamesList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Title", xboxGamesList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("Description", xboxGamesList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("Platform", xboxGamesList.get(holder.getAdapterPosition()).getPlatform());
                intent.putExtra("Developer", xboxGamesList.get(holder.getAdapterPosition()).getDeveloper());
                intent.putExtra("Price", xboxGamesList.get(holder.getAdapterPosition()).getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return xboxGamesList.size(); }
}

class XboxViewHolder extends RecyclerView.ViewHolder{
    TextView title, description, platform, developer, price, img;
    ImageView xboxImageView;

    CardView cardView;

    public XboxViewHolder(@NonNull View itemView) {
        super(itemView);
        xboxImageView = itemView.findViewById(R.id.xboxImg);
        title = itemView.findViewById(R.id.ivTitle);
        description = itemView.findViewById(R.id.ivDescription);
        platform = itemView.findViewById(R.id.ivPlatform);
        developer = itemView.findViewById(R.id.ivDeveloper);
        price = itemView.findViewById(R.id.ivPrice);

        cardView = itemView.findViewById(R.id.myCardView);
    }
}

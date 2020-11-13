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

import com.bumptech.glide.Glide;

import java.util.List;

public class requestAdapter extends RecyclerView.Adapter<RequestViewHolder>{
    private Context rContext;
    private List<gameRequest> myGameRequestList;

    public requestAdapter(Context rContext, List<gameRequest> myGameRequestList) {
        this.rContext = rContext;
        this.myGameRequestList = myGameRequestList;
    }
    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_requests, parent, false);
        return new RequestViewHolder(rView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RequestViewHolder holder, int i) {
        Glide.with(rContext).load(myGameRequestList.get(i).getGmImage()).into(holder.imageView);
        //holder.imageView.setImageResource(myGameRequestList.get(i).getGmImage());
        holder.mTitle.setText(myGameRequestList.get(i).getGmTitle());
        holder.mDescription.setText(myGameRequestList.get(i).getGmDescription());
        holder.mPlatform.setText(myGameRequestList.get(i).getGmPlatform());
        holder.mDeveloper.setText(myGameRequestList.get(i).getGmDeveloper());
        holder.mPrice.setText(myGameRequestList.get(i).getGmPrice());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rContext, RequestedGameInfo.class);
                intent.putExtra("Image", myGameRequestList.get(holder.getAdapterPosition()).getGmImage());
                intent.putExtra("Title", myGameRequestList.get(holder.getAdapterPosition()).getGmTitle());
                intent.putExtra("Description", myGameRequestList.get(holder.getAdapterPosition()).getGmDescription());
                intent.putExtra("Platform", myGameRequestList.get(holder.getAdapterPosition()).getGmPlatform());
                intent.putExtra("Developer", myGameRequestList.get(holder.getAdapterPosition()).getGmDeveloper());
                intent.putExtra("Price", myGameRequestList.get(holder.getAdapterPosition()).getGmPrice());

                intent.putExtra("keyValue", myGameRequestList.get(holder.getAdapterPosition()).getKey());

                rContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myGameRequestList.size();
    }
}

class RequestViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView mTitle, mDescription, mPlatform, mDeveloper, mPrice;
    CardView mCardView;

    public RequestViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imgOne);
        mTitle = itemView.findViewById(R.id.ivTitle);
        mDescription = itemView.findViewById(R.id.ivDescription);
        mPlatform = itemView.findViewById(R.id.ivPlatform);
        mDeveloper = itemView.findViewById(R.id.ivDeveloper);
        mPrice = itemView.findViewById(R.id.ivPrice);

        mCardView = itemView.findViewById(R.id.myCardView);
    }
}
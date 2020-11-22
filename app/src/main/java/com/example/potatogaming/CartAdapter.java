package com.example.potatogaming;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private Context rContext;
    private List<Cart> cartList;

    public CartAdapter(Context rContext, List<Cart> cartList) {
        this.rContext = rContext;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int i) {
        holder.cTitle.setText(cartList.get(i).getGmTitle());
        holder.cPrice.setText(cartList.get(i).getGmPrice());
    }

    @Override
    public int getItemCount() { return cartList.size(); }
}

class CartViewHolder extends RecyclerView.ViewHolder{
    TextView cTitle, cPrice;
    CardView cCardView;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        cTitle = itemView.findViewById(R.id.ivTitle);
        cPrice = itemView.findViewById(R.id.ivPrice);

        cCardView = itemView.findViewById(R.id.myCardView);
    }
}
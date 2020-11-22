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
    Button clearGame;
    CartAdapter.onClickLister listener;

    public interface onClickLister{
        void btnRemove(String key);
    }

    public CartAdapter(Context rContext, List<Cart> cartList, CartAdapter.onClickLister listener) {
        this.rContext = rContext;
        this.cartList = cartList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, final int i) {
        holder.cTitle.setText(cartList.get(i).getGmTitle());
        holder.cPrice.setText(cartList.get(i).getGmPrice());

        holder.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String key = cartList.get(i).getKey();
               holder.listener.btnRemove(key);
            }
        });
    }

    @Override
    public int getItemCount() { return cartList.size(); }
}

class CartViewHolder extends RecyclerView.ViewHolder{
    TextView cTitle, cPrice;
    CardView cCardView;
    Button clearBtn;
    CartAdapter.onClickLister listener;

    public CartViewHolder(@NonNull View itemView, CartAdapter.onClickLister listener) {
        super(itemView);
        cTitle = itemView.findViewById(R.id.ivTitle);
        cPrice = itemView.findViewById(R.id.ivPrice);
        clearBtn = itemView.findViewById(R.id.btnClearCart);
        this.listener = listener;

        cCardView = itemView.findViewById(R.id.myCardView);
    }
}
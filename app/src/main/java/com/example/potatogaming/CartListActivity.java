package com.example.potatogaming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Cart> myCartList;

    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(CartListActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading cart...");

        myCartList = new ArrayList<>();

        final CartAdapter cAdapter = new CartAdapter(CartListActivity.this, myCartList);
        recyclerView.setAdapter(cAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Cart");

        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                myCartList.clear();

                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()) {
                    Cart cart = itemSnapshot.getValue(Cart.class);
                    cart.setKey(itemSnapshot.getKey());
                    myCartList.add(cart);
                }
                cAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
    }

    public void btnClearCart(View view) {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Cart");
        reference.removeValue();
    }
}
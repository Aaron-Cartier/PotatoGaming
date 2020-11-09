package com.example.potatogaming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class gameRequestListActivity extends AppCompatActivity {

    RecyclerView rRecyclerView;
    List<gameRequest> myGameRequestList;
    gameRequest rGameRequest;

    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_request_list);

        rRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(gameRequestListActivity.this, 1);
        rRecyclerView.setLayoutManager(gridLayoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading requests...");

        myGameRequestList = new ArrayList<>();

        final requestAdapter rAdapter = new requestAdapter(gameRequestListActivity.this, myGameRequestList);
        rRecyclerView.setAdapter(rAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("GameRequest");

        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                myGameRequestList.clear();

                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()) {
                    gameRequest gameRequest = itemSnapshot.getValue(gameRequest.class);
                    myGameRequestList.add(gameRequest);
                }
                rAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });

    }
}
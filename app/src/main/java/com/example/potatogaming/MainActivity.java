package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.potatogaming.adapter.NewReleasesAdapter;
import com.example.potatogaming.adapter.TopSellersAdapter;
import com.example.potatogaming.model.NewReleases;
import com.example.potatogaming.model.TopSellers;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView topSellersRecyclerView, newReleasesRecyclerView;

    TopSellersAdapter topSellersAdapter;
    List<TopSellers> topSellersList;

    NewReleasesAdapter newReleasesAdapter;
    List<NewReleases> newReleasesList;

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topSellersRecyclerView = findViewById(R.id.topSellersRecycler);
        newReleasesRecyclerView = findViewById(R.id.newReleaseRecycler);

        topSellersList = new ArrayList<>();
        topSellersList.add(new TopSellers(1, R.drawable.god_of_war));
        topSellersList.add(new TopSellers(2, R.drawable.halo));
        topSellersList.add(new TopSellers(3, R.drawable.spiderman));
        topSellersList.add(new TopSellers(4, R.drawable.cyberpunk));
        setTopSellersRecycler(topSellersList);

        newReleasesList = new ArrayList<>();
        newReleasesList.add(new NewReleases("Ghost Of Tsushima",".......","PS4",".....","$79.99", R.drawable.ghost_of_tsushima));
        newReleasesList.add(new NewReleases("The Last Of Us Part II",".......","PS4",".....","$79.99", R.drawable.last_of_us));
        newReleasesList.add(new NewReleases("Uncharted: Lost Legacy",".......","PS4",".....","$79.99", R.drawable.uncharted_lost_legacy));
        newReleasesList.add(new NewReleases("Spyro Reignited Trilogy",".......","PS4",".....","$79.99", R.drawable.spyro));
        newReleasesList.add(new NewReleases("Ori And The Blind Forest",".......","XBOX",".....","$79.99", R.drawable.ori));
        setNewReleasesRecycler(newReleasesList);


        Button showCustomerPage = findViewById(R.id.btn_CustomerPage);
        Log.d(TAG, "Creating Customer Page...");
        showCustomerPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, localDatabase.class));
            }
        });
        Button showGameRequestListPage = findViewById(R.id.btnGameRequestListPage);
        Log.d(TAG, "Opening Game Request Page...");
        showGameRequestListPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, gameRequestListActivity.class));
            }
        });
    }

    private void setTopSellersRecycler(List<TopSellers> topSellersList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topSellersRecyclerView.setLayoutManager(layoutManager);

        topSellersAdapter = new TopSellersAdapter(this, topSellersList);
        topSellersRecyclerView.setAdapter(topSellersAdapter);
    }

    private void setNewReleasesRecycler(List<NewReleases> newReleasesList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        newReleasesRecyclerView.setLayoutManager(layoutManager);

        newReleasesAdapter = new NewReleasesAdapter(this, newReleasesList);
        newReleasesRecyclerView.setAdapter(newReleasesAdapter);
    }

    public void btnGameRequestPage(View view) {
        startActivity(new Intent(this, requestActivity.class));
    }
}
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
        topSellersList = new ArrayList<>();
        topSellersList.add(new TopSellers(1, R.drawable.god_of_war));
        topSellersList.add(new TopSellers(2, R.drawable.halo));
        topSellersList.add(new TopSellers(3, R.drawable.spiderman));
        topSellersList.add(new TopSellers(4, R.drawable.cyberpunk));
        setTopSellersRecycler(topSellersList);

        newReleasesRecyclerView = findViewById(R.id.newReleaseRecycler);
        newReleasesList = new ArrayList<>();
        newReleasesList.add(new NewReleases("Ghost Of Tsushima","Ghost of Tsushima is an action-adventure game developed by Sucker Punch Productions and published by Sony Interactive Entertainment. Featuring an open world, it follows Jin Sakai, a samurai on a quest to protect Tsushima Island during the first Mongol invasion of Japan.","Platform: PS4","Developer: Sucker Punch","$79.99", R.drawable.ghost_of_tsushima));
        newReleasesList.add(new NewReleases("The Last Of Us Part II","The Last of Us Part II is a 2020 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4.","Platform: PS4","Developer: Naughty Dog","$59.99", R.drawable.last_of_us));
        newReleasesList.add(new NewReleases("Uncharted: The Lost Legacy","Uncharted: The Lost Legacy is a 2017 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4. It is a standalone expansion to Uncharted 4, and the first Uncharted game not to feature protagonist Nathan Drake. ","Platform: PS4","Developer: Naughty Dog","$19.99", R.drawable.uncharted_lost_legacy));
        newReleasesList.add(new NewReleases("Spyro Reignited Trilogy","Spyro Reignited Trilogy is a platform video game developed by Toys for Bob and published by Activision. It is a collection of remasters of the first three games in the Spyro series: Spyro the Dragon, Ripto's Rage!, and Year of the Dragon.","Platform: PS4","Developer: Toys for Bob, Insomniac Games, Iron Galaxy ","$53.49", R.drawable.spyro));
        newReleasesList.add(new NewReleases("Ori And The Blind Forest","Ori and the Blind Forest is a platform-adventure Metroidvania video game developed by Moon Studios and published by Microsoft Studios. The game was released for Xbox One and Microsoft Windows on March 11, 2015 and for Nintendo Switch on September 27, 2019.","Platform: XBOX","Developer: Moon Studios","$22.09", R.drawable.ori));
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
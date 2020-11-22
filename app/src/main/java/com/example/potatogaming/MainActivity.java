package com.example.potatogaming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        topSellersRecyclerView = findViewById(R.id.topSellersRecycler);
        topSellersList = new ArrayList<>();
        topSellersList.add(new TopSellers("God Of War","God of War is an action-adventure game developed by Santa Monica Studio and published by Sony Interactive Entertainment. Released on April 20, 2018, for the PlayStation 4, it is the eighth installment in the God of War series, the eighth chronologically, and the sequel to 2010's God of War III.","Platform: PS4","Developer: SIE Santa Monica Studio","$19.99", R.drawable.god_of_war));
        topSellersList.add(new TopSellers("Halo 5: Guardians", "Halo 5: Guardians is a first-person shooter video game developed by 343 Industries and published by Microsoft Studios for the Xbox One. The fifth mainline entry and tenth overall in the Halo series, it was released worldwide on October 27, 2015.","Platform: XBOX","Developer: 343 Industries","24.99", R.drawable.halo));
        topSellersList.add(new TopSellers("Spider-Man", "Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment. Based on the Marvel Comics superhero Spider-Man, it is inspired by the long-running comic book mythology and adaptations in other media.","Platform: PS4","Developer: Insomniac Games","$39.99", R.drawable.spiderman));
        topSellersList.add(new TopSellers("Cyberpunk 2077", "Cyberpunk 2077 is an upcoming action role-playing video game developed and published by CD Projekt. It is scheduled to be released for Microsoft Windows, PlayStation 4, PlayStation 5, Stadia, Xbox One, and Xbox Series X/S on 10 December 2020.","Platform: PS4","Developer: CD Projekt, CD Projekt RED","$79.99", R.drawable.cyberpunk));
        setTopSellersRecycler(topSellersList);

        newReleasesRecyclerView = findViewById(R.id.newReleaseRecycler);
        newReleasesList = new ArrayList<>();
        newReleasesList.add(new NewReleases("Ghost Of Tsushima","Ghost of Tsushima is an action-adventure game developed by Sucker Punch Productions and published by Sony Interactive Entertainment. Featuring an open world, it follows Jin Sakai, a samurai on a quest to protect Tsushima Island during the first Mongol invasion of Japan.","Platform: PS4","Developer: Sucker Punch","$79.99", R.drawable.ghost_of_tsushima));
        newReleasesList.add(new NewReleases("The Last Of Us Part II","The Last of Us Part II is a 2020 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4.","Platform: PS4","Developer: Naughty Dog","$59.99", R.drawable.last_of_us));
        newReleasesList.add(new NewReleases("Uncharted: The Lost Legacy","Uncharted: The Lost Legacy is a 2017 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4. It is a standalone expansion to Uncharted 4, and the first Uncharted game not to feature protagonist Nathan Drake. ","Platform: PS4","Developer: Naughty Dog","$19.99", R.drawable.uncharted_lost_legacy));
        newReleasesList.add(new NewReleases("Spyro Reignited Trilogy","Spyro Reignited Trilogy is a platform video game developed by Toys for Bob and published by Activision. It is a collection of remasters of the first three games in the Spyro series: Spyro the Dragon, Ripto's Rage!, and Year of the Dragon.","Platform: PS4","Developer: Toys for Bob, Insomniac Games, Iron Galaxy ","$53.49", R.drawable.spyro));
        newReleasesList.add(new NewReleases("Ori And The Blind Forest","Ori and the Blind Forest is a platform-adventure Metroidvania video game developed by Moon Studios and published by Microsoft Studios. The game was released for Xbox One and Microsoft Windows on March 11, 2015 and for Nintendo Switch on September 27, 2019.","Platform: XBOX","Developer: Moon Studios","$22.09", R.drawable.ori));
        setNewReleasesRecycler(newReleasesList);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                return true;

            case R.id.item2:
                startActivity(new Intent(MainActivity.this, gameRequestListActivity.class));
                return true;

            case R.id.item3:
                startActivity(new Intent(MainActivity.this, localDatabase.class));
                return true;

            case R.id.item4:
                return true;

            case R.id.subitem1: //ps4 activity
                startActivity(new Intent(MainActivity.this, Ps4Activity.class));
                return true;

            case R.id.subitem2: //xbox activity
                startActivity(new Intent(MainActivity.this, XboxActivity.class));
                return true;

            case R.id.item5: //store location
                return true;

            case R.id.item6:
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
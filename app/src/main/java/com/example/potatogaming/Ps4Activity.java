package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.potatogaming.adapter.TopSellersAdapter;
import com.example.potatogaming.model.NewReleases;
import com.example.potatogaming.model.TopSellers;

import java.util.ArrayList;
import java.util.List;

public class Ps4Activity extends AppCompatActivity {
    RecyclerView ps4recyclerView;
    List<NewReleases> gamesListPs4;
    Ps4Adapter ps4Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ps4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ps4recyclerView = findViewById(R.id.ps4recyclerView);
        gamesListPs4 = new ArrayList<>();
        gamesListPs4.add(new NewReleases("God Of War","God of War is an action-adventure game developed by Santa Monica Studio and published by Sony Interactive Entertainment. Released on April 20, 2018, for the PlayStation 4, it is the eighth installment in the God of War series, the eighth chronologically, and the sequel to 2010's God of War III.","Platform: PS4","Developer: SIE Santa Monica Studio","$19.99", R.drawable.god_of_war));
        gamesListPs4.add(new NewReleases("Spider-Man", "Marvel's Spider-Man is a 2018 action-adventure game developed by Insomniac Games and published by Sony Interactive Entertainment. Based on the Marvel Comics superhero Spider-Man, it is inspired by the long-running comic book mythology and adaptations in other media.","Platform: PS4","Developer: Insomniac Games","$39.99", R.drawable.spiderman));
        gamesListPs4.add(new NewReleases("Cyberpunk 2077", "Cyberpunk 2077 is an upcoming action role-playing video game developed and published by CD Projekt. It is scheduled to be released for Microsoft Windows, PlayStation 4, PlayStation 5, Stadia, Xbox One, and Xbox Series X/S on 10 December 2020.","Platform: PS4","Developer: CD Projekt, CD Projekt RED","$79.99", R.drawable.cyberpunk));
        gamesListPs4.add(new NewReleases("Ghost Of Tsushima","Ghost of Tsushima is an action-adventure game developed by Sucker Punch Productions and published by Sony Interactive Entertainment. Featuring an open world, it follows Jin Sakai, a samurai on a quest to protect Tsushima Island during the first Mongol invasion of Japan.","Platform: PS4","Developer: Sucker Punch","$79.99", R.drawable.ghost_of_tsushima));
        gamesListPs4.add(new NewReleases("The Last Of Us Part II","The Last of Us Part II is a 2020 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4.","Platform: PS4","Developer: Naughty Dog","$59.99", R.drawable.last_of_us));
        gamesListPs4.add(new NewReleases("Uncharted: The Lost Legacy","Uncharted: The Lost Legacy is a 2017 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4. It is a standalone expansion to Uncharted 4, and the first Uncharted game not to feature protagonist Nathan Drake. ","Platform: PS4","Developer: Naughty Dog","$19.99", R.drawable.uncharted_lost_legacy));
        gamesListPs4.add(new NewReleases("Spyro Reignited Trilogy","Spyro Reignited Trilogy is a platform video game developed by Toys for Bob and published by Activision. It is a collection of remasters of the first three games in the Spyro series: Spyro the Dragon, Ripto's Rage!, and Year of the Dragon.","Platform: PS4","Developer: Toys for Bob, Insomniac Games, Iron Galaxy ","$53.49", R.drawable.spyro));
        setPs4Recycler(gamesListPs4);

    }

    private void setPs4Recycler(List<NewReleases> gamesListPs4) {
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        ps4recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Ps4Activity.this,2);
        ps4recyclerView.setLayoutManager(gridLayoutManager);

        ps4Adapter = new Ps4Adapter(this, gamesListPs4);
        ps4recyclerView.setAdapter(ps4Adapter);
    }
}
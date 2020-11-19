package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.potatogaming.model.NewReleases;

import java.util.ArrayList;
import java.util.List;

public class XboxActivity extends AppCompatActivity {
    RecyclerView xboxrecyclerView;
    List<NewReleases> gamesListXbox;
    XboxAdapter xboxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xbox);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        xboxrecyclerView = findViewById(R.id.xboxrecyclerView);
        gamesListXbox = new ArrayList<>();
        gamesListXbox.add(new NewReleases("Ori And The Blind Forest","Ori and the Blind Forest is a platform-adventure Metroidvania video game developed by Moon Studios and published by Microsoft Studios. The game was released for Xbox One and Microsoft Windows on March 11, 2015 and for Nintendo Switch on September 27, 2019.","Platform: XBOX","Developer: Moon Studios","$22.09", R.drawable.ori));
        setPs4Recycler(gamesListXbox);
    }

    private void setPs4Recycler(List<NewReleases> gamesListPs4) {
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        ps4recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(XboxActivity.this,2);
        xboxrecyclerView.setLayoutManager(gridLayoutManager);

        xboxAdapter = new XboxAdapter(this, gamesListPs4);
        xboxrecyclerView.setAdapter(xboxAdapter);
    }
}
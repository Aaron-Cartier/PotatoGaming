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
        gamesListXbox.add(new NewReleases("Star Wars: Squadrons","Star Wars: Squadrons is a space combat game set in the Star Wars universe developed by Motive Studios and published by Electronic Arts. It was released for Microsoft Windows, PlayStation 4 and Xbox One on October 2, 2020. The game features both multiplayer game modes and a single-player campaign.","Platform: XBOX","Developer: Motive Studios","$54.99", R.drawable.star_wars));
        gamesListXbox.add(new NewReleases("Far Cry 6","Far Cry 6 is an upcoming first-person shooter game developed by Ubisoft Toronto and published by Ubisoft. It is the sixth main installment of the Far Cry series for Amazon Luna, Microsoft Windows, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S, and Stadia.","Platform: XBOX","Developer: Ubisoft Toronto","$79.99", R.drawable.far_cry));
        gamesListXbox.add(new NewReleases("Assassin's Creed Valhalla","Assassin's Creed Valhalla is an action role-playing video game developed by Ubisoft Montreal and published by Ubisoft. It is the twelfth major installment and the twenty-second release in the Assassin's Creed series, and a successor to the 2018 game Assassin's Creed Odyssey.","Platform: XBOX","Developer: Ubisoft Montreal","$79.99", R.drawable.assassins_creed));
        gamesListXbox.add(new NewReleases("Call Of Duty: Black Ops Cold War","Call of Duty: Black Ops Cold War is a 2020 first-person shooter video game developed by Treyarch and Raven Software and published by Activision. It is the sixth installment in the Black Ops series, and the seventeenth installment in the overall Call of Duty series.","Platform: XBOX","Developer: Treyarch, Raven Software, High Moon Studios, Beenox, Sledgehammer Games","$79.99", R.drawable.call_of_duty));
        gamesListXbox.add(new NewReleases("Halo: Combat Evolved","Halo: Combat Evolved is a first-person shooter video game developed by Bungie and published by Microsoft Game Studios. It was released as a launch title for Microsoft's Xbox video game console on November 15, 2001. Microsoft released versions of the game for Windows and Mac OS X in 2003.","Platform: XBOX","Developer:  Bungie Inc, 343 Industries, Gearbox Software, MacSoft, Saver Interactive, Splash Damage, Rockstar Dundee, Westlake Interactive","$19.99", R.drawable.halo_xbox));
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
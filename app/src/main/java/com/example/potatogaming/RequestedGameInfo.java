package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RequestedGameInfo extends AppCompatActivity {
    ImageView gmImage;
    TextView gmTitle, gmDescription, gmPlatform, gmDeveloper, gmPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_game_info);

        gmTitle = (TextView)findViewById(R.id.ivTitle);
        gmDescription = (TextView)findViewById(R.id.ivDescription);
        gmPlatform = (TextView)findViewById(R.id.ivPlatform);
        gmDeveloper = (TextView)findViewById(R.id.ivDeveloper);
        gmPrice = (TextView)findViewById(R.id.ivPrice);
        gmImage = (ImageView)findViewById(R.id.ivImage);

        Bundle gBundle = getIntent().getExtras();

        if(gBundle != null) {
            gmTitle.setText(gBundle.getString("Title"));
            gmDescription.setText(gBundle.getString("Description"));
            gmPlatform.setText(gBundle.getString("Platform"));
            gmDeveloper.setText(gBundle.getString("Developer"));
            gmPrice.setText(gBundle.getString("Price"));
            gmImage.setImageResource(gBundle.getInt("Image"));

            Glide.with(this).load(gBundle.getString("Image")).into(gmImage);
        }

    }
}
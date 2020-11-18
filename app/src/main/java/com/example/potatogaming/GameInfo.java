package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameInfo extends AppCompatActivity {
    ImageView gmImage;
    TextView gmTitle, gmDescription, gmPlatform, gmDeveloper, gmPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gmTitle = (TextView) findViewById(R.id.ivTitle);
        gmDescription = (TextView) findViewById(R.id.ivDescription);
        gmPlatform = (TextView) findViewById(R.id.ivPlatform);
        gmDeveloper = (TextView) findViewById(R.id.ivDeveloper);
        gmPrice = (TextView) findViewById(R.id.ivPrice);
        gmImage = (ImageView) findViewById(R.id.ivImage);

        Bundle gBundle = getIntent().getExtras();

        if (gBundle != null) {
            gmTitle.setText(gBundle.getString("Title"));
            gmDescription.setText(gBundle.getString("Description"));
            gmPlatform.setText(gBundle.getString("Platform"));
            gmDeveloper.setText(gBundle.getString("Developer"));
            gmPrice.setText(gBundle.getString("Price"));
            gmImage.setImageResource(gBundle.getInt("Image"));
        }
    }

    public void btnAddToCart(View view) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
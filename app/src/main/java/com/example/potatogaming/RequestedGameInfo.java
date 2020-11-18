package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RequestedGameInfo extends AppCompatActivity {
    ImageView gmImage;
    TextView gmTitle, gmDescription, gmPlatform, gmDeveloper, gmPrice;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_game_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            //gmImage.setImageResource(gBundle.getInt("Image"));

            key = gBundle.getString("keyValue");
            imageUrl = gBundle.getString("Image");

            Glide.with(this).load(gBundle.getString("Image")).into(gmImage);
        }

    }

    public void btnDeleteRequest(View view) {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("GameRequest");
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                reference.child(key).removeValue();
                Toast.makeText(RequestedGameInfo.this, "Game Request Deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), gameRequestListActivity.class));
            }
        });
    }

    public void btnUpdateRequest(View view) {
        startActivity(new Intent(getApplicationContext(), updateActivity.class)
                .putExtra("gName", gmTitle.getText().toString())
                .putExtra("gDescription", gmDescription.getText().toString())
                .putExtra("gPlatform", gmPlatform.getText().toString())
                .putExtra("gDeveloper", gmDeveloper.getText().toString())
                .putExtra("gPrice", gmPrice.getText().toString())
                .putExtra("oldimageUrl", imageUrl)
                .putExtra("key", key));
    }
}
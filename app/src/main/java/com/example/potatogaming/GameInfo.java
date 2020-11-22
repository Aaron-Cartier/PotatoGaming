package com.example.potatogaming;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

public class GameInfo extends AppCompatActivity {
    ImageView gmImage;
    TextView gmTitle, gmDescription, gmPlatform, gmDeveloper, gmPrice;
    Cart toCart;

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
       toCart = new Cart(
                gmTitle.getText().toString(), gmPrice.getText().toString()
        );

        String myCurrentDateTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Cart").child(myCurrentDateTime).setValue(toCart).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(GameInfo.this, "Game added to Cart", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(GameInfo.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
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
package com.example.potatogaming;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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

public class updateActivity extends AppCompatActivity {

    ImageView gameImage;
    Uri uri;
    EditText gTitle, gDescription, gPlatform, gDeveloper, gPrice;
    String imageUrl;
    String key, oldimageUrl;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    String name, description, platform, developer, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        gameImage = (ImageView)findViewById(R.id.gameImage);
        gTitle = (EditText)findViewById(R.id.gameTitle);
        gDescription = (EditText)findViewById(R.id.gameDescription);
        gPlatform = (EditText)findViewById(R.id.gamePlatform);
        gDeveloper = (EditText)findViewById(R.id.gameDeveloper);
        gPrice = (EditText)findViewById(R.id.gamePrice);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            Glide.with(updateActivity.this).load(bundle.get("oldimageUrl")).into(gameImage);
            gTitle.setText(bundle.getString("gName"));
            gDescription.setText(bundle.getString("gDescription"));
            gPlatform.setText(bundle.getString("gPlatform"));
            gDeveloper.setText(bundle.getString("gDeveloper"));
            gPrice.setText(bundle.getString("gPrice"));

            key = bundle.getString("key");
            oldimageUrl = bundle.getString("oldimageUrl");
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("GameRequest").child(key);

    }

    public void btnSelectImage(View view) {
        Intent imagePicker = new Intent(Intent.ACTION_PICK);
        imagePicker.setType("image/*");
        startActivityForResult(imagePicker, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            uri = data.getData();
            gameImage.setImageURI(uri);
        } else {
            Toast.makeText(this, "You did not choose an image", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnUpdateRequest(View view) {
        name = gTitle.getText().toString().trim();
        description = gDescription.getText().toString().trim();
        platform = gPlatform.getText().toString().trim();
        developer = gDeveloper.getText().toString().trim();
        price = gPrice .getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating Game Request...");
        progressDialog.show();

        storageReference = FirebaseStorage.getInstance().getReference().child("GameImage").child(uri.getLastPathSegment());

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                uploadRequest();
                progressDialog.dismiss();
                startActivity(new Intent(getApplicationContext(), gameRequestListActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
            }
        });
    }

    public void uploadRequest(){

        gameRequest gmRequest = new gameRequest(name, description, platform, developer, price, imageUrl);

        databaseReference.setValue(gmRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                StorageReference storageReferenceNew = FirebaseStorage.getInstance().getReferenceFromUrl(oldimageUrl);
                storageReferenceNew.delete();
                Toast.makeText(updateActivity.this, "Game Request Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
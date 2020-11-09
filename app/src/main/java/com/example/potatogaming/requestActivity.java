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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

public class requestActivity extends AppCompatActivity {

    ImageView gameImage;
    Uri uri;
    EditText gTitle, gDescription, gPlatform, gDeveloper, gPrice;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        gameImage = (ImageView)findViewById(R.id.gameImage);
        gTitle = (EditText)findViewById(R.id.gameTitle);
        gDescription = (EditText)findViewById(R.id.gameDescription);
        gPlatform = (EditText)findViewById(R.id.gamePlatform);
        gDeveloper = (EditText)findViewById(R.id.gameDeveloper);
        gPrice = (EditText)findViewById(R.id.gamePrice);
    }

    public void btnSelectImage(View view) {
        Intent imagePicker = new Intent(Intent.ACTION_PICK);
        imagePicker.setType("image/*");
        startActivityForResult(imagePicker, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            uri = data.getData();
            gameImage.setImageURI(uri);
        }
        else {
            Toast.makeText(this, "You did not choose an image", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnRequest(View view) {
        uploadImage();
    }

    public void uploadImage(){
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("GameImage").child(uri.getLastPathSegment());

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Game Request Uploaded...");
        progressDialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                uploadRequest();
                progressDialog.dismiss();

                //Toast.makeText(requestActivity.this, "Image Uploaded", Toast.LENGTH_SHORT).show() ;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
            }
        });
    }
    public void uploadRequest(){

        gameRequest gameRequest = new gameRequest(
                gTitle.getText().toString(),
                gDescription.getText().toString(),
                gPlatform.getText().toString(),
                gDeveloper.getText().toString(),
                gPrice.getText().toString(),
                imageUrl
        );

        String myCurrentDateTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("GameRequest").child(myCurrentDateTime).setValue(gameRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(requestActivity.this, "Game Request Uploaded", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(requestActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
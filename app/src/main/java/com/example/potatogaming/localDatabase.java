package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class localDatabase extends AppCompatActivity {

    Button  btn_Viewall, btn_Add;
    EditText et_name, et_age;
    Switch sw_activeCustomer;
    ListView lv_customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_database);

        btn_Add = findViewById(R.id.btn_Add);
        btn_Viewall = findViewById(R.id.btn_Viewall);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        sw_activeCustomer = findViewById(R.id.sw_Active);
        lv_customerList = findViewById(R.id.lv_customerList);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CustomerModel customerModel = new CustomerModel(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_activeCustomer.isChecked());
                }
                catch(Exception e){
                    Toast.makeText(localDatabase.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_Viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
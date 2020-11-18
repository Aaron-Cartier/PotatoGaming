package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ImageReader;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class localDatabase extends AppCompatActivity {

    Button  btn_Viewall, btn_Add;
    EditText et_name, et_age;
    Switch sw_activeCustomer;
    ListView lv_customerList;
    ArrayAdapter customerArrayAdapter;
    DataBaseLocal dataBaseLocal = new DataBaseLocal(localDatabase.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_database);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_Add = findViewById(R.id.btn_Add);
        btn_Viewall = findViewById(R.id.btn_Viewall);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        sw_activeCustomer = findViewById(R.id.sw_Active);
        lv_customerList = findViewById(R.id.lv_customerList);

        final DataBaseLocal dataBaseLocal = new DataBaseLocal(localDatabase.this);
        ShowCustomersOnListView(dataBaseLocal);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerModel customerModel;
                try {
                    customerModel = new CustomerModel(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_activeCustomer.isChecked());
                } catch (Exception e) {
                    Toast.makeText(localDatabase.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    customerModel = new CustomerModel(-1, "error", 0, false);
                }

                DataBaseLocal dataBaseLocal = new DataBaseLocal(localDatabase.this);

                boolean success = dataBaseLocal.addOne(customerModel);

                Toast.makeText(localDatabase.this, "Success = " + success, Toast.LENGTH_SHORT).show();
                ShowCustomersOnListView(dataBaseLocal);

            }
        });

        btn_Viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseLocal dataBaseLocal = new DataBaseLocal(localDatabase.this);
                //List<CustomerModel> everyone = dataBaseLocal.getEveryone();

                //Toast.makeText(localDatabase.this, everyone.toString(), Toast.LENGTH_SHORT).show();
                ShowCustomersOnListView(dataBaseLocal);

            }
        });

        lv_customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerModel clickedCustomer = (CustomerModel) parent.getItemAtPosition(position);
                dataBaseLocal.deleteOne(clickedCustomer);
                ShowCustomersOnListView(dataBaseLocal);
                Toast.makeText(localDatabase.this, "Customer Deleted" + clickedCustomer.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ShowCustomersOnListView(DataBaseLocal dataBaseLocal) {
        customerArrayAdapter = new ArrayAdapter<CustomerModel>(localDatabase.this, android.R.layout.simple_list_item_1, dataBaseLocal.getEveryone());
        lv_customerList.setAdapter(customerArrayAdapter);
    }
}
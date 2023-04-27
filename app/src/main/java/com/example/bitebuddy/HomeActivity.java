package com.example.bitebuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
ArrayList<FoodModel>arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrContacts.add(new FoodModel(R.drawable.back,"chicken","RS.100"));
        arrContacts.add(new FoodModel(R.drawable.logo,"chicken","RS.150"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.190"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.110"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.140"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.190"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.160"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.110"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.180"));
        arrContacts.add(new FoodModel(R.drawable.fbb,"chicken","RS.100"));

       rvFoodAdapter adapter= new rvFoodAdapter(this,arrContacts);
       recyclerView.setAdapter(adapter);


    }
}

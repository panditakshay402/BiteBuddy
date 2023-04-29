package com.example.bitebuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private static final int FOOD1 = R.drawable.food1;
    private static final int FOOD2 = R.drawable.food2;
    private static final int FOOD3 = R.drawable.food3;
    private static final int FOOD4 = R.drawable.food4;
    private static final int FOOD5 = R.drawable.food5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Arrays of food
        ArrayList<MainModel> list= new ArrayList<>();
        list.add(new MainModel(FOOD1, "Combo Items", "6", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(FOOD2, "Burger", "3", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(FOOD3, "Cheese", "6", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(FOOD4, "Hot Dog", "4", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(FOOD5, "Combo Mockup", "3", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(FOOD1, "Combo Items", "6", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerView.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carticon, menu);
        return super.onCreateOptionsMenu(menu);
    }


//    @Override


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.orderIcon) {
            startActivity(new Intent(HomeActivity.this, OrdersActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

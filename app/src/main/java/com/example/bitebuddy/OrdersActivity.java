package com.example.bitebuddy;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    private ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper dBhalper=new DBHelper(this);
        ArrayList<OrdersModel> list = dBhalper.getOrders();

        list.add(new OrdersModel());

//        OrderAdapters adapters = new OrderAdapters(list, this);
//        binding.orderRecyclerView.setAdapter(adapters);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        binding.orderRecyclerView(linearLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(binding.getRoot())
                .setCancelable(false)
                .setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

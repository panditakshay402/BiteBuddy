package com.example.bitebuddy;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapters extends RecyclerView.Adapter<MainAdapters.viewholder>{


    public MainAdapters(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<MainModel> list;
    Context context;

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=(View) LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model= list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.foodName.setText(model.getName());
        holder.foodPrice.setText(model.getPrice());
        holder.foodDescription.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("name", model.getName());
                intent.putExtra("type", 1); //insert
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodName, foodPrice, foodDescription;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.imageFood);
            foodName=itemView.findViewById(R.id.foodName);
            foodPrice=itemView.findViewById(R.id.price);
            foodDescription=itemView.findViewById(R.id.describtion);
        }
    }
}

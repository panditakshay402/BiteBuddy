package com.example.bitebuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvFoodAdapter extends RecyclerView.Adapter<rvFoodAdapter.ViewHolder> {

    Context context;
    ArrayList<FoodModel> arrContacts;
    rvFoodAdapter(Context context, ArrayList<FoodModel> arrContacts){
        this.context=context;
        this.arrContacts= arrContacts;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view=  LayoutInflater.from(context).inflate(R.layout.food_row,parent,false);
      ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtNumber;
        ImageView imgContact;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtNumber=itemView.findViewById(R.id.txtNumber);
            imgContact=itemView.findViewById(R.id.imgContact);

        }

    }

}

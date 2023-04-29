package com.example.bitebuddy;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapters extends RecyclerView.Adapter<OrderAdapters.viewHolder>{

    ArrayList<OrdersModel> list;
    Context context;

    public OrderAdapters(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=(View) LayoutInflater.from(context).inflate(R.layout.orders_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.orderName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.orderPrice.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("id", Integer.parseInt(model.getOrderNumber()));
                i.putExtra("type", 2); //update
                context.startActivity(i);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                new AlertDialog.Builder(context)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DBHelper dBhalper=new DBHelper(context);
                                if(dBhalper.deleteOrder(model.getOrderNumber()) > 0)
                                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderImage;
        TextView orderName, orderNumber, orderPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage=itemView.findViewById(R.id.orderImg);
            orderName=itemView.findViewById(R.id.orderName);
            orderNumber=itemView.findViewById(R.id.orderId);
            orderPrice=itemView.findViewById(R.id.orderPrice);
        }
    }
}

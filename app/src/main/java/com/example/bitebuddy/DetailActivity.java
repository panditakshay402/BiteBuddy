package com.example.bitebuddy;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;


    public static int updateCount;
    public static int updatePrice;
    public static int updateQuantity;
    public static int count = 0;

    public DetailActivity(ActivityDetailBinding binding) {
        this.binding = binding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ((Button) binding.orderButton).setText(R.string.update_now);

        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type", 0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");

            binding.detailImage.setImageResource(image);
            binding.editPrice.setText(String.format("%d", price));
            binding.foodNameQ.setText(name);
            binding.detailDescription.setText(description);

            binding.orderButton.setOnClickListener(view -> {
                boolean isInserted = helper.insertOrder(binding.editNameDetails.getText().toString(),
                        binding.editPhoneDetails.getText().toString(),
                        price, image, description, name,
                        Integer.parseInt(binding.quantity.getText().toString())
                );
                if (isInserted) {
                    Toast.makeText(DetailActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor = helper.getOrderById(id);
            int image = cursor.getInt(5);


            binding.detailImage.setImageResource(image);
            binding.editPrice.setText(String.format("%d", cursor.getInt(4)));
            binding.foodNameQ.setText(cursor.getString(7));
            binding.detailDescription.setText(cursor.getString(6));

            binding.editNameDetails.setText(cursor.getString(1));
            binding.editPhoneDetails.setText(cursor.getString(2));
            binding.quantity.setText(cursor.getString(3));

            ((Button) binding.orderButton).setText("Update Now");
            binding.orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isUpdate = helper.updateOrder(
                            binding.editNameDetails.getText().toString(),
                            binding.editPhoneDetails.getText().toString(),
                            Integer.parseInt(binding.editPrice.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.foodNameQ.getText().toString(),
                            updateCount, id);

                    if (isUpdate)
                        Toast.makeText(DetailActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Not Update", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
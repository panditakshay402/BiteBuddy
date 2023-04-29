package com.example.bitebuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.ads.mediationtestsuite.activities.HomeActivity;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    MaterialButton login;
    DBHelper dbHelper =new DBHelper(this);
//    private SQLiteOpenHelper dbHelper;
//    SQLiteDatabase db = dbHelper.getWritableDatabase();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login=(MaterialButton) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user =username.getText().toString();
                String pass= password.getText().toString();


                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checker=dbHelper.checkusernamepassword(user,pass);
                    if(checker==true){
                        Toast.makeText(LoginActivity.this,"Sign in Successful",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Invalid Credential",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });





    }
}
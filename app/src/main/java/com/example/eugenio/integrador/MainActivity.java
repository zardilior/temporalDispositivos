package com.example.eugenio.integrador;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    String usernameStr, passwordStr;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        usernameStr = username.toString();
        passwordStr = password.toString();
    }
    public void onClickLogin(View v) {
        sp = getSharedPreferences("crm", Context.MODE_PRIVATE);
        String data = sp.getString(usernameStr+passwordStr,"");
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        if (data.length() == 0) {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        } else {
            // Put Extras
            //----
            // Go to Menu
            Intent intent = new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
        }
        Intent intent = new Intent(MainActivity.this, Menu.class);
        startActivity(intent);
    }
    public void onClickRegister(View v) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}

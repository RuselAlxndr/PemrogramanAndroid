package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static final String TAG = Login.class.getSimpleName();
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnlogin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(txtPassword.getText().toString().equals("admin") && txtUsername.getText().toString().equals("admin")){
                    Intent i = new Intent( Login.this, Home.class);
                    Toast.makeText(getApplicationContext(), "SELAMAT DATANG "+ txtUsername.getText(),   Toast.LENGTH_LONG).show();
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"TIDAK MENGETAHUI "+ txtUsername.getText(), Toast.LENGTH_LONG).show();
                }}
        });
    }}

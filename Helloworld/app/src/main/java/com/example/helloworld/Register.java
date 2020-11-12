package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText TxUsername, TxPassword, TxConPassword;
    Button BtnRegister, BtnCancel;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);

        sqliteHelper = new SqliteHelper(this);

        TxUsername = (EditText)findViewById(R.id.email);
        TxPassword = (EditText)findViewById(R.id.password);
        BtnRegister = (Button)findViewById(R.id.btnRegister);
        BtnCancel = (Button)findViewById(R.id.btnCancel);

        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();
                ContentValues values = new ContentValues();

                if (password.equals("") || username.equals("")){
                    Toast.makeText(Register.this, "Password dan username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else {
                    values.put(SqliteHelper.row_username, username);
                    values.put(SqliteHelper.row_password, password);
                    sqliteHelper.insertData(values);

                    Toast.makeText(Register.this, "Register berhasil!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }
}

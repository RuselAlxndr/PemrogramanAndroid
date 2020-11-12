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
    private Button btnregister;

    SqliteHelper sqliteHelper;


    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnregister = findViewById(R.id.btnRegister);
        btnlogin = findViewById(R.id.btnlogin);

        sqliteHelper = new SqliteHelper(this);
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(Login.this, Home.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
//
                String usernamevalue = txtUsername.getText().toString();
                String passwordvalue = txtPassword.getText().toString();
                Boolean check = sqliteHelper.checkUser(usernamevalue,passwordvalue);
                if(check == true){
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    Toast.makeText(Login.this, "Login sukses", Toast.LENGTH_SHORT).show();
                    //SEESSION

                    //SESSION
                    startActivity(new Intent(Login.this, Home.class));
                }else {
                    Toast.makeText(Login.this, "Gagal", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });




    }
}

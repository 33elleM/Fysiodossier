package com.example.steri.fysiodossier;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText nameInput, pwd;
    private DatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHandler = new DatabaseHandler(this);


        nameInput = (EditText) findViewById(R.id.name_input);
        pwd = (EditText) findViewById(R.id.pwd);
        loginButton = (Button) findViewById((R.id.loginButton));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameInput.getText().toString().equals("") && pwd.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Login succesvol", Toast.LENGTH_LONG).show();
                    Intent dossierIntent = new Intent(MainActivity.this, ExamCard.class);
                    startActivity(dossierIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Gebruikersnaam of wachtwoord onjuist", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}

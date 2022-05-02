package com.example.meteocompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    // Atts
    Button buttonRegister;  // Boton para ir al activity registro
    Button buttonLogin;  // Boton para ir al activity login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegister = findViewById(R.id.button_register);            // Asociamos el objeto buttonRegister al boton
        buttonRegister.setOnClickListener(new View.OnClickListener() {  // Y tambien la funcion de registrarse
            @Override
            public void onClick(View v) {
                funcionRegister (v);
            }
        });

        buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcionLogin (v);
            }
        });


    }

    // Al pulsar el boton de registrarse se ejecuta el siguiente codigo
    public void funcionRegister (View v){
        startActivity(new Intent(ActivityMain.this, com.example.meteocompare.Registro.class));
    }

    // Al pulsar el boton de login se ejecuta este otro
    public void funcionLogin (View v){
        startActivity(new Intent(ActivityMain.this, Login.class));
    }
}
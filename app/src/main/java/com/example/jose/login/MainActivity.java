package com.example.jose.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button bEntrar, bRegistrar;
    EditText user, pass;
    final static String TAG_DCONFIR_COM = "confirmacion_com";
    final static String TAG_DPERSO = "confirmacion_perso";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.password);

        bEntrar = findViewById(R.id.bEntrar);
        bRegistrar = findViewById(R.id.bRegistrar);

        bEntrar.setOnClickListener(this);
        bRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = null;
//https://www.youtube.com/watch?v=115ew49WsP4
        if(user.equals(null) && pass.equals(null)){
            DialogoError dDos = DialogoError.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        }




        /*
        if(/*user = jose){
            i = new Intent(getApplicationContext(), AppActivity.class);
            startActivity(i);
        }

        switch (v.getId()){

            case R.id.bRegistrar:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(), TAG_DPERSO);
                break;
*/

        }

    }



































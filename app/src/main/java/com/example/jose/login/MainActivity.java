package com.example.jose.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button bEntrar, bRegistrar;
    EditText usuario;
    final static String TAG_DCONFIR_COM = "confirmacion_com";
    final static String TAG_DPERSO = "confirmacion_perso";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bEntrar = findViewById(R.id.bEntrar);
        bRegistrar = findViewById(R.id.bRegistrar);

        bEntrar.setOnClickListener(this);
        bRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        //
        switch (v.getId()){
            case R.id.bEntrar:
                //HAY ALGUNA FORMA DE HACER ESTA CONDICION, PERO DEMEOMTO NO SE ME OCURRE

                //aqui iria una conficion:

                //Condicion ID si no estan vacios los EditText saltará la actrivity
                i = new Intent(getApplicationContext(), AppActivity.class);
                startActivity(i);

                //Condicion ELSE: si estan vacios, saltará el dialogo
                DialogoError dDos = DialogoError.newInstance("Error");
                dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
                break;
                //HJjj

            case R.id.bRegistrar:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(), TAG_DPERSO);
                break;
        }

    }





}





























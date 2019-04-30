package com.example.jose.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jose.login.dialogos.DialogoError;
import com.example.jose.login.dialogos.DialogoErrorBad;
import com.example.jose.login.dialogos.DialogoErrorPass;
import com.example.jose.login.dialogos.DialogoErrorPassBad;
import com.example.jose.login.dialogos.DialogoErrorUser;
import com.example.jose.login.dialogos.DialogoErrorUserBad;

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

        //DOS
        if (user.getText().toString().isEmpty() && pass.getText().toString().isEmpty()) {
            DialogoError dDos = DialogoError.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        }
        else if (!user.getText().toString().equals("pepe") && !pass.getText().toString().equals("pepe")) {
            DialogoErrorBad dDos = DialogoErrorBad.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        }

        //USUARIO
        else if (user.getText().toString().isEmpty()) {
            DialogoErrorUser dDos = DialogoErrorUser.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        }
         else if (!user.getText().toString().equals("pepe")) {
            DialogoErrorUserBad dDos = DialogoErrorUserBad.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        }


        //PASSWORD
        else if (pass.getText().toString().isEmpty()) {
            DialogoErrorPass dDos = DialogoErrorPass.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        } else if (!pass.getText().toString().equals("pepe")) {
            DialogoErrorPassBad dDos = DialogoErrorPassBad.newInstance("Error");
            dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
        }

        //ENTRA
        else {
            i = new Intent(getApplicationContext(), AppActivity.class);
            startActivity(i);
        }





        /*
        switch (v.getId()){

            case R.id.bRegistrar:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(), TAG_DPERSO);
                break;


        }
        */

    }
}



































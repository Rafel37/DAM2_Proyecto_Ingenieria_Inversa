package com.example.jose.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bEntrar;
    TextView bRegistrar, campoNombre, campoPass;
    EditText user, pass;
    EditText nombreDialogo, apellidoDialogo, edadDialogo;
    final static String TAG_DCONFIR_COM = "confirmacion_com";
    final static String TAG_DPERSO = "confirmacion_perso";
    Intent i = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void instancias() {
        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.password);

        nombreDialogo = findViewById(R.id.nombreDialogo);
        apellidoDialogo = findViewById(R.id.apellidoDialogo);
        edadDialogo = findViewById(R.id.edadDialogo);
        bEntrar = findViewById(R.id.bEntrar);
        bRegistrar = findViewById(R.id.bRegistrar);

        campoNombre = findViewById(R.id.campoNombre);
        campoPass = findViewById(R.id.campoPass);

    }

    private void acciones() {
        bEntrar.setOnClickListener(this);

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), ActivityRegistro.class);
                startActivity(i);
            }
        });
    }


    @Override

    public void onClick(View v) {





        /*
        //VIDEO UNO: https://www.youtube.com/watch?v=0IFdzxK2nPo
        String usuario = user.getText().toString();
        String[] datos;
        datos = buscarReg(usuario);
        */


        /*
        //VIDEO DOS:  https://www.youtube.com/watch?v=ml0i0hnL_WY
        SQLiteDatabase db=helperDB.getReadableDatabase();
        String[] parametros={user.getText().toString(), pass.getText().toString()};
        String[] campos={DatosBD.TAB_PER_NOM, DatosBD.TAB_PER_PASS};

        try{
            Cursor cursor = db.query(DatosBD.TAB_PER, campos, DatosBD.TAB_PER_NOM+"=?", parametros, null, null, null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoPass.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_SHORT).show();
            limpiar();
        }
/*
 database = helperDB.getWritableDatabase();
        String query = "SELECT * FROM %s WHERE %s="+nombreDialogo.getText().toString();
        database.execSQL(String.format(query,
                DatosBD.TAB_PER,
                DatosBD.TAB_PER_NOM,
                DatosBD.TAB_PER_NOM));
        // Toast.makeText(getApplicationContext(),"HA ENTRADO",Toast.LENGTH_SHORT).show();

        database.close();
 */
        /*
         Intent i = null;
        i = new Intent(getApplicationContext(), AppActivity.class);
        startActivity(i);
        */
/*
     if(existe o no en la BD){
            TODA LA ESTRUCTURA DE ELSEIF YA HECHA

        }else{
            Mensaje de error diciendo que se registre primero
        }
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

        }
        */
    }


    private void limpiar() {
        campoNombre.setText("");
        campoPass.setText("");
    }


}



































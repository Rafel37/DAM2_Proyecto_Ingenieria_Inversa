package com.example.jose.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jose.login.basedatos.DatosBD;
import com.example.jose.login.dialogos.DialogoErrorPassRegistro;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ActivityRegistro extends AppCompatActivity {

    final static String TAG_PASS = "PASS";

    Button bOK, bCancel;
    EditText editNombre, editApellido, editEdad, editPass, editPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        instancias();
        acciones();
    }

    private void instancias() {
        bOK = findViewById(R.id.okDialogo);
        bCancel = findViewById(R.id.cancelDialogo);
        editNombre = findViewById(R.id.nombreDialogo);
        editApellido = findViewById(R.id.apellidoDialogo);
        editEdad = findViewById(R.id.edadDialogo);
        editPass = findViewById(R.id.editPass);
        editPass2 = findViewById(R.id.editPass2);
    }

    private void acciones() {
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editPass.getText().toString().equals(editPass2.getText().toString())){
                    insertarBD();
                }else{
                    Toast.makeText(getApplicationContext(),"La contraseña debe ser igual en los dos campos",Toast.LENGTH_SHORT).show();
                    DialogoErrorPassRegistro dDos = DialogoErrorPassRegistro.newInstance("Error");
                    dDos.show(getSupportFragmentManager(), TAG_PASS);
                }
            }
        });
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void insertarBD() {
        HashMap mapaDatos = new HashMap();
        mapaDatos.put(DatosBD.TAB_PER_NOM, editNombre.getText());
        mapaDatos.put(DatosBD.TAB_PER_APE, editApellido.getText());
        mapaDatos.put(DatosBD.TAB_PER_EDAD, editEdad.getText());
        mapaDatos.put(DatosBD.TAB_PER_PASS, editPass.getText());
        JSONObject jsonObject = new JSONObject(mapaDatos);

        String urlInsertar = "http://192.168.43.245/tfg/insertar_usuario.php";

        Volley.newRequestQueue(getApplicationContext()).add(
                new JsonObjectRequest(Request.Method.POST,
                        urlInsertar,
                        jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Log.v("volleytag", response.getString("mensaje"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Volley", "Error Volley: " + error.getMessage());
                            }
                        })
        );
        Toast.makeText(getApplicationContext(),"HA ENTRADO",Toast.LENGTH_SHORT).show();

    }


}

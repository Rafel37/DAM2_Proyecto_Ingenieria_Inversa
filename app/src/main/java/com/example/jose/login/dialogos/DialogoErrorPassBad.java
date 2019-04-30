package com.example.jose.login.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class DialogoErrorPassBad extends DialogFragment {

    String titulo;
    final static String TAG_ARG1 ="argumento1";
    public static DialogoErrorPassBad newInstance(String titulo){

        DialogoErrorPassBad dialogoConfirmacionDos = new DialogoErrorPassBad();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacionDos.setArguments(b);
        return dialogoConfirmacionDos;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage("Contraseña erronea");
        builder.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(this.getArguments()!= null)
        {
            Bundle bRecuperado = this.getArguments();
            titulo = bRecuperado.getString(TAG_ARG1);
        }
    }


}

package com.example.kristine.simon_kristine_ics115_oct5;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Kristine on 10/5/2017.
 */

public class CustomDialog extends DialogFragment {
    LayoutInflater inflater;
    View v;
    EditText etUsername, etPassword;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.login, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(v)
                .setPositiveButton("Login", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        etPassword = (EditText) v.findViewById(R.id.et_password);
                        etUsername = (EditText) v.findViewById(R.id.et_username);
                        String user = etUsername.getText().toString();
                        String password = etPassword.getText().toString();
                        String msg = "Username is " + user + " and Password is " + password;
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();

                    }
                });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });


        return builder.create();

    }
}

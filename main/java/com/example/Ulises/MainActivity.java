package com.example.Ulises;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import mx.edu.utng.sharedpreferences.R;

public class MainActivity extends AppCompatActivity {

    EditText campoUsuario;
    EditText campoPass;
    TextView txtUsuario;
    TextView txtPass;
    RadioButton rd1;
    RadioButton rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario=(EditText)findViewById(R.id.etUser);
        campoPass=(EditText)findViewById(R.id.etPass);
        txtUsuario=(TextView) findViewById(R.id.tvUser);
        txtPass=(TextView) findViewById(R.id.tvPass);
        rd1=(RadioButton)findViewById(R.id.rd1);
        rd2=(RadioButton)findViewById(R.id.rd2);
        cargarPreferencias();

    }

    private void cargarPreferencias() {
        SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user = preferences.getString("user", "No existe la información");
        String pass = preferences.getString("pass", "No existe la información");

        txtUsuario.setText(user);
        txtPass.setText(pass);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnGuardar:
                guardarPreferencias();
                break;
            case R.id.btnCargar:

                if (rd1.isChecked()==true) {
                    Intent intent=new Intent(this, PreferenciaAdmin.class);
                    startActivity(intent);
                } else{
                if (rd2.isChecked()==true) {
                    Intent intent=new Intent(this, ConsultarPreferencias.class);
                    startActivity(intent);
                }

                break;
        }}}


    private void guardarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario=campoUsuario.getText().toString();

        String pass=campoPass.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",usuario);
        editor.putString("pass",pass);

        txtUsuario.setText(usuario);
        txtPass.setText(pass);

        editor.commit();

    }
}

package com.example.pizzeria_juanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Usuario extends AppCompatActivity {
    public EditText usuario,pass,address,confpass;
    public Button registro;
    private SharedPreferences ajustes;
    public ImageButton atras3;
    String user,password,direccion;
    int valor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        usuario = (EditText) findViewById(R.id.txtNombre);
        pass = (EditText) findViewById(R.id.txtpass);
        address = (EditText) findViewById(R.id.txtAddess);
        confpass = (EditText) findViewById(R.id.txtConfirmarPass);
        registro = (Button) findViewById(R.id.btnRegistrarse);
        atras3 = (ImageButton) findViewById(R.id.btnatras3);
        ajustes = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        SharedPreferences.Editor editor = ajustes.edit();

        Bundle extras = getIntent().getExtras();
        valor = extras.getInt("Boton");

        if (valor == 1)
        {
            atras3.setVisibility(View.VISIBLE);
        }



        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.getText().toString().equals("")||pass.getText().toString().equals("")||address.getText().toString().equals("")||confpass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Rellene todos los campos...",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (pass.getText().toString().equals(confpass.getText().toString()))
                    {
                        //guardar los datos
                        user = usuario.getText().toString().trim();
                        password = pass.getText().toString().trim();
                        direccion = address.getText().toString().trim();
                        editor.putString("Usuario",user);
                        editor.putString("Contraseña",password);
                        editor.putString("Direccion",direccion);
                        editor.commit();

                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        atras3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }
}
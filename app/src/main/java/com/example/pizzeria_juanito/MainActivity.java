package com.example.pizzeria_juanito;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.AdvertiseData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button pedido,info,reg;
    private SharedPreferences ajustes2;
    String user2,pass2,address2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ajustes2 = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        user2 = ajustes2.getString("Usuario","");
        pass2 = ajustes2.getString("Contraseña","");
        address2 = ajustes2.getString("Direccion","");

        if (user2.length()>0 && pass2.length()>0 && address2.length()>0)
        {

        }
        else
        {
            Intent i = new Intent(getApplicationContext(),Usuario.class);
            startActivity(i);
            finish();
        }



        pedido = (Button) findViewById(R.id.btnpedido);
        info = (Button) findViewById(R.id.btnInformacion);
        reg = (Button) findViewById(R.id.btnRegistro);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity_Info.class);
                startActivity(i);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Usuario.class);
                i.putExtra("Boton",1);
                startActivity(i);
            }
        });


        pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity_RealizarPedido.class);
                startActivity(i);
            }
        });

    }
}
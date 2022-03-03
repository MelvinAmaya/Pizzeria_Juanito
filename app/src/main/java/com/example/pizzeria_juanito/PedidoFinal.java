package com.example.pizzeria_juanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PedidoFinal extends AppCompatActivity {
    private SharedPreferences ajustes3;
    String user3,pass3,address3;
    public TextView res;
    public ImageButton atras4;
    public Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_final);

        ajustes3 = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        user3 = ajustes3.getString("Usuario","");
        pass3 = ajustes3.getString("Contraseña","");
        address3 = ajustes3.getString("Direccion","");
        res = (TextView) findViewById(R.id.txtMensaje);
        atras4 = (ImageButton) findViewById(R.id.btnatras4);
        aceptar = (Button) findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        atras4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        String ingre = extras.getString("ingrediente");
        double total = extras.getDouble("Total");

        if (user3.length()>0 && pass3.length()>0 && address3.length()>0)
        {
            res.setText("Hola "+user3+", "+"Gracias por preferirnos, Tu pedido es el siguiente: \n"+ingre+"\n"+"Tu total es: "+total+"\n"+"Este Pedido se Enviara a: "+address3+"\n"+" Presione Aceptar para confirmar.");


        }
        else
        {
            Intent i = new Intent(getApplicationContext(),Usuario.class);
            startActivity(i);
            finish();
        }


    }
}
package com.example.pizzeria_juanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_RealizarPedido extends AppCompatActivity {
    public ImageButton pequenia,mediana,grande,familiar,atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_realizar_pedido);

        pequenia = (ImageButton) findViewById(R.id.btnpeque);
        mediana = (ImageButton) findViewById(R.id.btnmedia);
        grande = (ImageButton) findViewById(R.id.btngran);
        familiar = (ImageButton) findViewById(R.id.btnfami);
        atras = (ImageButton) findViewById(R.id.btnatras);

        pequenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Pequenia.class);
                i.putExtra("pizza","Pequeña");
                startActivity(i);
            }
        });

        grande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Pequenia.class);
                i.putExtra("pizza","Grande");
                startActivity(i);
            }
        });

        mediana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Pequenia.class);
                i.putExtra("pizza","Mediana");
                startActivity(i);
            }
        });

        familiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Pequenia.class);
                i.putExtra("pizza","Familiar");
                startActivity(i);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
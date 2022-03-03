package com.example.pizzeria_juanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pequenia extends AppCompatActivity {
    public ImageView pizza;
    public TextView txpizza;
    public Button enviar;
    public CheckBox n1,n2,n3,n4,n5,n6,n7,n8;
    String ingredientes;
    double precio;
    public ImageButton atras2;
    int contador =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pequenia);
        pizza = (ImageView) findViewById(R.id.imgPizza);
        txpizza = (TextView) findViewById(R.id.txtPizza);
        enviar = (Button) findViewById(R.id.btnEnviar);
        atras2 = (ImageButton) findViewById(R.id.btnatras2);

        n1 = (CheckBox) findViewById(R.id.chAceitunas);
        n2 = (CheckBox) findViewById(R.id.chCarne);
        n3 = (CheckBox) findViewById(R.id.chChampinion);
        n4 = (CheckBox) findViewById(R.id.chChorizo);
        n5 = (CheckBox) findViewById(R.id.chJamon);
        n6 = (CheckBox) findViewById(R.id.chPeperon);
        n7 = (CheckBox) findViewById(R.id.chPinia);
        n8 = (CheckBox) findViewById(R.id.chTocino);
        ingredientes="";

        Bundle extras = getIntent().getExtras();
        String pizzas = extras.getString("pizza");
        if(pizzas.equals("Pequeña"))
        {
            txpizza.setText("Pizza Pequeña");
            pizza.setImageResource(R.drawable.pequenia);
            precio =3;
            ingredientes = "Pizza Pequeña $3";
            ingredientes+="\n";
        }
        else if (pizzas.equals("Grande"))
        {
            txpizza.setText("Pizza Grande");
            pizza.setImageResource(R.drawable.grande);
            precio=7;
            ingredientes = "Pizza Grande $7";
            ingredientes+="\n";
        }
        else if (pizzas.equals("Mediana"))
        {
            txpizza.setText("Pizza Mediana");
            pizza.setImageResource(R.drawable.mediana);
            precio = 5;
            ingredientes = "Pizza Mediana $5";
            ingredientes+="\n";
        }
        else if (pizzas.equals("Familiar"))
        {
            txpizza.setText("Pizza Familiar");
            pizza.setImageResource(R.drawable.familiar);
            precio = 10;
            ingredientes = "Pizza Familiar $10";
            ingredientes+="\n";
        }

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n1.isChecked()==true)
                {
                    precio= precio+0.75;
                    ingredientes+=n1.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n2.isChecked()==true)
                {
                    precio= precio+1.50;
                    ingredientes+=n2.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n3.isChecked()==true)
                {
                    precio= precio+1;
                    ingredientes+=n3.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n4.isChecked()==true)
                {
                    precio= precio+1.75;
                    ingredientes+=n4.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n5.isChecked()==true)
                {
                    precio= precio+1;
                    ingredientes+=n5.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n6.isChecked()==true)
                {
                    precio= precio+1;
                    ingredientes+=n6.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n7.isChecked()==true)
                {
                    precio= precio+1.25;
                    ingredientes+=n7.getText().toString();
                    ingredientes+="\n";
                    contador++;
                }
                if (n8.isChecked()==true)
                {
                    precio= precio+1;
                    ingredientes+=n8.getText().toString();
                    contador++;
                }
               if (contador >0)
               {
                   Intent i = new Intent(getApplicationContext(),PedidoFinal.class);
                   i.putExtra("ingrediente",ingredientes);
                   i.putExtra("Total",precio);
                   startActivity(i);
                   finish();
               }
            }
        });

        atras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
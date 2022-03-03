package com.example.pizzeria_juanito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SlplashScreen extends AppCompatActivity {
    public ImageView logo;
    public TextView by,em;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slplash_screen);

        //AGREGAMOS ANIMACION
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        logo = (ImageView) findViewById(R.id.imglogo);
        by = (TextView) findViewById(R.id.txtby);
        em = (TextView) findViewById(R.id.txtempresa);

        by.setAnimation(animacion2);
        em.setAnimation(animacion2);
        logo.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),Usuario.class);
                i.putExtra("Boton",0);
                startActivity(i);
                finish();
            }
        },4000);

    }
}
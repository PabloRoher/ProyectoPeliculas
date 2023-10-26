package com.example.proyectopeliculas;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetallePeliculaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);



        String titulo = getIntent().getStringExtra("TITULO");
        String director = getIntent().getStringExtra("DIRECTOR");
        String portadaUrl = getIntent().getStringExtra("PORTADA");
        ArrayList actores = getIntent().getStringArrayListExtra("ACTORES");



        TextView tituloTextView = findViewById(R.id.tituloTextView);
        TextView directorTextView = findViewById(R.id.directorTextView);
        ImageView portadaImageView = findViewById(R.id.portadaImageView);
        TextView actoresTextView = findViewById(R.id.actoresTextView);
        TextView Actor1 = findViewById(R.id.actor1TextView);
        TextView Actor2 = findViewById(R.id.actor2TextView);
        TextView Actor3 = findViewById(R.id.actor3TextView);

        tituloTextView.setText(titulo);
        directorTextView.setText(director);
        actoresTextView.setText("Actores");
        Actor1.setText((CharSequence) actores.get(0));
        Actor2.setText((CharSequence) actores.get(1));
        Actor3.setText((CharSequence) actores.get(2));

        Glide.with(this)
                .load(portadaUrl)
                .into(portadaImageView);
    }
}

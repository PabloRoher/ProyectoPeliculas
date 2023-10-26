package com.example.proyectopeliculas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchMovies();

    }

    private void fetchMovies() {
        Request request = new Request.Builder()
                .url("https://uax.tionazo.com/pelis/peliculas.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (!response.isSuccessful()) {

                } else {
                    assert response.body() != null;
                    String jsonStr = response.body().string();
                    runOnUiThread(() -> {
                        Gson gson = new Gson();
                        PeliculasResponse responseObj = gson.fromJson(jsonStr, PeliculasResponse.class);
                        List<Pelicula> peliculas = responseObj.getPeliculas();
                        mostrarBotones(peliculas);
                    });
                }
            }
        });
    }
    private void mostrarBotones(List<Pelicula> peliculas) {
        LinearLayout layout = findViewById(R.id.linear_layout_peliculas);
        layout.removeAllViews();

        for (Pelicula pelicula : peliculas) {
            Button btn = new Button(this);
            btn.setText(pelicula.getTitulo());

            btn.setOnClickListener(v -> {

                Intent intent = new Intent(MainActivity.this, DetallePeliculaActivity.class);
                intent.putExtra("TITULO", pelicula.getTitulo());
                intent.putExtra("DIRECTOR", pelicula.getDirector());
                intent.putExtra("PORTADA", pelicula.getPortada());
                intent.putExtra("ACTORES", pelicula.getActores());

                startActivity(intent);
            });

            layout.addView(btn);
        }
    }

}
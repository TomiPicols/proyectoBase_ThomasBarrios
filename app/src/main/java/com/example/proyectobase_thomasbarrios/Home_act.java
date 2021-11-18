package com.example.proyectobase_thomasbarrios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in=new Insumos();
    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        videoview = findViewById(R.id.vw);
        String ruta = "android.resource://"+ getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(ruta); // Parseo la ruta
        videoview.setVideoURI(uri); // le paso la ruta a mi VideoView
        videoview.start(); // reproduce el video

        // Controles para el video
        MediaController media = new MediaController(this); // Controles para video
        videoview.setMediaController(media);


    }
    public void Clases(View view){
        Intent i = new Intent(getBaseContext(),Clases_act.class);
        startActivity(i);

    }
    public void Ins(View view){
        Intent i = new Intent(getBaseContext(),Insumos_act.class);
        startActivity(i);
    }



}
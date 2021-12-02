package com.example.barberlife;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Insumos;

public class activity_home extends AppCompatActivity {

    private Insumos in = new Insumos();
    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoview=findViewById(R.id.vw);

        //obtener la ruta

        String ruta = "android.resource://" + getPackageName()+ "/" + R.raw.video;
        Uri uri = Uri.parse(ruta); //?
        videoview.setVideoURI(uri);

        //controles para el video
        MediaController media = new MediaController(this);
        videoview.setMediaController(media);

        videoview.start();//reproduce el video

    }

    //tarea pesada o proceso largo
    public void Task(View view )
    {
        try{
            for(int i = 0; i <= 10; i++)
            {
                    Thread.sleep( 2200);
            }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
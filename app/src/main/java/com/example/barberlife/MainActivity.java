package com.example.barberlife;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador();
    private Insumos in = new Insumos();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btn);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui vamos aver nuestra tarea asincrona
                new Task().execute();

            }
        });

    }
    //tarea asincrona
    class Task extends AsyncTask<String, Void, String>
    {
        //definir la configuracion inicial de mi tarea asincrona
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        // va a procesar la tarea en un segundo plano o largo lapso de tiempo
        @Override
        protected String doInBackground(String... strings) {


            try {
                Thread.sleep(500);

            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        //Finaliza mi tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);

                String usuario = user.getText().toString().trim();
                String contrasena = pass.getText().toString().trim();

                String userObj = adm.getUser().trim();
                String userPass = adm.getUser().trim();

                switch(usuario)
                {
                    case "Edison":
                        if(usuario.equals(userObj) && contrasena.equals(userPass))
                        {
                            //inicio sesion
                            msj.setVisibility(View.VISIBLE);
                            Intent i = new Intent (getBaseContext(), activity_home.class); //GUARDA LOS VALORES
                            startActivity(i);
                        }
                        break;
                    case "":
                        if(usuario.equals("") && contrasena.equals(""))
                        {
                            msj.setVisibility(View.VISIBLE);
                            msj.setText("los campos estan vacios porfavor ingresar nuevamente");

                        }
                        break;
                    default:
                        if(!usuario.equals(userObj) && !contrasena.equals(userPass))
                        {
                            msj.setVisibility(View.VISIBLE);
                            msj.setText("los campos estan incorrectos ingrese nuevamente");


                        }
                        break;
                }
            }

        }


    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/edis0nbarber/"));
        startActivity(i);
    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/?lang=es"));
        startActivity(i);

    }

    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);

    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}
package com.example.proyectobase_thomasbarrios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

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
    private Button btn;
    private ProgressBar barra;
    private Administrador adm = new Administrador();
    private Insumos in = new Insumos(); // Instancia del objeto insumos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        msj = findViewById(R.id.msj);
        btn=findViewById(R.id.btnCalcular);
        msj.setVisibility(View.INVISIBLE);
        barra = findViewById(R.id.pb);
        barra.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Aqui vamos a correr nuestra Tarea Asincrona.
                new Task().execute();
            }
        });
    }


    class Task extends AsyncTask<String, Void, String> {

        // Va a procesar la tarea en segundo plano o el largo lapso de tiempo.
        @Override
        protected String doInBackground(String... strings) {
            try{
                for(int i=0;i<=10;i++){
                    Thread.sleep(500);
                }

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        // Definir la configuracion inicial de mi tarea asincrona.
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        // Finaliza mi tarea asincrona.
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim();
            String contraseña = pass.getText().toString().trim();


            String userObj = adm.getUser().trim();
            String userPass= adm.getPass().trim();

            switch (usuario)
            {
                case"Thomas":
                    if(usuario.equals(userObj)&& contraseña.equals(userPass))
                    {
                        // Inicio Sesion ...
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);

                        startActivity(i);
                        // Preparo los extras
                        Bundle bun =new Bundle();
                        bun.putStringArray("insumos",in.getInsumos()); // Preparo mi bundle.
                        i.putExtras(bun); // Envio el paquete a traves del intent.
                        startActivity(i);

                    }
                    break;
                case"":
                    if (usuario.equals("") && contraseña.equals(""))
                    {
                        // Campos Vacios ...
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Los campos estan vacios porfavor ingrese nuevamente.");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj)&& !contraseña.equals(userPass))
                    {
                        // Campos Incorrectos ...
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Los campos estan incorrectos ingrese nuevamente.");
                    }
                    break;
            }
        }
    }

    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); // Accion que abre un sitio web.
        i.setData(Uri.parse("https://www.facebook.com/")); // Le paso mi direccion.
        startActivity(i);
    }
    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }
    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }
    public void Info(View view){
        Intent i = new Intent(getBaseContext(), Info_act.class) ;
        startActivity(i);
    }
}



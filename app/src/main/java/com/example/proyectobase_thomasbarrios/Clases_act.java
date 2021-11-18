package com.example.proyectobase_thomasbarrios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobase_thomasbarrios.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {

    private EditText code, clas, intensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code= findViewById(R.id.code);
        clas=findViewById(R.id.clas);
        intensi=findViewById(R.id.intensi);
    }

    // Metodo para guardar clases ...
    public void guardarClases(View view){

        // Obtengo mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Le da permisos de sobreescritura.


        // Obtengo los campos que escribe el cliente ...
        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty()){
            // Guardo los datos ...
            ContentValues cont = new ContentValues(); // Me permite contener valores ...
            cont.put("codigo", codigo);
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.insert("clases", null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has guardado una clase.", Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(getBaseContext(),"Hay campos vacios ..", Toast.LENGTH_SHORT).show();
        }
    }

    // Metodo para mostrar clases ...
    public void mostrarClases(View view){

        // Obtengo mi database ...
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Le da permisos de sobreescritura.

        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){

            // Mostramos datos
            Cursor file = db.rawQuery("SELECT clase, intensidad FROM clases WHERE codigo="+codigo, null);

            if(file.moveToFirst()) // Verifica si la consulta tiene o no valores.
            {
                clas.setText(file.getString(0)); // Muestra por posicion
                intensi.setText(file.getString(1));

            }else
            {
                Toast.makeText(getBaseContext(),"No hay clase asociada", Toast.LENGTH_SHORT).show();
            }


        }else
        {
            Toast.makeText(getBaseContext(), "El codigo viene vacio", Toast.LENGTH_SHORT).show();
        }

    }

    // Metodo para eliminar clases ...
    public void eliminarClases(View view){
        // Obtengo mi database ...

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Le da permisos de sobreescritura.

        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){

            // Eliminamos ...
            db.delete("clases", "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has eliminado una clase: "+codigo, Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(getBaseContext(),"El codigo no debe venir vacio", Toast.LENGTH_LONG).show();
        }

    }

    // Metodo para actualizar clases ...
    public void actualizarClases(View view){
        // Obtengo mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "biofit", null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // Le da permisos de sobreescritura.


        // Obtengo los campos que escribe el cliente ...
        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty()){
            // Actualizamos
            ContentValues cont = new ContentValues();
            cont.put("clase",clase);
            cont.put("intensidad",intensidad);

            db.update("clases", cont, "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has actualizado una clase", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(),"Los campos no deben venir vacios", Toast.LENGTH_SHORT).show();
        }

    }

    // Metodo para limpiar los campos ...
    public void Clean(){

        code.setText("");
        clas.setText("");
        intensi.setText("");
    }
}
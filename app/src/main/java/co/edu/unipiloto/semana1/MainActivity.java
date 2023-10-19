package co.edu.unipiloto.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import co.edu.unipiloto.semana1.DB.DBconexion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBconexion dbHelper = new DBconexion(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if(db != null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(MainActivity.this,CrearCuenta.class);
                startActivity(intent);

            }
        });
    }
}
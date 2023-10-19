package co.edu.unipiloto.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unipiloto.semana1.DB.DBmanager;
import kotlin.jvm.internal.PropertyReference0Impl;

public class CrearCuenta extends AppCompatActivity {

    EditText etNombre, etApellido, etCedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        etNombre = findViewById(R.id.etNombres);
        etApellido = findViewById(R.id.etApellidos);
        etCedula = findViewById(R.id.etCedula);

        Button btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBmanager dbManager = new DBmanager(CrearCuenta.this);
                long id = dbManager.insertarUsuario(etNombre.getText().toString(),etApellido.getText().toString(),etCedula.getText().toString());

                if(id > 0){
                    Toast.makeText(CrearCuenta.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(CrearCuenta.this,"ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void limpiar(){
        etNombre.setText("");
        etApellido.setText("");
        etCedula.setText("");
    }
}
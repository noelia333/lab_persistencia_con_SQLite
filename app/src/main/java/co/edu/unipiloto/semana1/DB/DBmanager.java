package co.edu.unipiloto.semana1.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBmanager extends DBconexion {

    Context context;


    public DBmanager(Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String nombre, String apellido, String cedula){

        long id = 0;

        try{
            DBconexion conexion = new DBconexion(context);
            SQLiteDatabase db = conexion.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre_usuario", nombre);
            values.put("apellido_usuario", apellido);
            values.put("cedula_usuario", cedula);


            id = db.insert(TABLA_USUARIOS,null,values);
        }catch(Exception ex){
            ex.toString();
        }

        return id;



    }
}

package co.edu.unipiloto.semana1.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBconexion extends SQLiteOpenHelper {

    private static final String DB_NAME = "roguDB.db";
    private static final int DB_VERSION = 3;

    public static final String TABLA_USUARIOS = "usuarios";

    public DBconexion(Context context) {
        //name es el nombre de la BD
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLA_USUARIOS + "(" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_usuario TEXT NOT NULL," +
                "apellido_usuario TEXT NOT NULL," +
                "cedula_usuario TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLA_USUARIOS);
        onCreate(db);
    }
}

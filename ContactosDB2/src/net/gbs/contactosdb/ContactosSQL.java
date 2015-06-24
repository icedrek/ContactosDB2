package net.gbs.contactosdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactosSQL extends SQLiteOpenHelper {
	//Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE Contactos (nombre TEXT, email TEXT, telefono INTEGER)";
 
    public ContactosSQL(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }
 
/*
 * NOTA: En este caso solo eliminamos la tabla anterior y creamos una nueva
 *       que estará vacía y tendrá el nuevo formato.
 */    
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {      
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Contactos");
 
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }

}

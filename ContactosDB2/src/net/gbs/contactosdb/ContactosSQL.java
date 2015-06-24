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
        //Se ejecuta la sentencia SQL de creaci�n de la tabla
        db.execSQL(sqlCreate);
    }
 
/*
 * NOTA: En este caso solo eliminamos la tabla anterior y creamos una nueva
 *       que estar� vac�a y tendr� el nuevo formato.
 */    
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {      
        //Se elimina la versi�n anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Contactos");
 
        //Se crea la nueva versi�n de la tabla
        db.execSQL(sqlCreate);
    }

}

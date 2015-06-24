package net.gbs.contactosdb;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class ContactosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactos);
		
		TextView lstContactos = (TextView)findViewById(R.id.LstContactos);
		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
        ContactosSQL contacdbh =
            new ContactosSQL(this, "DBContactos", null, 1);
 
        SQLiteDatabase db = contacdbh.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM Contactos", null);

		//Nos aseguramos de que existe al menos un registro
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya más registros
		     do {
		          String nombre= c.getString(0);
		          String email = c.getString(1);
		          String telefono = c.getString(2);
		          
		          lstContactos.append(nombre+ ";" + email+";"+telefono+"\n");
		          
		     } while(c.moveToNext());
		}		
		c.close();
		db.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contactos, menu);
		return true;
	}
}

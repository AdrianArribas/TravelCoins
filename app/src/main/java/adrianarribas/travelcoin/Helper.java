package adrianarribas.travelcoin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shish on 17/10/2017.
 */

public class Helper extends SQLiteOpenHelper {
    public Helper(Context ctx, String nombre){
        super(ctx,nombre,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String creaTablaSql="create table gastos (";
        creaTablaSql+="_id integer primary key autoincrement,";
        creaTablaSql+="fecha text,";
        creaTablaSql+="compra text,";
        creaTablaSql+="fotourl text,";
        creaTablaSql+="extraString text,";
        creaTablaSql+="precioyen double,";
        creaTablaSql+="precioeuro double,";
        creaTablaSql+="lat double,";
        creaTablaSql+="lng double,";
        creaTablaSql+="extradouble double)";

        db.execSQL(creaTablaSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

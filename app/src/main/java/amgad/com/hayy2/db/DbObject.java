package amgad.com.hayy2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import amgad.com.hayy2.db.DbAssetHelper;

/**
 * Created by Amgad on 21-Nov-16.
 */

// to handle an object of the database.
public class DbObject {

    private static DbAssetHelper dbHelper;
    private SQLiteDatabase db;

    public DbObject(Context context) {
        dbHelper = new DbAssetHelper(context);
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }

    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }
}

    
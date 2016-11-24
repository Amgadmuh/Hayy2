package amgad.com.hayy2.db;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Amgad on 08-Nov-16.
 */

//to handle an already-eisting self-containted db in the app's assets
public class DbAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAMES = "places";
    private static final int DATABASE_VERSION = 5;

    public DbAssetHelper(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
    }

}

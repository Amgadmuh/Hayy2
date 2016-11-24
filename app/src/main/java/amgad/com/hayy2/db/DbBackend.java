package amgad.com.hayy2.db;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by Amgad on 21-Nov-16.
 */

//handles database operations  (queries)
public class DbBackend extends DbObject {


    public DbBackend(Context context) {
        super(context);
    }

    //to get all types + names for the auto-complete list
    public String[] placesNames(){
        String query = "Select type, name from places";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> allNames = new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                String type = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                allNames.add(type + " " + name);
            }while(cursor.moveToNext());
        }
        cursor.close();
        String[] pName = new String[allNames.size()];
        pName = allNames.toArray(pName);
        return pName;
    }


    //to get the Info of the place tabbed in the main list using the place _id in db
    public PlaceObject getPlaceINFOById(int placeId){

        PlaceObject placeObject = null;
        String query = "select * from places where _id = " + placeId;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String type = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String commissionedBy= cursor.getString(cursor.getColumnIndexOrThrow("commissioned_by"));
                String description= cursor.getString(cursor.getColumnIndexOrThrow("description"));
                String dateHijriFrom = cursor.getString(cursor.getColumnIndexOrThrow("date_hijri_from"));
                String dateHijriTo = cursor.getString(cursor.getColumnIndexOrThrow("date_hijri_to"));
                String dateGregorianFrom = cursor.getString(cursor.getColumnIndexOrThrow("date_gregorian_from"));
                String dateGregorianTo = cursor.getString(cursor.getColumnIndexOrThrow("date_gregorian_to"));
                String imageName = cursor.getString(cursor.getColumnIndexOrThrow("images"));
                String latitude = cursor.getString(cursor.getColumnIndexOrThrow("latitude"));
                String longitude = cursor.getString(cursor.getColumnIndexOrThrow("longitude"));
                placeObject = new PlaceObject(type, name, description,commissionedBy,dateHijriFrom,
                        dateHijriTo,dateGregorianFrom,dateGregorianTo, imageName, latitude, longitude);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return placeObject;
    }

    //to get place ID when I only have the type+name
    public int getPlace_ID_ByTypeAndName(String typePLUSname){
        int id = 0;
        //query to match both type and name with both columns together
        String query = "SELECT _id  FROM places WHERE type || ' ' || name  LIKE \"" +typePLUSname +"\"";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
            }while(cursor.moveToNext());
        }
        cursor.close();
        // to decrease one from the ID returned as the array index starts with zero unlike db which
        // starts with 1
        id = id-1;
        return id;
    }

}

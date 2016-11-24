package amgad.com.hayy2;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;

import amgad.com.hayy2.db.DbBackend;
import amgad.com.hayy2.db.PlaceObject;

public class PlaceInfoActivity extends AppCompatActivity implements OnMapReadyCallback{

    //private TextView name;
    // latitude = "30.042702";
    // longitude= "31.257762";
    String latitude = "0";
    String longitude= "0";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_details);


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int placeId = bundle.getInt("_id");
        int id = placeId + 1;

        TextView description = (TextView)findViewById(R.id.description);
        TextView commissioned_by = (TextView)findViewById(R.id.commissioned_by);
        TextView date_hijri_from = (TextView)findViewById(R.id.date_hijri_from);
        TextView date_hijri_to = (TextView)findViewById(R.id.date_hijri_to);
        TextView date_gregorian_from = (TextView)findViewById(R.id.date_gregorian_from);
        TextView date_gregorian_to = (TextView)findViewById(R.id.date_gregorian_to);
        ImageView image = (ImageView)findViewById(R.id.image);
       // name = (TextView)findViewById(R.id.name);

        DbBackend dbBackend = new DbBackend(PlaceInfoActivity.this);
        PlaceObject clickedPlaceTypeAndName = dbBackend.getPlaceINFOById(id);

        String imageName ="";
        imageName = clickedPlaceTypeAndName.getImageName();
        try {
            // get input stream
            InputStream ims = getAssets().open("placesCovers/"+ imageName);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            image.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }

        /** to test if any of the fields are NULL in the database, until we complete the db**/

        name = clickedPlaceTypeAndName.getName();
        if(clickedPlaceTypeAndName.getDescription() == null){
            description.setText(" قريباً... ");
        }else{
            description.setText(clickedPlaceTypeAndName.getDescription());
        }
        if(clickedPlaceTypeAndName.getCommissionedBy() == null){
            commissioned_by.setText(" قريباً... ");
        }else{
            commissioned_by.setText(clickedPlaceTypeAndName.getCommissionedBy());
        }
        if(clickedPlaceTypeAndName.getDateHijriFrom() == null){
            date_hijri_from.setText(" غير معلوم ");
        }else{
            date_hijri_from.setText(clickedPlaceTypeAndName.getDateHijriFrom());
        }
        if(clickedPlaceTypeAndName.getDateHijriTo() == null){
            date_hijri_to.setText(" غير معلوم ");
        }else{
            date_hijri_to.setText(clickedPlaceTypeAndName.getDateHijriTo());
        }
        if(clickedPlaceTypeAndName.getDateGregorianFrom() == null){
            date_gregorian_from.setText(" غير معلوم ");
        }else{
            date_gregorian_from.setText(clickedPlaceTypeAndName.getDateGregorianFrom());
        }
        if(clickedPlaceTypeAndName.getDateGregorianTo() == null){
            date_gregorian_to.setText(" غير معلوم ");
        }else{
            date_gregorian_to.setText(clickedPlaceTypeAndName.getDateGregorianTo());
        }
        if(clickedPlaceTypeAndName.getLatitude() == null){
            latitude = "0";
        }else{
            latitude = clickedPlaceTypeAndName.getLatitude();
        }
        if(clickedPlaceTypeAndName.getLongitude() == null){
            longitude = "0";
        }else{
            longitude = clickedPlaceTypeAndName.getLongitude();
        }

        // to set title to the name of the place
        getSupportActionBar().setTitle(clickedPlaceTypeAndName.getType() + " " + clickedPlaceTypeAndName.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude))).title(name));
        map.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude)) , 14.0f) );

    }
}

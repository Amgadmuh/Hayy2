package amgad.com.hayy2;

import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static amgad.com.hayy2.R.id.map;

/**
 * Created by Amgad on 23-Nov-16.
 */


// todo: I've implemented all methods needed for future work
    // will just comment them till needed instead of having to look around again.
    // for reference:
    //https://code.tutsplus.com/tutorials/getting-started-with-google-maps-for-android-basics--cms-24635
public class MapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener,
        com.google.android.gms.maps.GoogleMap.OnMapLongClickListener,
        com.google.android.gms.maps.GoogleMap.OnMapClickListener,
        com.google.android.gms.maps.GoogleMap.OnMarkerClickListener {

    /** for using user's location**/
    private GoogleApiClient mGoogleApiClient;
    //private Location mCurrentLocation;


    /**for switching between different map types**/
    private final int[] MAP_TYPES = { com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE,
            com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL,
            com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID,
            com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN,
            com.google.android.gms.maps.GoogleMap.MAP_TYPE_NONE };
    private int curMapTypeIndex = 0;



















    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    public void onMapReady(com.google.android.gms.maps.GoogleMap map, String latitude, String longitude) {
        map.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude))).title("Marker"));

    }
}

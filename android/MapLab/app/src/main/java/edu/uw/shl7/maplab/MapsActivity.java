package edu.uw.shl7.maplab;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        LatLng fountain = new LatLng(47.6538000,-122.3078000);
        mMap.addMarker(new MarkerOptions()
                .position(fountain)
                .title("Drumheller Fountain and Ducks")
                // .icon(getMarkerIcon("#b7a57a")) // gold
                .icon(getMarkerIcon("#4b2e83")) // purple
                .snippet("Ducks live here")
        );
        LatLng[] wShape = {
            new LatLng(47.653916, -122.308152),
            new LatLng(47.653567, -122.307808),
            new LatLng(47.653917, -122.307885),
            new LatLng(47.653644, -122.307534),
            new LatLng(47.654020, -122.307620)
        };

//        for (int i=0; i < wShape.length - 1; i++) {
//            mMap.addPolyline(new PolylineOptions()
//                    .add(wShape[i], wShape[i+1])
//                    .width(25)
//                    .color(Color.rgb(51, 0, 111))
//                    .geodesic(false));
//        }

        PolylineOptions line = new PolylineOptions()
                .add(wShape[0])
                .add(wShape[1])
                .add(wShape[2])
                .add(wShape[3])
                .add(wShape[4])
                .width(25)
                //.color(Color.rgb(51, 0, 111)); // purple
                .color(Color.rgb(232, 211, 162)); // gold
        mMap.addPolyline(line);
    }

    // from http://stackoverflow.com/questions/19076124/android-map-marker-color
    // by S.Thiongane
    public BitmapDescriptor getMarkerIcon(String color) {
        float[] hsv = new float[3];
        Color.colorToHSV(Color.parseColor(color), hsv);
        return BitmapDescriptorFactory.defaultMarker(hsv[0]);
    }
}

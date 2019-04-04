package com.example.justmaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.BitSet;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String[] INITIAL_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS
    };
    private static final String[] CAMERA_PERMS={
            Manifest.permission.CAMERA
    };
    private static final String[] CONTACTS_PERMS={
            Manifest.permission.READ_CONTACTS
    };
    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    private static final int REQUEST_FINE_LOCATION = 0;
    private GoogleMap mMap;

    Marker marker,marker1;
    private String locality;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        loadPermissions(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_FINE_LOCATION);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void loadPermissions(String accessFineLocation, int requestFineLocation) {
    }


    private void setUpMap() {
    }

    public void onsearch(View view)
{
    EditText location_tf = (EditText)findViewById(R.id.TFadress);
    String location = location_tf.getText().toString();
    List<Address> addressList = null;

    if(marker1 != null){
        marker1.remove();
    }
    if(location.length() == 0){
        Toast.makeText(MapsActivity.this,"Please enter a location",Toast.LENGTH_SHORT).show();
    }

    else if (location != null || !location.equals(" "))
    {
        Geocoder  geocoder = new Geocoder(this);
        try {
            addressList = geocoder.getFromLocationName(location , 1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Address address = addressList.get(0);
        locality = address.getLocality();
        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
        marker1 = mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

    }

}


public void onZoom(View view)
{
    if(view.getId() == R.id.Bzoomin)
    {
       mMap.animateCamera(CameraUpdateFactory.zoomIn());
    }
    if(view.getId() == R.id.Bzoomout)
    {
       mMap.animateCamera(CameraUpdateFactory.zoomOut());
    }

}


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        // Add a marker in Sydney and move the camera
        LatLng JUST = new LatLng(23.233681, 89.125321);
        mMap.addMarker(new MarkerOptions().position(JUST).title("Marker in JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST, 10F));
        mMap.setMyLocationEnabled(true);

        LatLng JUST1 = new LatLng(23.234229, 89.126094);
        mMap.addMarker(new MarkerOptions().position(JUST1).title("Bangabandhu Academic Building, JUST").snippet("Departments"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST1, 10F));

        LatLng JUST2 = new LatLng(23.233791, 89.123691);
        mMap.addMarker(new MarkerOptions().position(JUST2).title("Central Mosque, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST2, 10F));

        LatLng JUST3 = new LatLng(23.232647, 89.124131);
        mMap.addMarker(new MarkerOptions().position(JUST3).title("University Garage, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST3, 10F));

        LatLng JUST4 = new LatLng(23.234407, 89.122881);
        mMap.addMarker(new MarkerOptions().position(JUST4).title("Shahid Mashiur Rahman Hall, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST4, 10F));

        LatLng JUST5 = new LatLng(23.233234, 89.123568);
        mMap.addMarker(new MarkerOptions().position(JUST5).title("Sheikh Hasina Hall, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST5, 10F));

        LatLng JUST6 = new LatLng(23.232271, 89.126199);
        mMap.addMarker(new MarkerOptions().position(JUST6).title("Teacher/Officer Dormitory, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST6, 10F));

        LatLng JUST7 = new LatLng(23.232267, 89.126666);
        mMap.addMarker(new MarkerOptions().position(JUST7).title("Kapotakkho Tower, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST7, 10F));

        LatLng JUST8 = new LatLng(23.232578, 89.127526);
        mMap.addMarker(new MarkerOptions().position(JUST8).title("Vice Chancelor's Banglow, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST8, 10F));

        LatLng JUST9 = new LatLng(23.233622, 89.127499);
        mMap.addMarker(new MarkerOptions().position(JUST9).title("Pond of Fisheries Department, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST9, 10F));

        LatLng JUST10 = new LatLng(23.233978, 89.126782);
        mMap.addMarker(new MarkerOptions().position(JUST10).title("IPE Resarch Laboratory, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST10, 10F));

        LatLng JUST11 = new LatLng(23.232557, 89.124284);
        mMap.addMarker(new MarkerOptions().position(JUST11).title("Medical Center, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST11, 10F));

        LatLng JUST12 = new LatLng(23.232792, 89.125233);
        mMap.addMarker(new MarkerOptions().position(JUST12).title("Administrative Building, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST12, 10F));

        LatLng JUST13 = new LatLng(23.233068, 89.125504);
        mMap.addMarker(new MarkerOptions().position(JUST13).title("Central Library, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST13, 10F));

        LatLng JUST14 = new LatLng(23.233672, 89.125873);
        mMap.addMarker(new MarkerOptions().position(JUST14).title("Basketball Court, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST14, 10F));

        LatLng JUST15 = new LatLng(23.233026, 89.125207);
        mMap.addMarker(new MarkerOptions().position(JUST15).title("Agrani Bank Ltd. JUST Branch"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST15, 10F));

        LatLng JUST16 = new LatLng(23.233191, 89.124763);
        mMap.addMarker(new MarkerOptions().position(JUST16).title("Adommo Ekattor, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST16, 10F));

        LatLng JUST17 = new LatLng(23.234601, 89.124757);
        mMap.addMarker(new MarkerOptions().position(JUST17).title("Shaheed Minar, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST17, 10F));

        LatLng JUST18 = new LatLng(23.234597, 89.124144);
        mMap.addMarker(new MarkerOptions().position(JUST18).title("Cafeteria, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST18, 10F));

        LatLng JUST19 = new LatLng(23.234369, 89.125245);
        mMap.addMarker(new MarkerOptions().position(JUST19).title("Gymnasium, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST19, 10F));

        LatLng JUST20 = new LatLng(23.233482, 89.123855);
        mMap.addMarker(new MarkerOptions().position(JUST20).title("Research Pond, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST20, 10F));

        LatLng JUST21 = new LatLng(23.234005, 89.124833);
        mMap.addMarker(new MarkerOptions().position(JUST21).title("Central Playground, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST21, 10F));

        LatLng JUST22 = new LatLng(23.234717, 89.124496);
        mMap.addMarker(new MarkerOptions().position(JUST22).title("Main Gate, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST22, 10F));

        LatLng JUST23 = new LatLng(23.234616, 89.123695);
        mMap.addMarker(new MarkerOptions().position(JUST23).title("TSC, JUST"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JUST23, 10F));



        /*MarkerOptions options1 = new MarkerOptions()
                .title(locality)
                .position(new LatLng(23.234229, 89.126094))
                .snippet("Departments");

        mMap.addMarker(new MarkerOptions().position(JUST).title("Bangabandhu Academic Building, JUST "));

        marker = mMap.addMarker(options1);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Change the map type based on the user's selection.
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

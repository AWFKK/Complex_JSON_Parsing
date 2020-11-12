package com.example.complex_json_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Map_Activity extends AppCompatActivity implements OnMapReadyCallback {


    //ArrayList<DataClass> LatLong_List = new ArrayList<>();
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_);



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(Map_Activity.this);




 /*       for(int i = 0 ; i < LatLong_List.size() ; i++) {

            createMarker(LatLong_List.get(i).getLatitude(), markersArray.get(i).getLongitude(), markersArray.get(i).getTitle(), markersArray.get(i).getSnippet(), markersArray.get(i).getIconResID());
        }*/

    }

    @Override
    public void onMapReady(GoogleMap googleMap ) {
        LatLng Karachi = new LatLng(24.8746,67.0398);
        googleMap.addMarker(new MarkerOptions()
            .title("Mazar E Quaid")
                .position(Karachi)
        );
    }

    protected Marker createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {

        return googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title)
                .snippet(snippet)
                .icon(BitmapDescriptorFactory.fromResource(iconResID)));
    }
}
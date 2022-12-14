package com.example.park_in;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.park_in.databinding.ActivityMapsBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    boolean isPermissionGranted;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        checkPermission();
    }

    private void checkPermission() {
        Dexter.withContext(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                isPermissionGranted = true;
                Toast.makeText(MapsActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), "");
                intent.setData(uri);
                startActivity(intent);

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
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

        LatLng latLng = new LatLng(23.78030, 90.40737);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("BRACU UB2 Parking");
        markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions.position(latLng);
        mMap.addMarker(markerOptions);

        LatLng latLng1 = new LatLng(23.780958345894067, 90.40564503753794);
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.title("LCM Garage");
        markerOptions1.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions1.position(latLng1);
        mMap.addMarker(markerOptions1);

        LatLng latLng2 = new LatLng(23.7803337048678, 90.40553658767722);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.title("Nabab Voj Parking Spot");
        markerOptions2.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions2.position(latLng2);
        mMap.addMarker(markerOptions2);

        LatLng latLng3 = new LatLng(23.780047653302663, 90.4066976391271);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.title("Community Center Parking");
        markerOptions3.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions3.position(latLng3);
        mMap.addMarker(markerOptions3);

        LatLng latLng5 = new LatLng(23.78039208266093, 90.40600866354146);
        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.title("TT Tower Garage 1");
        markerOptions5.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions5.position(latLng5);
        mMap.addMarker(markerOptions5);

        LatLng latLng6 = new LatLng(23.781051749901774, 90.40695281526992);
        MarkerOptions markerOptions6 = new MarkerOptions();
        markerOptions6.title("Priva Garage");
        markerOptions6.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions6.position(latLng6);
        mMap.addMarker(markerOptions6);

        LatLng latLng7 = new LatLng(23.779755763301768, 90.40745040874845);
        MarkerOptions markerOptions7 = new MarkerOptions();
        markerOptions7.title("AB Road Parking Spot");
        markerOptions7.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions7.position(latLng7);
        mMap.addMarker(markerOptions7);

        LatLng latLng9 = new LatLng(23.780000950946548, 90.40640418656285);
        MarkerOptions markerOptions9 = new MarkerOptions();
        markerOptions9.title("Homeo Hall Parking");
        markerOptions9.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions9.position(latLng9);
        mMap.addMarker(markerOptions9);

        LatLng latLng10 = new LatLng(23.78040959599376, 90.40834352524834);
        MarkerOptions markerOptions10 = new MarkerOptions();
        markerOptions10.title("BIAO Parking");
        markerOptions10.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions10.position(latLng10);
        mMap.addMarker(markerOptions10);

        LatLng latLng11 = new LatLng(23.78098753465368, 90.40842645749477);
        MarkerOptions markerOptions11 = new MarkerOptions();
        markerOptions11.title("Autobi Garage");
        markerOptions11.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions11.position(latLng11);
        mMap.addMarker(markerOptions11);


        LatLng latLng14 = new LatLng(23.780091672560577, 90.4084060427114);
        MarkerOptions markerOptions14 = new MarkerOptions();
        markerOptions14.title("Water Tank Parking");
        markerOptions14.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions14.position(latLng14);
        mMap.addMarker(markerOptions14);

        LatLng latLng15 = new LatLng(23.78106855550024, 90.40893175565839);
        MarkerOptions markerOptions15 = new MarkerOptions();
        markerOptions15.title("Abascus Garage");
        markerOptions15.icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_garage_24));
        markerOptions15.position(latLng15);
        mMap.addMarker(markerOptions15); //markers


        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        setMapStyle();

    }

    private void setMapStyle() {
        boolean result = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this,R.raw.map_style));
        if(!result){
            Log.e("Map","Error set map style");
        }
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context,vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
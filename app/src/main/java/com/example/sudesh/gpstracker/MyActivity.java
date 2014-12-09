package com.example.sudesh.gpstracker;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class MyActivity extends Activity {
    Button gpsButton;

    // GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //}

        // public void showLocation(View view) {
        // gps = new GPSTracker();
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener ll = new GPSTracker();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
        // }
    }

    private class GPSTracker implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
                Log.d("LOCATION CHANGED", location.getLatitude() + "");
                Log.d("LOCATION CHANGED", location.getLongitude() + "");
                // makeText(this, "eee", LENGTH_SHORT).show();
                Toast.makeText(MyActivity.this,
                        location.getLatitude() + "" + location.getLongitude(),
                        LENGTH_LONG).show();
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}

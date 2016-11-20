package com.rz.locationfused;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;


public class ActSplash extends AppCompatActivity {
    private Context context;
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;

    private String TAG = this.getClass().getSimpleName();
    private FusedLocation fusedLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);

        context = this;

        latituteField = (TextView) findViewById(R.id.TextView02);
        longitudeField = (TextView) findViewById(R.id.TextView04);
        /*ServiceFused.activity = this;
        ServiceFused.context = this;
        startService(new Intent(this, ServiceFused.class));*/

        /*FusedLocation fusedLocation = new FusedLocation(context, new FusedLocation.Callback() {
            public void onLocationResult(Location location) {
                //Do as you wish with location here
                Toast.makeText(context,
                        "Latitude " + location.getLatitude() + " Longitude: " + location.getLongitude(),
                        Toast.LENGTH_LONG).show();
            }
        });*/
        fusedLocation = new FusedLocation(context, new FusedLocation.Callback() {
            @Override
            public void onLocationResult(Location location) {
                //Do as you wish with location here
                Toast.makeText(context, "Latitude " + location.getLatitude() + " Longitude: " + location.getLongitude(), Toast.LENGTH_LONG).show();
                //stopLocationUpdates();
                //fusedLocation.stopLocationUpdates();
            }
        });
        if (!fusedLocation.isGPSEnabled()) {
            fusedLocation.showSettingsAlert();
        } else {
            //use fusedLocation API calls here
        }
        //Sample GPS readings 3 times and choose the best based on accuracy
        fusedLocation.getCurrentLocation(3);
        //Accept the lastKnownLocation if it was sampled within the last 60 seconds and is within 50m of accuracy, otherwise, sample it and return the most recent sample
        //fusedLocation.getLastKnownLocation(60000, 50);
    }

    /*FusedLocation fusedLocation = new FusedLocation(context, new FusedLocation.Callback() {
        @Override
        public void onLocationResult(Location location) {
            //Do as you wish with location here
            Toast.makeText(context, "Latitude " + location.getLatitude() + " Longitude: " + location.getLongitude(), Toast.LENGTH_LONG).show();
        }
    });*/

    @Override
    protected void onPause() {
        //fusedLocation.stopLocationUpdates();
        super.onPause();
        //fusedLocation.stopLocationUpdates();
    }
}
/*
http://stackoverflow.com/questions/21022297/fused-location-provider-doesnt-seem-to-use-gps-receiver

*/
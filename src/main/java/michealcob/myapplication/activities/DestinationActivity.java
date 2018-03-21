package michealcob.myapplication.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import michealcob.myapplication.R;
import michealcob.myapplication.model.Localarm;

public class DestinationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int PLACE_PICKER_REQUEST = 1;
    String stringLngLat;

    public String destLng;
    public String destLat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        final String taskTtitle = getIntent().getStringExtra("title");
        final String taskMyLocationLng = getIntent().getStringExtra("present_lng");
        final String taskMyLocationLat = getIntent().getStringExtra("present_lat");


        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

        FloatingActionButton fab = findViewById(R.id.next_summary);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DestinationActivity.this, SummaryActivity.class);
                intent.putExtra("title", taskTtitle);
                /*intent.putExtra("mylocationlat", taskMyLocationLat);
                intent.putExtra("mylocationlng", taskMyLocationLng);*/
                intent.putExtra("mydestinationlat", destLat);
                intent.putExtra("mydestinationlng", destLng);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                LatLng latLng = place.getLatLng();
                double mlat = latLng.latitude;
                destLat = String.valueOf(mlat);
                double mlng = latLng.longitude;
                destLng = String.valueOf(mlng);

                Toast.makeText(this, "Longitude is " + destLng +"\n" + "Latitude is "
                        + destLat, Toast.LENGTH_SHORT).show();
                stringLngLat = latLng.toString();
                String toastMsg = String.format("Place: %s", place.getName());
                String toastMsg1 = String.format("Place: %s", latLng + "");
                Toast.makeText(this, toastMsg + toastMsg1, Toast.LENGTH_LONG).show();
            }
        }
    }
}

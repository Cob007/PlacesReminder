package michealcob.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import michealcob.myapplication.R;
import michealcob.myapplication.adapter.DatabaseHandler;
import michealcob.myapplication.model.Localarm;

public class SummaryActivity extends AppCompatActivity {

    TextView mTitle, mLocation, mDestination;
    String Title, myLat, myLng, destLat, destLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Title = getIntent().getStringExtra("title");
        Log.v("Title: ", Title);
        mTitle = findViewById(R.id.s_title);
        mTitle.setText(Title);

        /*myLat = getIntent().getStringExtra("mylocationlat");
        myLng = getIntent().getStringExtra("mylocationlng");
        mLocation = findViewById(R.id.s_my_location);
        String mlocation = "( "+ myLat + ", " + myLng +" )";*/

       // mLocation.setText(mlocation);

        destLat = getIntent().getStringExtra("mydestinationlat");
        destLng = getIntent().getStringExtra("mydestinationlng");
        mDestination = findViewById(R.id.s_my_destination);
        String mdestination = "( "+ destLat + ", " + destLng +" )";
        mDestination.setText(mdestination);

        TextView setTask = findViewById(R.id.set_task);
        setTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.addTask(new Localarm(Title,destLat,destLng));
                startActivity(new Intent(SummaryActivity.this, HomeActivity.class));
            }
        });

    }

}

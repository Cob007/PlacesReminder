package michealcob.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import michealcob.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SHOW_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Context context = SplashActivity.this;
                Intent i = new Intent(context, HomeActivity.class);
                startActivity(i);

                finish();
            }
        }, SHOW_TIME);
    }

}

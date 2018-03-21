package michealcob.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import michealcob.myapplication.R;
import michealcob.myapplication.model.Localarm;

public class TitleActivity extends AppCompatActivity {

    EditText title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        final EditText title = findViewById(R.id.et_title);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here we check maybe the item is set and transit
                String sTitle = title.getText().toString();
                if (TextUtils.isEmpty(sTitle)){
                    title.setError("please enter field");
                    title.requestFocus();
                    return;
                }else{
                    Intent intent =new Intent(TitleActivity.this, DestinationActivity.class);
                    intent.putExtra("title", sTitle);
                    startActivity(intent);
                }
            }
        });
    }

}

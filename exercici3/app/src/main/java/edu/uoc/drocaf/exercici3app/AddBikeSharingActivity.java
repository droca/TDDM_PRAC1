package edu.uoc.drocaf.exercici3app;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBikeSharingActivity extends AppCompatActivity {

    private EditText bikeIdView;
    private EditText bikeDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike_sharing);

        bikeIdView = findViewById(R.id.bike_id);
        bikeDescriptionView = findViewById(R.id.bike_description);

        // TODO check bikeIDView not empty
        // TODO check bikeDescriptionView not empty

        Button add_bike = findViewById(R.id.add_bike);

        final String bikeId = bikeIdView.getText().toString();
        final String bikeDescription = bikeDescriptionView.getText().toString();

        add_bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddBikeSharingActivity.this, BykeSharingListActivity.class);
                intent.putExtra("EXTRA_BIKE_ID", bikeId);
                intent.putExtra("EXTRA_BIKE_DESCRIPTION", bikeDescription);
                startActivity(intent);
            }
        });

    }
}

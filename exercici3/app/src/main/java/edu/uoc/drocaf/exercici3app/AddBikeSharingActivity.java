package edu.uoc.drocaf.exercici3app;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBikeSharingActivity extends AppCompatActivity {

    private EditText mBikeIdView;
    private EditText mBikeDescriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike_sharing);

        mBikeIdView = findViewById(R.id.bike_id);
        mBikeDescriptionView = findViewById(R.id.bike_description);

        Button add_bike = findViewById(R.id.add_bike);

        add_bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptAddBike();
            }
        });

    }

    public void attemptAddBike() {
        mBikeIdView.setError(null);
        mBikeDescriptionView.setError(null);

        String bikeId = mBikeIdView.getText().toString();
        String bikeDescription = mBikeDescriptionView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(bikeDescription)) {
            mBikeDescriptionView.setError("This field cannot be empty");
            focusView = mBikeDescriptionView;
            cancel = true;
        }

        if (TextUtils.isEmpty(bikeId)) {
            mBikeIdView.setError("This field cannot be empty");
            focusView = mBikeIdView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(AddBikeSharingActivity.this, BykeSharingListActivity.class);
            intent.putExtra("EXTRA_BIKE_ID", bikeId);
            intent.putExtra("EXTRA_BIKE_DESCRIPTION", bikeDescription);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}

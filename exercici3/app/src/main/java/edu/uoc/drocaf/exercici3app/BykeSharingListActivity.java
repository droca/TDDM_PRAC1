package edu.uoc.drocaf.exercici3app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BykeSharingListActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private final static int REQUEST_CODE_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_byke_sharing_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.open_add_bike_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BykeSharingListActivity.this, AddBikeSharingActivity.class);
                startActivityForResult(intent, REQUEST_CODE_1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_1:
                if(resultCode == RESULT_OK) {
                    String bikeId = data.getStringExtra("EXTRA_BIKE_ID");
                    String bikeDescription = data.getStringExtra("EXTRA_BIKE_DESCRIPTION");
                    Bike bike = new Bike(bikeId, bikeDescription);
                    ItemFragment fragment = (ItemFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
                    fragment.updateBikes(bike);
                }
            default:
                // Do nothing
        }
    }

    @Override
    public void onListFragmentInteraction(Bike bike) {

    }
}

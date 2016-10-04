package com.brianmk.backcountrycheck_in;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

/**
 * Created by rot on 2016-01-24.
 */
public class TripDetailActivity extends AppCompatActivity {
    private static final String LOG_TAG = TripDetailActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.trip_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("North Vancouver");


        Log.v(LOG_TAG, "clicked");
    }
}

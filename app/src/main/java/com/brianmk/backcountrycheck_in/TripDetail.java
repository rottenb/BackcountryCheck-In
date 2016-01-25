package com.brianmk.backcountrycheck_in;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by rot on 2016-01-24.
 */
public class TripDetail extends AppCompatActivity {
    private static final String LOG_TAG = TripDetail.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(LOG_TAG, "clicked");
    }
}

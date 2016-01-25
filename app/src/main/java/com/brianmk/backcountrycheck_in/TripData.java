package com.brianmk.backcountrycheck_in;

/**
 * Created by rot on 2016-01-23.
 */

public class TripData {
    private final String LOG_TAG = TripData.class.getSimpleName();

    String tripTitle;
    String tripSummary;
    int tripMapThumbId;

    TripData(String title, String summary, int mapId) {
        tripTitle = title;
        tripSummary = summary;
        tripMapThumbId = mapId;
    }
}

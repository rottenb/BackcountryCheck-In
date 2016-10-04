package com.brianmk.backcountrycheck_in;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityFragment extends Fragment {
    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    private List<TripData> mTripList;

    private ListView mListView;
    private ArrayAdapter<String> mListAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mTripList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mTripList.add(new TripData(getString(R.string.card_title),
                    getString(R.string.card_summary),
                    R.drawable.blank_map));
        }

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GridView cardGridView = (GridView) rootView.findViewById(R.id.card_grid);
        cardGridView.setAdapter(new TripDataAdapter(this.getContext()));

        cardGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent tripIntent = new Intent(getActivity(), TripDetailActivity.class);
                startActivity(tripIntent);
            }
        });

        return rootView;
    }

    public class TripDataAdapter extends BaseAdapter {
        private Context mContext;


        public TripDataAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mTripList.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // Create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.trip_card, null);
            }

            CardView cardView = (CardView) convertView.findViewById(R.id.trip_card_view);

            return cardView;
        }
    }

}

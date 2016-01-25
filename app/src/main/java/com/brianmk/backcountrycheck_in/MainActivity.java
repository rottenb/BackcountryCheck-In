package com.brianmk.backcountrycheck_in;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    protected static final String[] DRAWER_NAMES = {"Create", "Edit", "Sort", "View", "About", "Settings" };
    protected static final int[] DRAWER_ICONS = {android.R.drawable.ic_menu_mapmode,
                                    android.R.drawable.ic_menu_close_clear_cancel,
                                    android.R.drawable.ic_menu_mylocation,
                                    android.R.drawable.ic_menu_myplaces,
                                    android.R.drawable.ic_menu_agenda,
                                    android.R.drawable.ic_menu_preferences};
    protected String mUserName = "Brian Kennedy";
    protected String mUserEmail = "brianmk@gmail.com";
    protected int mUserImage = R.drawable.bmk;

    private Toolbar mToolbar;

    protected RecyclerView mDrawerRecyclerView;
    protected RecyclerView.Adapter mDrawerAdapter;
    protected RecyclerView.LayoutManager mDrawerLayoutManager;
    protected DrawerLayout mDrawerLayout;

    protected ActionBarDrawerToggle mDrawerToggle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        mDrawerRecyclerView = (RecyclerView) findViewById(R.id.drawer_recyclerview);
        mDrawerRecyclerView.setHasFixedSize(true);
        mDrawerAdapter = new DrawerAdapter(DRAWER_NAMES, DRAWER_ICONS, mUserName, mUserEmail,
                                            mUserImage);
        mDrawerRecyclerView.setAdapter(mDrawerAdapter);

        mDrawerLayoutManager = new LinearLayoutManager(this);
        mDrawerRecyclerView.setLayoutManager(mDrawerLayoutManager);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                                                    R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adds a new trip", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId < 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }
}

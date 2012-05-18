package com.harrierllc.products;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HarrierproductsActivity extends Activity {
    private StandardAdapter activitiesAdapter;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        activitiesAdapter = new StandardAdapter(getApplicationContext());
        
        activitiesAdapter.buildActivities();
        
        ListView activitiesView = (ListView) findViewById(R.id.ListView_main_activitiesList);
        activitiesView.setAdapter(activitiesAdapter);
        
    }
}
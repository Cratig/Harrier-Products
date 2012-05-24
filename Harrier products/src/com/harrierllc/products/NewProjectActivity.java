package com.harrierllc.products;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class NewProjectActivity extends Activity {
	static final String tag = "New Project activity";
	private StandardAdapter projectsAdapter;
	private ListView projectsView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.newproject_main);
		
		projectsAdapter = new StandardAdapter(getApplicationContext());
		projectsAdapter.buildProjects();
		
		projectsView = (ListView) findViewById(R.id.ListView_newproject_projectsList);
		
		projectsView.setAdapter(projectsAdapter);
		
		
	}
	
	

}

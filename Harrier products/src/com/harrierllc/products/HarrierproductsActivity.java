package com.harrierllc.products;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class HarrierproductsActivity extends Activity {
	static final String tag = "Startup activity";

	static final int PROGRESSDIALOG_DISMISS_DELAY = 3000;
	
	private StandardAdapter activitiesAdapter;
	private ProgressDialog progressDialog;

	private ListView activitiesView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		activitiesAdapter = new StandardAdapter(getApplicationContext());

		activitiesAdapter.buildActivities();

		activitiesView = (ListView) findViewById(R.id.ListView_main_activitiesList);
		activitiesView.setAdapter(activitiesAdapter);
		activitiesView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				StandardAdapterListItem item = (StandardAdapterListItem) activitiesAdapter
						.getItem(position);

				Animation listAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.listitem_select);
				
				view.startAnimation(listAnim);
				
				switch (item.action) {
				case StandardAdapterListItem.listItem_ACTIVITY_NEW:
					startNewProject();
					break;
				case StandardAdapterListItem.listItem_ACTIVITY_TEST:
					break;
				default:
					break;
				}
			}
		});

	}

	private void startNewProject() {
		Log.i(tag, "User selected new project");
		showProgressDialog();
		
		Intent intent = new Intent();
		intent.setClass(this, NewProjectActivity.class);
		startActivity(intent);

	}

	private void setupProgressDialog() {
		if (progressDialog != null) {
			return;
		}

		progressDialog = new ProgressDialog(this);
		progressDialog.setCancelable(false);
		progressDialog.setMessage("Test progress dialog");
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

	}

	private void showProgressDialog() {
		if (progressDialog == null) {
			setupProgressDialog();
		}

		if (progressDialog.isShowing()) {
			return;
		}

		progressDialog.show();
		
		
		Thread dismissProgressDialogThread = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(PROGRESSDIALOG_DISMISS_DELAY);
					dismissProgressDialogHandler.sendEmptyMessage(0);
				} catch (InterruptedException e) {
					Log.e(tag, e.getMessage());
				}
			}
		};
		
		dismissProgressDialogThread.start();
	}

	private Handler dismissProgressDialogHandler = new Handler() {
		public void handleMessage(Message msg) {
			hideProgressDialog();
		}
	};
	
	private void hideProgressDialog() {
		if (progressDialog == null) {
			return;
		}

		if (progressDialog.isShowing() == false) {
			return;
		}

		progressDialog.dismiss();
	}
}
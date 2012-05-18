package com.harrierllc.products;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class StandardAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<StandardAdapterListItem> items;
	
	public StandardAdapter(Context _context) {
		this.context = _context;
		this.items = new ArrayList<StandardAdapterListItem>();
	}
	
	public void buildActivities() {
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_media_play, context.getString(R.string.main_activity_newProject_title), context.getString(R.string.main_activity_newProject_tagline)));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_info_details, "Test 2", "Line 2"));
	}
	
	public int getCount() {
		return this.items.size();
	}

	public Object getItem(int position) {
		return this.items.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}

class StandardAdapterListItem {
	int image;
	String title;
	String tagline;
	
	public StandardAdapterListItem(int _image, String _title, String _tagline) {
		this.image = _image;
		this.title = _title;
		this.tagline = _tagline;
	}
	
}
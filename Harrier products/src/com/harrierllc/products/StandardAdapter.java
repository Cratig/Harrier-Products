package com.harrierllc.products;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StandardAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<StandardAdapterListItem> items;
	
	public StandardAdapter(Context _context) {
		this.context = _context;
		this.items = new ArrayList<StandardAdapterListItem>();
	}
	
	public void buildActivities() {
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_media_play, context.getString(R.string.main_activity_newProject_title), context.getString(R.string.main_activity_newProject_tagline), StandardAdapterListItem.listItem_ACTIVITY_NEW));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_info_details, "Test 2", "Line 2", StandardAdapterListItem.listItem_ACTIVITY_TEST, false));
	}
	
	public void buildProjects() {
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST, false));
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_menu_crop, "Project 1", "create your project dreams here", StandardAdapterListItem.listItem_PROJECT_TEST));
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

	static class ItemHolder {
		public ImageView image;
		public TextView title;
		public TextView tagline;
		public boolean enabled;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		
		if (view == null) {
			LayoutInflater lInflater = LayoutInflater.from(context);
			view = lInflater.inflate(R.layout.standardadapter_listitem_template, null);
			
			ItemHolder itemHolder = new ItemHolder();
			itemHolder.image = (ImageView) view.findViewById(R.id.ImageView_standardadapter_listitem_template_image);
			itemHolder.title = (TextView) view.findViewById(R.id.TextView_stndardadapter_listitem_template_title);
			itemHolder.tagline = (TextView) view.findViewById(R.id.TextView_stndardadapter_listitem_template_tagline);
			itemHolder.enabled = true;
			
			view.setTag(itemHolder);
		}
		
		ItemHolder iHolder = (ItemHolder) view.getTag();
		
		StandardAdapterListItem item = this.items.get(position);
		
		iHolder.image.setImageResource(item.image);
		iHolder.title.setText(item.title);
		iHolder.tagline.setText(item.tagline);
		iHolder.enabled = item.enabled;
		
		view.setEnabled(iHolder.enabled);
		
		return view;
	}
	
}

class StandardAdapterListItem {
	final static int listItem_ACTIVITY_NEW = 1;
	final static int listItem_ACTIVITY_TEST = 2;
	
	final static int listItem_PROJECT_TEST = 1;
	final static int listItem_PROJECT_TEST2 = 2;
	
	int image;
	String title;
	String tagline;
	int action;
	boolean enabled;
	
	public StandardAdapterListItem(int _image, String _title, String _tagline, int _action) {	
		this(_image, _title, _tagline, _action, true);
	}
	
	public StandardAdapterListItem(int _image, String _title, String _tagline, int _action, boolean _enabled) {
		this.image = _image;
		this.title = _title;
		this.tagline = _tagline;
		this.action = _action;
		this.enabled = _enabled;
	}
}
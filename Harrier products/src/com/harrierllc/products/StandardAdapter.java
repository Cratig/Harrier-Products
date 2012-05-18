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
		this.items.add(new StandardAdapterListItem(android.R.drawable.ic_media_play, R.string.main_activity_newProject_title, R.string.main_activity_newProject_tagline));
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

	static class ItemHolder {
		public ImageView image;
		public TextView title;
		public TextView tagline;
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
			
			view.setTag(itemHolder);
		}
		
		ItemHolder iHolder = (ItemHolder) view.getTag();
		
		StandardAdapterListItem item = this.items.get(position);
		
		iHolder.image.setImageResource(item.image);
		iHolder.title.setText(item.title);
		iHolder.tagline.setText(item.tagline);
		
		return view;
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
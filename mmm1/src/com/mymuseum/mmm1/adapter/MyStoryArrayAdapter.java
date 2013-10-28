package com.mymuseum.mmm1.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * @see http://arabiannight.tistory.com/77 google "android adapter"
 * @author user
 *
 * @param <T>
 */
public class MyStoryArrayAdapter<T> extends ArrayAdapter<T> {

	public MyStoryArrayAdapter(Context context, int textViewResourceId,
			List<T> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getView(position, convertView, parent);
	}

}

package com.mymuseum.mmm1.adapter;

import java.util.List;

import com.mm.imgmgt.model.Museum;
import com.mymuseum.mmm1.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @see http://arabiannight.tistory.com/77 google "android adapter"
 * @author user
 *
 * @param <T>
 */
public class MyStoryArrayAdapter<T> extends ArrayAdapter<T> {

	Context context;
	List<Museum> list;
	
	public MyStoryArrayAdapter(Context context, int textViewResourceId,
			List<T> objects) {
		super(context, textViewResourceId, objects);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		if(view == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.listrow, parent, false);
		}
		
		Museum museum = (Museum) getItem(position);
		TextView txtCn = (TextView) view.findViewById(R.id.txtCn);
		TextView txtRef = (TextView) view.findViewById(R.id.txtRef);
		
		txtCn.setText(museum.getMsgCn());
		txtRef.setText(museum.getMsgId());
		return view;
		//return super.getView(position, convertView, parent);
	}

}

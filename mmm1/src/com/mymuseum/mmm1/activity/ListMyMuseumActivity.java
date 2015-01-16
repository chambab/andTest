package com.mymuseum.mmm1.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.imgmgt.model.Museum;
import com.mm.imgmgt.model.Page;
import com.mymuseum.mmm1.R;
import com.mymuseum.mmm1.R.layout;
import com.mymuseum.mmm1.R.menu;
import com.mymuseum.mmm1.adapter.MyMuseumArrayAdapter;
import com.mymuseum.mmm1.adapter.MyStoryArrayAdapter;
import com.mymuseum.mmm1.utils.ActivityUtils;
import com.mymuseum.mmm1.utils.HttpUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ListMyMuseumActivity extends Activity {

	private EditText userId = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_my_museum);
		
	}
	/**
	 * Search MyMuseum by UserId
	 * @param clickedButton
	 */
	public void searchMyMuseum(View clickedButton) {
		
		userId = (EditText) findViewById(R.id.editUserId);
		if(userId.getText() == null) {
			userId.setText("hjaemoon");
		}
		
		String jsonString = null;
		String urls = "http://m.mymuseum.co.kr/mm/1/msg/" + userId.getText() + "/MyMuseumList.json";
		List<Museum> listMuseum = null;
		try {
			jsonString = HttpUtils.urlContent(urls);

			ObjectMapper mapper = new ObjectMapper();
			listMuseum = mapper.readValue(jsonString, new TypeReference<List<Museum>>(){});
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListView listMyStoryView = (ListView) findViewById(R.id.listMuseumView);
		
		MyMuseumArrayAdapter adapter = new MyMuseumArrayAdapter(this,
				R.layout.list_museum, listMuseum);
		
		listMyStoryView.setAdapter(adapter);				
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_my_museum, menu);
		return true;
	}

}

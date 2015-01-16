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
import com.mymuseum.mmm1.adapter.MyStoryArrayAdapter;
import com.mymuseum.mmm1.utils.HttpUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class ListMyStoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_my_story);
		// Show the Up button in the action bar.
		// getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// 			data: "query=" + query + "&pageIndex=" + pageIndex,

		String jsonString = null;
		//String urls = "http://m.mymuseum.co.kr/mm/1/search/search.json?query=scloud&pageIndex=1";
		String urls = "http://m.mymuseum.co.kr/mm/1/msg/hjaemoon/MyMuseumMsg.json";
		List<Museum> listMuseum = null;
		Page page = null;
		try {
			//jsonString = HttpUtils.urlContent(urls);
			jsonString = HttpUtils.urlContentPost(urls, "query", "scloud");
			ObjectMapper mapper = new ObjectMapper();
			listMuseum = mapper.readValue(jsonString, new TypeReference<List<Museum>>(){});
			//page = mapper.readValue(jsonString, new TypeReference<Page>(){});
						
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<Museum> list = null;
		//list = (ArrayList<Museum>) page.getObjects();
		
//		Museum museum1 = new Museum();
//		Museum museum2 = new Museum();
//		museum1.setMsgId("id1");
//		museum1.setMsgCn("Message1");
//		museum2.setMsgId("id2");
//		museum2.setMsgCn("Message2");
//		list.add(museum1);
//		list.add(museum2);
		
		ListView listMyStoryView = (ListView) findViewById(R.id.listMyStoryView);
		
		MyStoryArrayAdapter adapter = new MyStoryArrayAdapter(this,
				R.layout.listrow, listMuseum);
		
		listMyStoryView.setAdapter(adapter);
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_my_story, menu);
		return true;
	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case android.R.id.home:
//			// This ID represents the Home or Up button. In the case of this
//			// activity, the Up button is shown. Use NavUtils to allow users
//			// to navigate up one level in the application structure. For
//			// more details, see the Navigation pattern on Android Design:
//			//
//			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
//			//
//			NavUtils.navigateUpFromSameTask(this);
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

}

package com.mymuseum.mmm1.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mm.imgmgt.model.Museum;
import com.mymuseum.mmm1.R;
import com.mymuseum.mmm1.utils.HttpUtils;


/**
 * @see http://wiki.fasterxml.com/JacksonInFiveMinutes
 * @see http://wiki.fasterxml.com/JacksonInFiveMinutes
 * @author user
 *
 */
public class UrlTestActivity extends Activity {

	private EditText urlText;
	private TextView txtView;
	private ListView listView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_url_test);
		urlText = (EditText) findViewById(R.id.urlText);
		listView = (ListView) findViewById(R.id.listView1);
		urlText.setText("http://m.mymuseum.co.kr/mm/1/msg/hjaemoon/MyMuseumList.json");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_url_test, menu);
		return true;
	}
	/**
	 * @see http://m.mymuseum.co.kr/mm/1/msg/{userId}/MyMuseumMsg.json
	 * @see http://m.mymuseum.co.kr/mm/2/msg/{userId}/{pageIndex}/MyMuseumMsg.json
	 * @param clickedButton
	 * @throws JSONException 
	 */
	public void getUrlTest(View clickedButton) throws JSONException {
		urlText = (EditText) findViewById(R.id.urlText);
		txtView = (TextView) findViewById(R.id.txtview);
		
		String urls = urlText.getText().toString();
		String jsonString = null;
		//JSONObject inputsJson = new JSONObject(inputs.getInputMap());
		try {
			jsonString = HttpUtils.urlContent(urls);
			//String jsonString = HttpUtils.urlContentPost(urlstr, "loanInputs", inputsJson.toString());
			//JSONObject jsonResult = new JSONObject(jsonString);
			
			List<Museum> listMuseum = null;
			ObjectMapper mapper = new ObjectMapper();
			listMuseum = mapper.readValue(jsonString, new TypeReference<List<Museum>>(){});
			
			
			List<String> listStr = new ArrayList<String>();
			
			
			for(Museum museum : listMuseum) {
				listStr.add(museum.getUserId());
			}
			
			
			//txtView.setText(jsonString);
			
			//	TODO
			//String[] values = new String[] {"Android", "iPhone", "Window",
			//					"Blackberry","WebOs","Ubuntu"};
			//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			//		android.R.layout.simple_list_item_1, values);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, listStr);
			
			listView.setAdapter(adapter);
			
		
		} catch (ClientProtocolException e) {
			txtView.setText("Illegal base URL");
        } catch (IOException e) {
        	txtView.setText("Server error: " + e);
        }
		
	}

}

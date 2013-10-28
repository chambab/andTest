package com.mymuseum.mmm1.activity;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
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
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_url_test);
		urlText = (EditText) findViewById(R.id.urlText);
		urlText.setText("http://m.mymuseum.co.kr/mm/1/msg/chambab/1/MyMuseumMsg.json");
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
		
		String urlstr = urlText.getText().toString();
		String jsonString = null;
		//JSONObject inputsJson = new JSONObject(inputs.getInputMap());
		try {
			jsonString = HttpUtils.urlContent(urlstr);
			//String jsonString = HttpUtils.urlContentPost(urlstr, "loanInputs", inputsJson.toString());
			//JSONObject jsonResult = new JSONObject(jsonString);
			
			
			List<Museum> listMuseum = null;
			
			ObjectMapper mapper = new ObjectMapper();
			
			
			
			listMuseum = mapper.readValue(jsonString, new TypeReference<List<Museum>>(){});
			
			for(Museum museum : listMuseum) {
				museum.getUserNm();
			}
			
			txtView.setText(jsonString);
		
		} catch (ClientProtocolException e) {
			txtView.setText("Illegal base URL");
        } catch (IOException e) {
        	txtView.setText("Server error: " + e);
        }
		
	}

}

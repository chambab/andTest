package com.mymuseum.mmm1;


import com.mymuseum.mmm1.activity.LoanCalculatorActivity;
import com.mymuseum.mmm1.activity.UrlTestActivity;
import com.mymuseum.mmm1.utils.ActivityUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] countryArray = {"India", "Pakistan", "USA", "UK","Seoul","YangJu"};
	private Button btnProduct;
	private EditText txtId, txtPw;
	private ProgressBar bar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview,
				countryArray);
		
		
		
		bar = (ProgressBar) findViewById(R.id.progressBar1);
		
		ListView listView = (ListView)findViewById(R.id.country_list);
		listView.setAdapter(adapter);
		this.addListenerOnButton();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/**
	 * Button Listener
	 */
	private void addListenerOnButton() {
		btnProduct = (Button) findViewById(R.id.button1);
		txtId = (EditText) findViewById(R.id.userId);
		txtPw = (EditText) findViewById(R.id.passwd);
		
		
		btnProduct.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String strId =	txtId.getText().toString();
			String strPw = txtPw.getText().toString();
			Toast.makeText(getApplicationContext(), strId + " " + strPw,Toast.LENGTH_LONG).show();	
			}
		});
	}
	
	public void startProgress(View view) {
		bar.setProgress(0);
		new Thread(new Task()).start();
	}
    /** Switches to the NistTimeActivity when the associated button is clicked. 
     *  You must also register the new Activity in AndroidManifest.xml. 
     */	
	public void startUrlTest(View clickedButton) {
		ActivityUtils.goToActivity(this, UrlTestActivity.class);
		//ActivityUtils.goToActivity(this, LoanCalculatorActivity.class);
	}
	
	class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0; i <= 10; i++) {
				final int value = i;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bar.setProgress(value);
			}
		}
		
	}
}

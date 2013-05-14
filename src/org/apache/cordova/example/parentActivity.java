package org.apache.cordova.example;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class parentActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "myExtraMessage";
	public final static String RECIEVE_DATA = "PARENT_RECIEVE_DATA";
	public final static int REQUEST_CODE = 200;
	
	
	private TextView tLog;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parent_layout);
		
		tLog = (TextView) findViewById(R.id.textView1);
		
	}
	
	public void sendMessage(View view) {
		tLog.setText("Sent message");
		Intent intent = new Intent(this, cordovaExample.class);
		String msg = ((EditText) findViewById(R.id.editText1)).getText().toString();
		intent.putExtra(EXTRA_MESSAGE, msg);
		startActivityForResult(intent, REQUEST_CODE);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            String text = data.getStringExtra(cordovaExample.RESULT);
	            TextView result = (TextView) findViewById(R.id.textView2);
	            result.setText(text);
	            tLog.setText("Got result");
	        }
	    }
	}
}

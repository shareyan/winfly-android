package com.shareyan.community;

import org.apache.http.Header;
import org.apache.http.client.params.ClientPNames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class Login extends Activity {

	final static String login_url = "http://shareyan.cn/cloud/";  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//add onclick listener
		Button send_btn = (Button)findViewById(R.id.send_btn);
		Button cancel_btn = (Button)findViewById(R.id.cancel_btn);
		send_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//get username and passwd
				EditText text_admin_name = (EditText)findViewById(R.id.admin_name);
				EditText text_passwd = (EditText)findViewById(R.id.admin_passwd);
				String admin_name = text_admin_name.getText().toString();
				String admin_passwd = text_passwd.getText().toString();
				// send http req to server
				AsyncHttpClient client = new AsyncHttpClient();
				client.getHttpClient().getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
				try{
					client.get(login_url+admin_name, new AsyncHttpResponseHandler(){
						public void onSuccess(int statusCode,Header header[],String res){
							Intent intent = new Intent(getApplicationContext(),MainActivity.class);
							intent.putExtra("content",res);
							startActivity(intent);
						}
						
						public void onFailure(int statusCode,Header[] headers, Throwable error, String content){
							Toast.makeText(getApplicationContext(),"Hi", Toast.LENGTH_SHORT).show();
							Toast.makeText(getApplicationContext(),String.valueOf(statusCode), Toast.LENGTH_SHORT).show();
						}
						
					});
				}catch(Exception e){
					Log.d("Error",e.toString());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}

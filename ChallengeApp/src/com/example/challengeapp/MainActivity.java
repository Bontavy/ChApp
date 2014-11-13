/*
 * This class is the activity to login to the app
 * After users login, they will be redirected to "Create Challenge" page to create their challenges
 * 
 * @author: Bontavy Vorng
 * @version: v1
 * @since: v1
 * 
 */

package com.example.challengeapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	EditText Username;
	EditText Password;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    
    /*
     * @param view a View object
     * @exception Exception throws an exception
     */
    public void goToCreateAChallenge(View view) throws Exception {
    	Username = (EditText) findViewById(R.id.username);
    	Password = (EditText) findViewById(R.id.password);
    	Boolean LoginSuccess = false;
    	File file = new File("Account.txt");
    	
    	//if(!file.exists())
    	/*{
    		try {
        		FileOutputStream fOut = openFileOutput("Account.txt", MODE_WORLD_READABLE);
        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
        		os..write("Read");
        		osw.flush();
        		osw.close();
        	}catch(FileNotFoundException e)
        	{
        		 e.printStackTrace();
        	}
    		//Toast.makeText(getApplicationContext(), "creta", Toast.LENGTH_SHORT).show();
    	}*/
    	
    	{
    		String test = "";
    		InputStream iS = openFileInput("Account.txt");
    		FileInputStream fIn = openFileInput("Account.txt");
    		InputStreamReader isr = new InputStreamReader(iS);
    		BufferedReader read = new BufferedReader(isr);
    		String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();
             
            while ( (receiveString = read.readLine()) != null ) {
                stringBuilder.append(receiveString);
            }
             
            iS.close();
            test = stringBuilder.toString();
            Toast.makeText(getApplicationContext(), test, Toast.LENGTH_SHORT).show();
        
    	}
    	
    	/*try {
    		FileOutputStream fOut = openFileOutput("Account.txt", MODE_WORLD_READABLE);
    		OutputStreamWriter osw = new OutputStreamWriter(fOut);
    		fOut.
    		osw.write("");
    		osw.flush();
    		osw.close();
    	}catch(FileNotFoundException e)
    	{
    		 e.printStackTrace();
    	}*/
    	if(LoginSuccess)
    	{
    	Intent intent = new Intent(MainActivity.this, CreateAChallengeActivity.class);
    	startActivity(intent);
    	}
    }
    
    
    public void createAccount(View view) throws Exception {
    	Username = (EditText) findViewById(R.id.username);
    	Password = (EditText) findViewById(R.id.password);
    	Boolean LoginSuccess = false;
    	
    	//if(!file.exists())
    	{
    		try {
        		FileOutputStream fOut = openFileOutput("Account.txt", MODE_APPEND);
        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
        		osw.append("< ");
        		osw.append(Username.getText().toString());
        		osw.append(Password.getText().toString());
        		osw.append(" >");
        		osw.flush();
        		osw.close();
        	}catch(FileNotFoundException e)
        	{
        		 e.printStackTrace();
        	}
    		//Toast.makeText(getApplicationContext(), "creta", Toast.LENGTH_SHORT).show();
    	}
    	Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

/*
 * @author Bontavy
 * @author Chuka
 * This class is the activity to login to the app
 * After users login, they will be redirected to "Create Challenge" page to create their challenges
 */

package com.example.challengeapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {
	static User currentUser;
	EditText username;
	EditText password;
	
	/*
	 * @param savedInstanceState is a Bundle
	 * onCreate creates the login screen
	 */
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
    	username = (EditText) findViewById(R.id.username);
    	password = (EditText) findViewById(R.id.password);
    	Boolean LoginSuccess = false;
    	
    	try
    	{
    		String SUsername = "";
    		String SPassword = "";
    		InputStream iS = openFileInput("Account.txt");
    		java.util.Scanner read = new Scanner(iS);
            
            while(read.hasNext())
            {
            	
            	 String r = read.next();
            	if(r.equals("<"))
            	{
            		SUsername = read.next();
            		SPassword = read.next();
            		if(SUsername.equals(username.getText().toString()) && SPassword.equals(password.getText().toString()))
            		{
            			LoginSuccess = true;
            			break;
            		}
            		String t = read.next();
            	}
            	
            }
            iS.close();
            read.close();
        
    	} catch(FileNotFoundException e)
    	{
   		 e.printStackTrace();
    	}
    	
    	if(LoginSuccess)
    	{
    		try
        	{
        		InputStream iS = openFileInput("User:" + username.getText().toString() + ".txt");
        		InputStreamReader isr = new InputStreamReader(iS);
        		java.util.Scanner read = new Scanner(iS);
                
        		read.next();
        		String userName = read.next();
        		String password = read.next();
        		read.next();
                if(read.hasNext())
                {
                	List<String> friends = null;
            		List<Challenge> postedChallenges = null;
                	String bracket1 = read.next();
                	if(bracket1.equals("<"))
                	{
                		String leftBracket = ">";
                		while(read.hasNext())
                		{
                			String flag = read.next();
                			if(flag.equals(">"))
                				break;
                			
                			UUID challengeId = UUID.fromString(flag);
                			String category = read.next();
                			String title = read.next();
                			String description = read.next();
                			String picture = read.next();
                			String privacy = read.next();
                			Boolean Sponsored = read.nextBoolean();
                			Boolean completed = read.nextBoolean();
                			String createdBy = read.next();
                			
                			Challenge newChallenge = new Challenge(challengeId, category, 
                					title, description, picture, privacy, Sponsored, completed, 
                					createdBy, Calendar.getInstance().getTime());
                			
                			postedChallenges.add(newChallenge);
                		}
                		
                	} 
                	
                	String bracket2 = read.next();
                	if(bracket2.equals("<"))
                	{
                		while(read.hasNext())
                		{
                			String flag = read.next();
                			if(flag.equals(">"))
                				break;
                			
                			friends.add(flag);
                		}
                	}
                	currentUser = new User(userName,password, postedChallenges, null, friends);
                }
                else{
            		currentUser = new User(userName, password);
            	}
                iS.close();
                read.close();
            
        	} catch(FileNotFoundException e)
        	{
       		 e.printStackTrace();
        	}
    		
    		Intent intent = new Intent(MainActivity.this, CreateAChallengeActivity.class);
    		startActivity(intent);
    	} else
    	{
    		Toast.makeText(getApplicationContext(), "Account Does Not Exist", Toast.LENGTH_SHORT).show();
    	}
    }
    
    /**
     * @param view is a View object
     * @throws Exception
     * createAccount takes the username and password to create an account
     */
    public void createAccount(View view) throws Exception {
    	username = (EditText) findViewById(R.id.username);
    	password = (EditText) findViewById(R.id.password);
    	Boolean userNameUsed = false;
    	String userName = "";
    	
    	{
    		try
        	{
        		InputStream iS = openFileInput("Account.txt");
        		InputStreamReader isr = new InputStreamReader(iS);
        		java.util.Scanner read = new Scanner(iS);
                
                while(read.hasNext())
                {
                	
                	String bracket = read.next();
                	if(bracket.equals("<"))
                	{
                		userName = read.next();
                		if(userName.equals(username.getText().toString()))
                		{
                			userNameUsed = true;
                			iS.close();
                            read.close();
                			break;
                		}
                		
                		read.next();
                		read.next();
                	}                	
                }
                iS.close();
                read.close();
            
        	} catch(FileNotFoundException e)
        	{
       		 e.printStackTrace();
        	}
    	}
    	
    	
    	if(!userNameUsed)
    	{
    		try {
        		FileOutputStream fOut = openFileOutput("User:" + username.getText().toString() + ".txt", MODE_WORLD_READABLE);
        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
        		BufferedWriter hh = new BufferedWriter(osw);
        		hh.write("< " + username.getText().toString() + " " + password.getText().toString() + " > ");
        		hh.close();
        	}catch(FileNotFoundException e)
        	{
        		 e.printStackTrace();
        	}
    		
    		try {
        		FileOutputStream fOut = openFileOutput("Account.txt", MODE_APPEND);
        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
        		BufferedWriter hh = new BufferedWriter(osw);
        		hh.write("< " + username.getText().toString() + " " + password.getText().toString() + " > ");
        		hh.close();
        		Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
        	}catch(FileNotFoundException e)
        	{
        		 e.printStackTrace();
        	}
    	}
    	else{
    		Toast.makeText(getApplicationContext(), "The username already exists", Toast.LENGTH_SHORT).show();
    	}
    	
    }
    
    
    
    /**
     * @param menu is a Menu object
     * @return boolean true if menu is created
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    // Exits the app after the back button is pressed on the login screen
    public void onBackPressed() {
    	   Intent intent = new Intent(Intent.ACTION_MAIN);
    	   intent.addCategory(Intent.CATEGORY_HOME);
    	   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	   startActivity(intent);
    	 }
    
}
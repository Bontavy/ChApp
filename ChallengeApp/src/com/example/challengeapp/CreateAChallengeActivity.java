
/**
* @author Bontavy
* @author Chuka
*/

/* This class is the activity for allowing users to create a challenge with info such as the challenge name, description, category, and privacy.
 * The challenge info will then be displayed on a page called "Challenge List" for users to see all the challenges that they have created.
 */

package com.example.challengeapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAChallengeActivity extends ActionBarActivity {
	
	
	EditText titleText, descriptionText, categoryText, privacyText; // For the input from the user from the text fields
	
	List<Challenge> Challenges = new ArrayList<Challenge>();		// An array list for challenges
	List<Challenge> MyChallenges = new ArrayList<Challenge>();
	List<Challenge> othersChallenges = new ArrayList<Challenge>();
	ListView challengeListView;										// A ListView for the list of challenges in the "Challenges List" page
	ListView challengeMyListView;
	ListView challengeFriendsListView;
	ArrayAdapter<Challenge> adapter;
	
	/**********
	@param savedInstanceState 
	onCreate sets up the user interface once an activity is created
	***********/
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_challenge_activity);
        // Sets the input from the text fields to their corresponding EditText variables
        titleText = (EditText) findViewById(R.id.challengeName);
        descriptionText = (EditText) findViewById(R.id.challengeDescription);
        categoryText = (EditText) findViewById(R.id.challengeCategory);
        privacyText = (EditText) findViewById(R.id.challengePrivacy);
        // The list view where challenges will be populated
        challengeListView = (ListView) findViewById(R.id.allChallengesListView);
        challengeMyListView = (ListView) findViewById(R.id.myChallengesListView);
        challengeFriendsListView = (ListView) findViewById(R.id.myFriendsChallengesListView);
        
        // Setups a tabHost to make two tabs for "Create Challenge" tab and "Challenges List" tab
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        
        tabHost.setup();
        
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("create challenge");
        tabSpec.setContent(R.id.createChallengeTab);
        tabSpec.setIndicator("Create Challenge");
        tabHost.addTab(tabSpec);
        
        tabSpec = tabHost.newTabSpec("challenges list");
        tabSpec.setContent(R.id.challengeListTab);
        tabSpec.setIndicator("Challenges List");
        tabHost.addTab(tabSpec);
        
        // Setups a tabHost to make three tabs for "My Challenges" tab, "My Friends Challenges" tab, "All Challenges" tab
        TabHost secondTabHost = (TabHost) findViewById(R.id.secondtabhost);
        
        secondTabHost.setup();
        tabSpec = secondTabHost.newTabSpec("my challenges");
        tabSpec.setContent(R.id.myChallengesTab);
        tabSpec.setIndicator("My Challenges");
        secondTabHost.addTab(tabSpec);
        
        tabSpec = secondTabHost.newTabSpec("my friends challenges");
        tabSpec.setContent(R.id.myFriendsChallengesTab);
        tabSpec.setIndicator("My Friends Challenges");
        secondTabHost.addTab(tabSpec);
        
        tabSpec = secondTabHost.newTabSpec("all challenges");
        tabSpec.setContent(R.id.allChallengesTab);
        tabSpec.setIndicator("All Challenges");
        secondTabHost.addTab(tabSpec);
        
        try
    	{
    		InputStream iS = openFileInput("Challenges.txt");
    		java.util.Scanner read = new Scanner(iS);
            
    		String id;
    		String category = "";
    		String description = "";
    		String title = "";
    		String privacy = "";
    		String isSponsored, isComplete, userName;
            while(read.hasNext())
            {
            	
            	String bracket = read.next();
            	if(bracket.equals("<"))
            	{
            		String flag = "";
            		id = read.next();
            		String rContent = read.next();
            		if(rContent.equals("'")){
            			while(true){
            				flag = read.next();
            				if(flag.equals("'"))
            				{
            					break;
            				} else 
            				{
            					category = category + " " + flag;
            				}
            			}
            		}
            		
            		rContent = read.next();
            		if(rContent.equals("'")){
            			while(true){
            				flag = read.next();
            				if(flag.equals("'"))
            				{
            					break;
            				} else 
            				{
            					title = title + " " + flag;
            				}
            			}
            		}
            		
            		rContent = read.next();
            		if(rContent.equals("'")){
            			while(true){
            				flag = read.next();
            				if(flag.equals("'"))
            				{
            					break;
            				} else 
            				{
            					description = description + " " + flag;
            				}
            			}
            		}
            		
            		rContent = read.next();
            		if(rContent.equals("'")){
            			while(true){
            				flag = read.next();
            				if(flag.equals("'"))
            				{
            					break;
            				} else 
            				{
            					privacy = privacy + " " + flag;
            				}
            			}
            		}

            		isSponsored = read.next();
            		isComplete = read.next();
            		userName = read.next();
            		
            		String test = read.next();
            		
            		Challenges.add(new Challenge(UUID.fromString(id), category, title, description,privacy, Boolean.getBoolean(isComplete), Boolean.getBoolean(isSponsored), userName));
            		populateChallengesList(challengeListView, Challenges);
            		if(userName.equals(MainActivity.currentUser.getUsername()))
            		{
                		MyChallenges.add(new Challenge(UUID.fromString(id), category, title, description,privacy, Boolean.getBoolean(isComplete), Boolean.getBoolean(isSponsored), userName));
            			populateChallengesList(challengeMyListView, MyChallenges);
            		} else
            		{
            			othersChallenges.add(new Challenge(UUID.fromString(id), category, title, description,privacy, Boolean.getBoolean(isComplete), Boolean.getBoolean(isSponsored), userName));
            			populateChallengesList(challengeFriendsListView, othersChallenges);
            		}
            		category = "";
            		description = "";
            		title = "";
            		privacy = "";
            	}                	
            }
            iS.close();
            read.close();
        
    	} catch(FileNotFoundException e)
    	{
   		 e.printStackTrace();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Creates a challenge after the "Create Challenge" Button is clicked
        final Button createChallengeButton = (Button) findViewById(R.id.createChallengeButton);
        createChallengeButton.setOnClickListener(new View.OnClickListener() {
			
        	
        /***
         *@param v view 
         *Upon "clicking" the button the challenge is created
         */
			@Override
			public void onClick(View v) {
				User me = MainActivity.currentUser;
				UUID id = UUID.randomUUID();
				Challenges.add(new Challenge(id,categoryText.getText().toString(), 
						titleText.getText().toString(), descriptionText.getText().toString(), 
						privacyText.getText().toString(), false, false, me.getUsername()));
				populateChallengesList(challengeListView, Challenges);
				MyChallenges.add(new Challenge(id,categoryText.getText().toString(), 
						titleText.getText().toString(), descriptionText.getText().toString(), 
						privacyText.getText().toString(), false, false, me.getUsername()));
				populateChallengesList(challengeMyListView, MyChallenges);
				
				try {
	        		FileOutputStream fOut = openFileOutput("Challenges.txt", MODE_APPEND);
	        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
	        		BufferedWriter hh = new BufferedWriter(osw);
	        		
	        		String list = hh.toString();

	        			hh.write("< " + id+" ' " + categoryText.getText().toString() + " ' ' " + 
	        			titleText.getText().toString() + " ' ' " + descriptionText.getText().toString() + 
	        			" ' ' " + privacyText.getText().toString() + " ' " + false+" " + false+" "+me.getUsername() + " >");
	        			hh.newLine();
	        			list = hh.toString();
	        		hh.close();
	        	}catch(FileNotFoundException e)
	        	{
	        		 e.printStackTrace();
	        	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Your Challenge has been created!", Toast.LENGTH_SHORT).show();
				// Clears the EditText fields after the user creates a challenge
				titleText.setText(null);
				descriptionText.setText(null);
				categoryText.setText(null);
				privacyText.setText(null);
			}
		});
	}
	
	
	/* Class adapts to the listview_item */
	private class ChallengeListAdapter extends ArrayAdapter<Challenge> {
		List<Challenge> challenges;
		public ChallengeListAdapter(List<Challenge> challenges) {
			super (CreateAChallengeActivity.this, R.layout.listview_item, challenges);
			this.challenges = challenges;
		}
		
		@Override
		/**
		 * @param position is an int that determines what position an activity is in within the list
		 * @param view is a View
		 * @param parent is a ViewGroup that is the parent of the views
		 * @returns a list view
		 */
		
		public View getView(int position, View view, ViewGroup parent) {
			// If the view is not already inflated then inflates the view
			if (view == null) {
				view = getLayoutInflater().inflate(R.layout.listview_item,  parent, false);
			}
			
			// Create a challenge and gets the position of the current challenge
			Challenge currentChallenge = challenges.get(position);
			
			// Gets the challenge name
			TextView title = (TextView) view.findViewById(R.id.textChallengeName);
			
			// Bolds and underlines the challenge name
			SpannableString spanString = new SpannableString(currentChallenge.getTitle());
			spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
			spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
			title.setText(spanString);
			
			// Gets the challenge  description
			TextView description = (TextView) view.findViewById(R.id.textChallengeDescription);
			description.setText(currentChallenge.getDescription());
			
			return view;
		}
	}                   
		
	/* Populates the challenge list with challenge info
	 * @param listView is a ListView that creates a view of the challenge list
	 * @param challenges is a List<Challenge> that holds the challenges
	 */
	private void populateChallengesList(ListView listView, List<Challenge> challenges) {
		adapter = new ChallengeListAdapter(challenges);
		// Sets a new listView
		listView.setAdapter(adapter);
	}
	
	/**
	 * @param menu is a Menu object 
	 * @return true is returned if the menu was created
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_a_challenge_menu, menu);
        return true;
    }

    /**
     * @param item is a MenuItem object
     * @return true if Logout button was selected 
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.logout) {
        	MainActivity.currentUser = null;
        	Challenges.clear();
        	MyChallenges.clear();
        	othersChallenges.clear();
        	Intent intent = new  Intent(CreateAChallengeActivity.this, MainActivity.class);
        	startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
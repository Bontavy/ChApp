/* This class is the activity for allowing users to create a challenge with info such as the challenge name, description, category, and privacy.
 * The challenge info will then be displayed on a page called "Challenge List" for users to see all the challenges that they have created.
 */

package com.example.challengeapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAChallengeActivity extends ActionBarActivity {
	
	
	EditText titleText, descriptionText, categoryText, privacyText; // For the input from the user from the text fields
	
	List<Challenge> Challenges = new ArrayList<Challenge>();		// An array list for challenges
	ListView challengeListView;										// A ListView for the list of challenges in the "Challenges List" page
	
	
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
        challengeListView = (ListView) findViewById(R.id.myChallengesListView);
        
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
        
        // Creates a challenge after the "Create Challenge" Button is clicked
        final Button createChallengeButton = (Button) findViewById(R.id.createChallengeButton);
        createChallengeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				User me = MainActivity.currentUser;
				// Adds a new challenge and populates the challenge list with it
				// TBD: fix the inputs to the challenge. populate the input page
				UUID id = UUID.randomUUID();
				Challenge newChallenge = new Challenge(id, categoryText.getText().toString(), 
						titleText.getText().toString(), descriptionText.getText().toString(),
						"pictures", privacyText.getText().toString(), false, false, me.getUsername(), null);
				me.postedChallenges.add(newChallenge);
				Challenges.add(newChallenge);
				populateChallengesList();
				
				try {
	        		FileOutputStream fOut = openFileOutput("Challenges.txt", MODE_APPEND);
	        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
	        		BufferedWriter hh = new BufferedWriter(osw);

	        			hh.write("<");
		        		hh.newLine();
		        		hh.write(id+"");
		        		hh.newLine();
		        		hh.write(categoryText.getText().toString());
		        		hh.newLine();
		        		hh.write(titleText.getText().toString());
		        		hh.newLine();
		        		hh.write(descriptionText.getText().toString());
		        		hh.newLine();
		        		hh.write("none");
		        		hh.newLine();
		        		hh.write(false+"");
		        		hh.newLine();
		        		hh.write(false+"");
		        		hh.newLine();
		        		hh.write(me.getUsername());
		        		hh.newLine();
	        		hh.write(">");
	        		
	        		hh.close();
	        		//user = new User(Username.getText().toString(), Password.getText().toString());
	        	}catch(FileNotFoundException e)
	        	{
	        		 e.printStackTrace();
	        	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
	        		FileOutputStream fOut = openFileOutput("User:" + me.getUsername() + ".txt", MODE_WORLD_READABLE);
	        		OutputStreamWriter osw = new OutputStreamWriter(fOut);
	        		BufferedWriter hh = new BufferedWriter(osw);
	        		hh.write("< " + me.getUsername() + " " + me.getPassword() + " > ");
	        		hh.newLine();
	        		for(int i = 0; i < me.postedChallenges.size(); i++)
	        		{
	        			hh.write("<");
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).getId()+"");
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).getTitle());
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).getDescription());
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).getPictures());
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).getPrivacy());
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).isSponsored()+"");
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).isCompleted()+"");
		        		hh.newLine();
		        		hh.write(me.postedChallenges.get(i).getCreatedBy());
		        		hh.newLine();
	        		}
	        		hh.write(">");
	        		
	        		hh.close();
	        		//user = new User(Username.getText().toString(), Password.getText().toString());
	        	}catch(FileNotFoundException e)
	        	{
	        		 e.printStackTrace();
	        	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Your Challenge has been created!", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	
	/* Class adapts to the listview_item */
	private class ChallengeListAdapter extends ArrayAdapter<Challenge> {
		public ChallengeListAdapter() {
			super (CreateAChallengeActivity.this, R.layout.listview_item, Challenges);
		}
		
		
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// If the view is not already inflated then inflates the view
			if (view == null) {
				view = getLayoutInflater().inflate(R.layout.listview_item,  parent, false);
			}
			
			// Create a challenge
			Challenge currentChallenge = Challenges.get(position);
			
			TextView title = (TextView) view.findViewById(R.id.textChallengeName);
			title.setText(currentChallenge.getTitle());
			TextView description = (TextView) view.findViewById(R.id.textChallengeDescription);
			description.setText(currentChallenge.getDescription());
			TextView category = (TextView) view.findViewById(R.id.textChallengeCategory);
			category.setText(currentChallenge.getCategory());
			TextView privacy = (TextView) view.findViewById(R.id.textChallengePrivacy);
			privacy.setText(currentChallenge.getPrivacy());
			
			return view;
		}
	}                   
	
	/* Adds a new challenge
	 * 
	 * @param name is the challenge name
	 * @param description is the challenge description
	 * @param category is the challenge category
	 * @param privacy is the challenge privacy
	 */
//	private void addChallenge(String category, String title, String description, 
//			String pictures, String privacy, String sponsored) {
//		Challenges.add(new Challenge(category, title, description, 
//				pictures, privacy, sponsored));
//	}
	
	/* Populates the challenge list with challenge info
	 * 
	 */
	private void populateChallengesList() {
		ArrayAdapter<Challenge> adapter = new ChallengeListAdapter();
		challengeListView.setAdapter(adapter);
	}
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_a_challenge_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
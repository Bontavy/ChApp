/* This class is the activity for allowing users to create a challenge with info such as the challenge name, description, category, and privacy.
 * The challenge info will then be displayed on a page called "Challenge List" for users to see all the challenges that they have created.
 * 
 * @author: Bontavy Vorng
 * @version: v4
 * @since: v1
 * 
 */

package com.example.challengeapp;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.*;


public class CreateAChallengeActivity extends ActionBarActivity {
	
	EditText nameText, descriptionText, categoryText, privacyText; // For the input from the user from the text fields
	
	List<Challenge> Challenges = new ArrayList<Challenge>();		// An array list for challenges
	ListView challengeListView;										// A ListView for the list of challenges in the "Challenges List" page
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_challenge_activity);
        
        // Sets the input from the text fields to their corresponding EditText variables
        nameText = (EditText) findViewById(R.id.challengeName);
        descriptionText = (EditText) findViewById(R.id.challengeDescription);
        categoryText = (EditText) findViewById(R.id.challengeCategory);
        privacyText = (EditText) findViewById(R.id.challengePrivacy);
        // The list view where challenges will be populated
        challengeListView = (ListView) findViewById(R.id.challengesListView);
        
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
				// Adds a new challenge and populates the challenge list with it
				addChallenge(nameText.getText().toString(), descriptionText.getText().toString(), categoryText.getText().toString(), privacyText.getText().toString());
				populateChallengesList();
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
			
			TextView name = (TextView) view.findViewById(R.id.textChallengeName);
			name.setText(currentChallenge.getName());
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
	private void addChallenge(String name, String description, String category, String privacy) {
		//Challenges.add(new Challenge(name, description, category, privacy));
	}
	
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
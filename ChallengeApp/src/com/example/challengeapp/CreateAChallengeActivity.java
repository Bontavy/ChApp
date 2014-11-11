package com.example.challengeapp;


import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class CreateAChallengeActivity extends ActionBarActivity {
	
	EditText nameText, descriptionText, categoryText, privacyText;
	
	List<Challenge> Challenges = new ArrayList<Challenge>();
	ListView challengeListView;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_challenge_activity);
        
        nameText = (EditText) findViewById(R.id.challengeName);
        descriptionText = (EditText) findViewById(R.id.challengeDescription);
        categoryText = (EditText) findViewById(R.id.challengeCategory);
        privacyText = (EditText) findViewById(R.id.challengePrivacy);
        challengeListView = (ListView) findViewById(R.id.challengesListView);
        
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
        
        Button createChallengeButton = (Button) findViewById(R.id.createChallengeButton);
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
	
	
	/* Class adapters to the challenge list page */
	private class ChallengeListAdapter extends ArrayAdapter<Challenge> {
		public ChallengeListAdapter() {
			super (CreateAChallengeActivity.this, R.layout.challenges_page, Challenges);
		}
		
		
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// If the view is not already inflated then inflates the view
			if (view == null) {
				view = getLayoutInflater().inflate(R.layout.challenges_page,  parent, false);
			}
			
			// Create a challenge
			Challenge currentChallenge = Challenges.get(position);
			
			// Gets the input from the user and assigns them to the corresponding texts in the view
			TextView name = nameText;
			name.setText(currentChallenge.getName());
			TextView description = descriptionText;
			description.setText(currentChallenge.getDescription());
			TextView category = categoryText;
			category.setText(currentChallenge.getCategory());
			TextView privacy = privacyText;
			privacy.setText(currentChallenge.getPrivacy());
			
			return view;
		}
	}                   
	
	/* Adds a new challenge
	 * 
	 * @param name the challenge name
	 * @param description the challenge description
	 * @param category the challenge category
	 * @param privacy the challenge privacy
	 */
	private void addChallenge(String name, String description, String category, String privacy) {
		Challenges.add(new Challenge(name, description, category, privacy));
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
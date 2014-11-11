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
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        
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
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Your Challenge has been created!", Toast.LENGTH_SHORT).show();
			}
		});
        
        
        
        
        challengeListView = (ListView) findViewById(R.id.challengeListView);
    }
	
	
	/*private class ChallengeListAdapter extends ArrayAdapter<Challenge> {
		public ChallengeListAdapter() {
			super (CreateAChallengeActivity.this, R.layout.challenges_page, Challenges);
		}
		
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			if (view == null) {
				view = getLayoutInflater().inflate(R.layout.challenges_page,  parent, false);
			}
			
			Challenge currentChallenge = Challenges.get(position);
			
			TextView name = (TextView) view.findViewById(R.id.challengeName);
			name.setText(currentChallenge.getName());
			TextView description = (TextView) view.findViewById(R.id.challengeDescription);
			description.setText(currentChallenge.getDescription());
			TextView category = (TextView) view.findViewById(R.id.challengeCategory);
			category.setText(currentChallenge.getCategory());
			TextView privacy = (TextView) view.findViewById(R.id.challengePrivacy);
			privacy.setText(currentChallenge.getPrivacy());
			
			return view;
		}
	}*/                   
	
	
	/*private void addChallenge(String name, String description, String category, String privacy) {
		Challenges.add(new Challenge(name, description, category, privacy));
	}
	private void populateChallengePage() {
		for(int i = 0; i < 10; i++)
		{
			Challenge chall = new Challenge("ChalleneName"+i, "ChalleneName"+i,"ChalleneName"+i,"ChalleneName"+i );
			Challenges.add(chall);
		}
		ArrayAdapter<Challenge> adapter = new ChallengeListAdapter();
		challengeListView.setAdapter(adapter);
	}*/
	
	
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
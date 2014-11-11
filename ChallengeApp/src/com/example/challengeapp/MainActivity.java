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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {

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
    	Intent intent = new Intent(MainActivity.this, CreateAChallengeActivity.class);
    	startActivity(intent);
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

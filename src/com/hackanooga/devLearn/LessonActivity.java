package com.hackanooga.devLearn;

import com.hackanooga.devLearn.lessons.*;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class LessonActivity extends Activity {
	public static int score = 0;
	public static int lives = 3;
	public static int lesson_page = 0;
	public static int total_lesson_pages = 10;
	private String lesson_text;
	private String language_text;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_lesson);
	    lesson_text = this.getIntent().getStringExtra(LessonListActivity.lesson_text);
	    language_text = this.getIntent().getStringExtra(LanguageListActivity.language_text);
	    
	    // Set Text for Title
	    TextView text = (TextView) findViewById(R.id.textTitle);
	    text.setText(language_text + ": " + lesson_text);
	    
	    updateFragment();
	
	}
	
	public void updateFragment() {
		lesson_page++;
	    // Setup Fragmentor
	    FragmentManager fragmentManager = getFragmentManager();
	    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	    fragmentManager.beginTransaction();
	    // Lessons
	    
	    if(language_text.equals("JavaScript")) {
	    	if (lesson_text.equals("Basics")) {
	    		// Where our demo is taking place
	    		if(lesson_page == 1){
    				Log.i("Page", "Page 1");
    				FragmentJavascriptBasicPage1 fragment;
    	    		fragment = new FragmentJavascriptBasicPage1();
    	    		fragmentTransaction.replace(R.id.fragment_container, fragment);
	    		} else if (lesson_page == 2) {
    				Log.i("Page", "Page 2");
    				FragmentJavascriptBasicPage2 fragment;
    				fragment = new FragmentJavascriptBasicPage2();
    				fragmentTransaction.replace(R.id.fragment_container, fragment);
	    		} else if (lesson_page == 3) {
	    			Log.i("Page", "Page 3");
	    			FragmentJavascriptBasicPage3 fragment;
	    			fragment = new FragmentJavascriptBasicPage3();
	    			fragmentTransaction.replace(R.id.fragment_container, fragment);
	    		}
	    		
	    	} else {
	    		// You have taken a wrong turn
	    		Log.i("Here", "We shouldn't be here :( 1");
	    		FragmentJavascriptBasicPage1 fragment;
	    		fragment = new FragmentJavascriptBasicPage1();
	    	}
	    } else {
	    	// You have taken a wrong turn
	    	Log.i("Here", "We shouldn't be here :( 2");
	    	FragmentJavascriptBasicPage1 fragment;
	    	fragment = new FragmentJavascriptBasicPage1();
	    	
	    }
	    fragmentTransaction.commit(); 

		
	}
	
	public void updateProgressBar(int percentage) {
		// Update Progress bar
	}

}

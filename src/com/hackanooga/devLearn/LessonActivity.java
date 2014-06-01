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
	private String packagename;
	private static ImageView[] lives_icons;
	private static int lost_heart;
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
	    
	    // Setup Lives
	    lives_icons = new ImageView[lives];
	    lives_icons[0] = (ImageView) findViewById(R.id.imageViewHeart3);
	    lives_icons[1] = (ImageView) findViewById(R.id.imageViewHeart2);
	    lives_icons[2] = (ImageView) findViewById(R.id.imageViewHeart1);
	    packagename = this.getPackageName();
	    lost_heart = getResources().getIdentifier(packagename + ":/drawable/" + R.drawable.noheart, null, null);
	    
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
	
	public int getScore() {
		return score;
	}
	
	static public boolean liveLost() {
		if(lives == 0) {
			// Lesson Over/ Restart
			return false;
		} else {
			if (lives == 3) {
				lives_icons[0].setImageResource(lost_heart);
			} else if ( lives == 2) {
				lives_icons[1].setImageResource(lost_heart);
			} else if (lives == 1) {
				lives_icons[2].setImageResource(lost_heart);
				
			}
			lives--;
			return true;
		}
	}

}

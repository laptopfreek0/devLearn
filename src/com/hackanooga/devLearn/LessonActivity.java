package com.hackanooga.devLearn;

import android.app.Activity;
import android.os.Bundle;

public class LessonActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_lesson);
	    String lesson_text = this.getIntent().getStringExtra(LessonListActivity.lesson_text);
	    String language_text = this.getIntent().getStringExtra(LanguageListActivity.language_text);
	}

}

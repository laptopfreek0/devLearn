package com.hackanooga.devLearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LessonListActivity  extends Activity {
	
	public static String lesson_id = "lesson_id";
	public static String lesson_text = "lesson_text";
	
	private String[] lessonList;
	private String language_text = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_lesson_list);
	    
	    final int lesson_array_id = this.getIntent().getIntExtra(LanguageListActivity.language_id, -1);
	    language_text = this.getIntent().getStringExtra(LanguageListActivity.language_text);
	    TextView tv = (TextView) findViewById(R.id.lesson_textView);
	    tv.setText(tv.getText() + " " + language_text);
	    
	    lessonList = this.getResources().getStringArray(lesson_array_id);
	    ListView lv = (ListView) findViewById(R.id.lesson_list_view);
	    lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lessonList));
	    lv.setOnItemClickListener(new OnItemClickListener() {
		    @Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		    	Intent intent = new Intent(LessonListActivity.this, LessonActivity.class);
	    		intent.putExtra(lesson_text, lessonList[arg2]);
	    		intent.putExtra(LanguageListActivity.language_text, language_text);
		    	startActivity(intent);
			 }
	    });
	}
}

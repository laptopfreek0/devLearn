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
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_lesson_list);
	    
	    int lesson_array_id = this.getIntent().getIntExtra(LanguageListActivity.language_id, -1);
	    String language_text = this.getIntent().getStringExtra(LanguageListActivity.language_text);
	    TextView tv = (TextView) findViewById(R.id.textView1);
	    tv.setText(tv.getText() + " " + language_text);
	    
	    String[] LanguageList = this.getResources().getStringArray(lesson_array_id);
	    ListView lv = (ListView) findViewById(R.id.lesson_list_view);
	    lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, LanguageList));
	    lv.setOnItemClickListener(new OnItemClickListener() {
		    @Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
/*				Intent intent = new Intent(LessonListActivity.this, LessonActivity.class);
				switch (arg2) {
					case 0:
					default:
						//html
						intent.putExtra(language_id, R.array.html_lessons);
						break;
					case 1:
						// css
						intent.putExtra(language_id, R.array.css_lessons);
						break;
					case 2:
						// javascript
						intent.putExtra(language_id, R.array.javascript_lessons);
						break;
					case 3:
						// php
						intent.putExtra(language_id, R.array.php_lessons);
						break;
				}
				startActivity(intent);*/
			 }
	    });
	}
}

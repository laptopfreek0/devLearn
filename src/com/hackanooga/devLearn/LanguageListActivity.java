package com.hackanooga.devLearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LanguageListActivity  extends Activity {
	
	public static String language_id = "language_id";
	public static String language_text = "language_text";
	String[] languageList;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_language_list);
	    
	    languageList= this.getResources().getStringArray(R.array.languages);
	    ListView lv = (ListView) findViewById(R.id.language_list_view);
	    lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, languageList));
	    lv.setOnItemClickListener(new OnItemClickListener() {
		    @Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(LanguageListActivity.this, LessonListActivity.class);
				intent.putExtra(language_text, languageList[arg2]);
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
				startActivity(intent);
			 }
	    });
	}
}

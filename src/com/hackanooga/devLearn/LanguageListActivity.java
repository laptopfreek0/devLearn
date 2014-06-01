package com.hackanooga.devLearn;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LanguageListActivity  extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_language_list);
	    
	    String[] LanguageList = this.getResources().getStringArray(R.array.languages);
	    ListView lv = (ListView) findViewById(R.id.language_list_view);
	    lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, LanguageList));
	    lv.setOnItemClickListener(new OnItemClickListener() {
		    @Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Context context = getApplicationContext();
				CharSequence text = String.valueOf(arg2);
				int duration = Toast.LENGTH_SHORT;
		
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
			 }
	    });
	}
}

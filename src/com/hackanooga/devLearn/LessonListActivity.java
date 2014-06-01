package com.hackanooga.devLearn;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LessonListActivity  extends Activity {
	
	public ListView lv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  String[] myList = new String[] {"Hello","World","Foo","Bar", "Life", "Is", "Good", "Zup", "zup zup", "zup zup zup"};
	        lv = new ListView(this);
	        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList));
	        setContentView(lv);
	        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Context context = getApplicationContext();
				CharSequence text = String.valueOf(arg2);
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				//
				
			}
	     });
	}

}

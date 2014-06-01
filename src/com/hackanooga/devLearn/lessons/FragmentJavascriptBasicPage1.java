package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.R;
import com.hackanooga.devLearn.objects.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;

public class FragmentJavascriptBasicPage1 extends FragmentBasicClass {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_javascript_basic_page_1, container, false);
		Button btn = (Button) view.findViewById(R.id.btn_continue);
		btn.setOnClickListener(nextListener);
		
		// Setup Lesson
		Lesson lesson = new Lesson();
		lesson.setIntroduction("<script>\nThe Script tag is used tell the browser to execute the following javascript code.");
		lesson.setHtmlSource("<html><body><script>document.write('Hello World!');</script></body</html>");
		lesson.setHtmlTruncatedSource("<html>\n</html>");
		
		createLesson(view, lesson);
		
		
		
		return view;
	}

}

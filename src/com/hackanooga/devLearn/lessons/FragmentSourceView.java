package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.LessonActivity;
import com.hackanooga.devLearn.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentSourceView extends FragmentBasicClass {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_source, container, false);
		
		TextView source = (TextView) view.findViewById(R.id.source_textview);
		if(LessonActivity.lesson_page == 1) {
			// Page 1
			source.setText(FragmentJavascriptBasicPage1.lesson.getHtmlTruncatedSource());
		} else if (LessonActivity.lesson_page == 3) {
			// Page 3
			source.setText(FragmentJavascriptBasicPage3.lesson.getHtmlTruncatedSource());
		}  
		
		
		return view;
	}

}

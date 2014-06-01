package com.hackanooga.devLearn.lessons;

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
		source.setText(FragmentJavascriptBasicPage1.lesson.getHtmlTruncatedSource());
		
		return view;
	}

}

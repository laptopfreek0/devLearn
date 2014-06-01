package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentJavascriptBasicPage1 extends FragmentBasicClass {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_javascript_basic_page_1, container, false);
		Button btn = (Button) view.findViewById(R.id.btn_continue);
		btn.setOnClickListener(nextListener);
		return view;
	}

}

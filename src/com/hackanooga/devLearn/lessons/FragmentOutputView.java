package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class FragmentOutputView extends FragmentBasicClass {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_output, container, false);
		
		WebView output = (WebView) view.findViewById(R.id.output_webview);
		output.getSettings().setJavaScriptEnabled(true);
		output.loadData(FragmentJavascriptBasicPage1.lesson.getHtmlSource(), "text/html", "utf-8");

		return view;
	}

}

package com.hackanooga.devLearn.lessons;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.hackanooga.devLearn.R;
import com.hackanooga.devLearn.objects.Quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentJavascriptBasicPage2 extends FragmentBasicClass {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_javascript_basic_page_2, container, false);
		Button btn = (Button) view.findViewById(R.id.btn_continue);
		btn.setOnClickListener(nextListener);
		
		ArrayList<NameValuePair> code = new ArrayList<NameValuePair>();
		code.add(new BasicNameValuePair("/script", "</script>"));
		code.add(new BasicNameValuePair("code", "document.write('goodbye world');"));
		code.add(new BasicNameValuePair("/body", "</body>"));
		code.add(new BasicNameValuePair("body", "<body>"));
		code.add(new BasicNameValuePair("script", "<script>"));
		code.add(new BasicNameValuePair("/html", "</html>"));
		code.add(new BasicNameValuePair("html", "<html>"));
		
		
		ArrayList<String> answer = new ArrayList<String>();
		answer.add("html");
		answer.add("body");
		answer.add("script");
		answer.add("code");
		answer.add("/script");
		answer.add("/body");
		answer.add("/html");
		
		Quiz quiz = new Quiz();
		quiz.setPoints(20);
		quiz.setInstructions("Code the following script tag so that goodbye world will display in the browser.");
		quiz.setCode(code);
		quiz.setAnswer(answer);
		
		createQuiz(view, quiz);
		
		return view;
	}

}

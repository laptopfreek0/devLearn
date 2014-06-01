package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.R;
import com.hackanooga.devLearn.objects.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;

public class FragmentOutputView extends FragmentBasicClass {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_output, container, false);

		return view;
	}

}

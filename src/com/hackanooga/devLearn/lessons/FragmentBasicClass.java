package com.hackanooga.devLearn.lessons;

import org.apache.http.NameValuePair;

import com.hackanooga.devLearn.LessonActivity;
import com.hackanooga.devLearn.R;
import com.hackanooga.devLearn.objects.Lesson;
import com.hackanooga.devLearn.objects.Quiz;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentBasicClass extends Fragment{
	
	private Lesson lesson;
	private Quiz quiz;
	
    public OnClickListener nextListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			advanceLesson();
			//updateScore(10);
			//looseLife();
/*			TextView pointView = (TextView) ((ViewGroup)getView().getParent()).findViewById(R.id.textPoints); 
			pointView.setText("YOLO");*/
/*			LessonActivity.liveLost();
			LessonActivity.addScore(10);*/
			
		}
    
    };
    
    public void createQuiz(View view, Quiz quiz) {
    	this.quiz = quiz;
    	TextView tv = (TextView) view.findViewById(R.id.quiz_textView);
    	tv.setText(quiz.getPoints() + " Points - " + quiz.getInstructions());
    	
    	LinearLayout layout = (LinearLayout)view.findViewById(R.id.quiz_code);
    	
    	Button btn = (Button) view.findViewById(R.id.btn_continue);
    	btn.setOnClickListener(quizCheckHandler);
    	
    	for (int i = 0; i < quiz.getAnswer().size(); i++) {
    		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2);
    		
    		View blank = new View(view.getContext());
    		blank.setBackgroundColor(Color.BLACK);
    		layout.addView(blank, params);
    		
    		final ViewGroup.MarginLayoutParams lpt = (ViewGroup.MarginLayoutParams)blank.getLayoutParams();
    		lpt.setMargins(40,80,40,lpt.bottomMargin);
    	}
    	
    	int i = 0;
    	for (NameValuePair code : quiz.getCode()) {
    		if (i < 3) {
    			layout = (LinearLayout)view.findViewById(R.id.quiz_select_line1);
    		} else {
    			layout = (LinearLayout)view.findViewById(R.id.quiz_select_line2);
    		}
    		
    		Button button = new Button(view.getContext());
    		button.setTextSize(10);
    		button.setText(code.getValue());
    		button.setTag(code.getName());
    		button.setOnClickListener(codeClickHandler);
    		
    		layout.addView(button);
    		
    		i++;
    	}
    }
    
    public OnClickListener quizCheckHandler = new OnClickListener() {
    	@Override
    	public void onClick(View v) {
    		((Button) v).setText("Continue");
    	}
    };
    
    public OnClickListener codeClickHandler = new OnClickListener() {
    	
    	@Override
    	public void onClick(View v) {
    		Button code = (Button)v;
    		code.setVisibility(View.INVISIBLE);
    		String html = code.getText().toString();
    		String key = (String)code.getTag();
    		
    		View layout = ((RelativeLayout)v.getParent().getParent()).findViewById(R.id.quiz_code);
    		for (int i = 0; i < ((ViewGroup) layout).getChildCount(); i++) {
    			View view = ((ViewGroup) layout).getChildAt(i);
    			
    			if (view instanceof Button) {
    				// Already populated
    				
    			} else {
    	    		Button button = new Button(view.getContext());
    	    		button.setTextSize(10);
    	    		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80);
    	    		button.setLayoutParams(params);
    	    		button.setText(html);
    	    		button.setTag(key);
    				((ViewGroup) layout).addView(button, i);
    				((ViewGroup) layout).removeView(view);
    				break;
    				
    			}
    		}
    		//TODO: Loop through the blank layouts
    	}
    };
    
    public Lesson createLesson(View view, Lesson lesson) {
    	this.lesson = lesson;
    	TextView tv = (TextView) view.findViewById(R.id.lesson_textView);
    	tv.setText(lesson.getIntroduction());
    	
    	Switch sw = (Switch) view.findViewById(R.id.source_switch);
    	sw.setOnCheckedChangeListener(switch_listener);
    	
    	// Setup Source for first view
    	source_setup();
    	
    	return lesson;
    }
    
    private void source_setup() {
	    FragmentManager fragmentManager = getFragmentManager();
	    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	    fragmentManager.beginTransaction();
	    
		FragmentSourceView fragment = new FragmentSourceView();
		fragmentTransaction.replace(R.id.source_fragment_container, fragment);
		fragmentTransaction.commit(); 
    }
    
    public OnCheckedChangeListener switch_listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if(isChecked) {
				// Output
			    FragmentManager fragmentManager = getFragmentManager();
			    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			    fragmentManager.beginTransaction();
			    
				FragmentOutputView fragment = new FragmentOutputView();
				fragmentTransaction.replace(R.id.source_fragment_container, fragment);
				fragmentTransaction.commit(); 
			} else {
				// Source
				source_setup();
			}
			
		}
    	
    };
    
    public void advanceLesson() {
    	((LessonActivity)getActivity()).updateFragment();
		ProgressBar pb = (ProgressBar) ((LessonActivity)getActivity()).findViewById(R.id.lesson_progress);
		int progress = (int)(((double)LessonActivity.lesson_page - 1) / (double)LessonActivity.total_lesson_pages * 100);
		Log.i("Progress", String.valueOf(progress));
		pb.setProgress(progress);
    }
    
    public void updateScore(int addScore) {
    	LessonActivity.score += addScore;
		TextView tv = (TextView) ((LessonActivity)getActivity()).findViewById(R.id.textPoints);
		tv.setText(String.valueOf(LessonActivity.score));
    }
    
    public void looseLife() {
    	if(LessonActivity.lives == 3) {
    		LessonActivity.lives--;
    		ImageView iv = (ImageView) ((LessonActivity)getActivity()).findViewById(R.id.imageViewHeart3);
    		iv.setImageResource(R.drawable.noheart);
    		
    	} else if (LessonActivity.lives == 2) {
    		LessonActivity.lives--;
    		ImageView iv = (ImageView) ((LessonActivity)getActivity()).findViewById(R.id.imageViewHeart2);
    		iv.setImageResource(R.drawable.noheart);
    		
    	} else if (LessonActivity.lives == 1) {
    		LessonActivity.lives--;
    		ImageView iv = (ImageView) ((LessonActivity)getActivity()).findViewById(R.id.imageViewHeart1);
    		iv.setImageResource(R.drawable.noheart);
    		
    	} else if (LessonActivity.lives == 0) {
    		// Start Lesson Over
    		
    	}
    	
    }

}

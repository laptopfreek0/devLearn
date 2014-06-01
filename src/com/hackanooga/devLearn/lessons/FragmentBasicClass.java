package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.LessonActivity;
import com.hackanooga.devLearn.R;
import com.hackanooga.devLearn.objects.Lesson;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentBasicClass extends Fragment{
	
	private Lesson lesson;
	
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

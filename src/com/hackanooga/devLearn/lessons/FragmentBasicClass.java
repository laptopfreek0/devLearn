package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.LessonActivity;
import com.hackanooga.devLearn.R;
import com.hackanooga.devLearn.objects.Lesson;

import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentBasicClass extends Fragment{
	
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
    	TextView tv = (TextView) view.findViewById(R.id.lesson_textView);
    	tv.setText(lesson.getIntroduction());
    	
    	return lesson;
    }
    
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

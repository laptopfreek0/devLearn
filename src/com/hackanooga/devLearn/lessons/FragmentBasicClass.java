package com.hackanooga.devLearn.lessons;

import com.hackanooga.devLearn.LessonActivity;
import com.hackanooga.devLearn.R;

import android.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentBasicClass extends Fragment{
	
    public OnClickListener nextListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(getActivity(),"YOLO", 
	                Toast.LENGTH_SHORT).show();
			//((LessonActivity)getActivity()).updateFragment();
			updateScore(10);
/*			TextView pointView = (TextView) ((ViewGroup)getView().getParent()).findViewById(R.id.textPoints); 
			pointView.setText("YOLO");*/
/*			LessonActivity.liveLost();
			LessonActivity.addScore(10);*/
			
		}
    
    };
    
    public void updateScore(int addScore) {
    	LessonActivity.score += addScore;
		TextView tv = (TextView) ((LessonActivity)getActivity()).findViewById(R.id.textPoints);
		tv.setText("YOLO");
    }

}

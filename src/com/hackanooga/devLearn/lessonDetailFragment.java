package com.hackanooga.devLearn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackanooga.devLearn.objects.LanguageContent;

/**
 * A fragment representing a single lesson detail screen. This fragment is
 * either contained in a {@link lessonListActivity} in two-pane mode (on
 * tablets) or a {@link lessonDetailActivity} on handsets.
 */
public class lessonDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private LanguageContent.LanguageItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public lessonDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = LanguageContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_lesson_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.lesson_detail))
					.setText(mItem.content);
			if (mItem.array_name == "html_lessons") {
				this.getResources().getStringArray(R.array.html_lessons);
			} else if (mItem.array_name == "css_lessons") {
				this.getResources().getStringArray(R.array.css_lessons);
			} else if (mItem.array_name == "javascript_lessons") {
				this.getResources().getStringArray(R.array.javascript_lessons);
			} else if (mItem.array_name == "php_lessons") {
				this.getResources().getStringArray(R.array.php_lessons);
			} else {
				// Error
				Log.e("Lesson Details", "You Shouldn't be here");
			}
			
		}

		return rootView;
	}
}

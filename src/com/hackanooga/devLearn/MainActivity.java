package com.hackanooga.devLearn;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ProgressBar progress;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        progress = (ProgressBar)findViewById(R.id.tutorial_progress);

        

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(pageChangeListener);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public OnPageChangeListener pageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
				case 0:
					progress.setProgress(0);
					break;
				case 1:
					progress.setProgress(33);
					break;
				case 2:
					progress.setProgress(66);
					break;
				case 3:
					com.google.android.gms.common.SignInButton signInButton = 
						(com.google.android.gms.common.SignInButton) findViewById(R.id.google_sign_in_button);
					signInButton.setOnClickListener(plusButtonListener);
					progress.setProgress(100);
					break;
			}
			
			
		}
    	
    };
    
    public OnClickListener plusButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this,"YOLO", Toast.LENGTH_SHORT).show();
			
		}
    	
    };
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.tutorial_title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.tutorial_title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.tutorial_title_section3).toUpperCase(l);
                case 3:
                	return getString(R.string.tutorial_title_section4).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	int tutorial_page = getArguments().getInt(ARG_SECTION_NUMBER);
        	View rootView;
        	switch (tutorial_page) {
	    		case 1:
	    		default:
	    			rootView = inflater.inflate(R.layout.fragment_tutorial_page_1, container, false);
    			break;
        		case 2:
        			rootView = inflater.inflate(R.layout.fragment_tutorial_page_2, container, false);
        			break;
        		case 3:
        			rootView = inflater.inflate(R.layout.fragment_tutorial_page_3, container, false);
        			break;
        		case 4:
        			rootView = inflater.inflate(R.layout.fragment_tutorial_page_4, container, false);
        			break;
        	}
            return rootView;
        }
    }

}

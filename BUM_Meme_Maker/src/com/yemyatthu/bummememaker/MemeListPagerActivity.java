package com.yemyatthu.bummememaker;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class MemeListPagerActivity extends FragmentActivity {
	
	private ViewPager mViewPager;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.listPager);
		setContentView(mViewPager);
		
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				mViewPager.setCurrentItem(tab.getPosition());
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};
		
		actionBar.addTab(actionBar.newTab().setText(R.string.meme_list_title).setTabListener(tabListener));
		actionBar.addTab(actionBar.newTab().setText(R.string.myanmar_meme_title).setTabListener(tabListener));
		actionBar.addTab(actionBar.newTab().setText(R.string.favorite_meme_title).setTabListener(tabListener));
		
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentPagerAdapter(fm){
			
			@Override
			public Fragment getItem(int position) {
				// TODO Auto-generated method stub
				
				return MemeListFragment.getNewInstance(position);
				
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 3;
			}
			
			
		});
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
			
			public void onPageSelected(int position) {
                // When swiping between pages, select the
                // corresponding tab.
                getActionBar().setSelectedNavigationItem(position);
            }

			
		});
		
	}
	
	

}
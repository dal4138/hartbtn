package com.example.iamas.travelfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThemeActivity extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener, ViewPager.OnPageChangeListener {

    private FragmentStatePagerAdapter fragmentStatePagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    boolean isDragged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        //뷰페이저 설정
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);

        fragmentStatePagerAdapter = new ThemeViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(fragmentStatePagerAdapter);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                tabLayout.setTabsFromPagerAdapter(fragmentStatePagerAdapter);
                tabLayout.addOnTabSelectedListener(ThemeActivity.this);
            }
        });

        viewPager.addOnPageChangeListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentStatePagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if( !isDragged ){
            viewPager.setCurrentItem(tab.getPosition());
        }
        isDragged = false;
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        if( i == ViewPager.SCROLL_STATE_DRAGGING)
            isDragged = true;
    }
}

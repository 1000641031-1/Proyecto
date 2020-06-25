package com.example.nas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.nas.controlador.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class home1 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2, tab3;
    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home1 );

        tabLayout = findViewById( R.id.tablayout );
        viewPager = findViewById( R.id.viewpager );

        tab1 = findViewById( R.id.tabsolicitudes );
        tab2 = findViewById( R.id.tabservicios );
        tab3= findViewById( R.id.tabreserva);
            pagerAdapter = new PagerController( getSupportFragmentManager(),tabLayout.getTabCount() );
            viewPager.setAdapter(pagerAdapter  );
            tabLayout.setOnTabSelectedListener( new TabLayout.BaseOnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem( tab.getPosition() );
                    if (tab.getPosition() == 0) {
                        pagerAdapter.notifyDataSetChanged();
                    }
                    if (tab.getPosition() == 1) {
                        pagerAdapter.notifyDataSetChanged();
                    }
                    if (tab.getPosition() == 2) {
                        pagerAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            } );
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener( tabLayout ));
        }


    }




/**
 * Application built to help people finding the most important touristic attractions in
 * Czech city Brno. Tourist attractions are divided into 4 logical categories.
 * The app is controlled by swipe gestures or tab clicks. When an option from list
 * is chosen, it's position is then showed via Google Maps.
 */
package com.example.vojmi.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setting the content of the activity to use the activity_main layout.
        setContentView(R.layout.activity_main);
        // Finding the view pager according to resource ID viewpaper.
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Creating an adapter for displaying particular places.
        final ADPTR_Categories adapter = new ADPTR_Categories(this, getSupportFragmentManager());
        // Adjusting the adapter to the view pager.
        viewPager.setAdapter(adapter);
        // Finding the tab layout that show tabs.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        // Connecting the tab layout with the view pager.
        tabLayout.setupWithViewPager(viewPager);
    }
}




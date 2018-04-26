package com.example.vojmi.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link ADPTR_Categories} is a {@link FragmentPagerAdapter} providing the layout for list items based on resources from Place.class.*
 */
public class ADPTR_Categories extends FragmentPagerAdapter {
    /**
     * Declaring context of the app.
     */
    private Context mContext;

    /**
     * Creating a new object {@link ADPTR_Categories}.
     *
     * @param context represents the context of the app.
     * @param fm      represents the fragment manager that keeps the state of fragment from
     *                swipe to swipe.
     */
    public ADPTR_Categories(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * According to page number, the {@link Fragment} method displays the appropriate fragment.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FRG_Architecture();
            case 1:
                return new FRG_NatMonum();
            case 2:
                return new FRG_Statues();
            case 3:
                return new FRG_Theatres();
        }
        return getItem(position);
    }

    /**
     * Getting the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.cat_1);
            case 1:
                return mContext.getString(R.string.cat_2);
            case 2:
                return mContext.getString(R.string.cat_3);
            case 3:
                return mContext.getString(R.string.cat_4);
        }
        return getPageTitle(position);
    }
}

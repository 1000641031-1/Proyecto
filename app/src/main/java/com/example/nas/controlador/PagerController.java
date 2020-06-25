package com.example.nas.controlador;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerController extends FragmentPagerAdapter {
    int numoftabs;

    public PagerController(FragmentManager fm, int numoftabs) {
        super( fm );
        this.numoftabs = numoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new soli();

            case 1:
                return new servi();

            case 2:
                return new reser();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}


package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int num0;

    public PagerAdapter(FragmentManager fm,int num0 ){
        super(fm);
        this.num0 = num0;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return num0;
    }
}

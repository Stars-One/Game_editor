package com.wan.gameeditor1.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xen on 2018/2/3 0003.
 */

public class MyfragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mlist;
    private FragmentManager manager;
    public MyfragmentAdapter(FragmentManager fm, List<Fragment> mlist) {
        super(fm);
        this.mlist = mlist;
        manager=fm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mlist.get(position);

        return fragment;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}

package com.wan.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xen on 2018/2/3 0003.
 */

public class MyfragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mlist;

    public MyfragmentAdapter(FragmentManager fm, List<Fragment> mlist) {
        super(fm);
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}

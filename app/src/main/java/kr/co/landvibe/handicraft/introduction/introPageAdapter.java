package kr.co.landvibe.handicraft.introduction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import kr.co.landvibe.handicraft.directions.DirectionsFragment;
import kr.co.landvibe.handicraft.furniture.list.FurnitureListFragment;
import kr.co.landvibe.handicraft.preview.PreviewFragment;
import kr.co.landvibe.handicraft.schedule.ScheduleFragment;
import kr.co.landvibe.handicraft.worshop_Info.InformationFragment;

/**
 * Created by tkddm on 2017-08-29.
 */

public class introPageAdapter extends FragmentPagerAdapter{

    private int tabCount;

    public introPageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new InformationFragment();
            case 1:
                return new DirectionsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

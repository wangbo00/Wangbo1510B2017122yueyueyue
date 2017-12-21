package wangbo.bawei.com.wangbo1510b20171221.dingdan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author:Created by Wangbo on 2017/12/21.
 */

public class MyViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment> data;
    public MyViewpagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data=data;

    }
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}

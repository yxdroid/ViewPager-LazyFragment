package net.yxcoding.lazyfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        initViewPager();
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViewPager()
    {
        titleList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            titleList.add("page" + i);
        }
        viewPager.setAdapter(new ViewPagerAdapter());
        viewPager.setCurrentItem(0);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {

        public ViewPagerAdapter()
        {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position)
        {
            return PageFragment.newInstance(titleList.get(position));
        }

        @Override
        public int getCount()
        {
            return titleList.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return titleList.get(position);
        }
    }
}

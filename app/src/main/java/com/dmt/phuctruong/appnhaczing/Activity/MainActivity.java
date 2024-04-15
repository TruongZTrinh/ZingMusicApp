package com.dmt.phuctruong.appnhaczing.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.dmt.phuctruong.appnhaczing.Adapter.MainViewPagerAdapter;
import com.dmt.phuctruong.appnhaczing.Fragment.Fragment_Tim_Kiem;
import com.dmt.phuctruong.appnhaczing.Fragment.Fragment_Trang_Chu;
import com.dmt.phuctruong.appnhaczing.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this);
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(), "Trang Chu");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(), "Tim Kiem");
        viewPager2.setAdapter(mainViewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            // Customize tab titles based on the position if needed
            // tab.setText("Tab " + (position + 1));
            tab.setText(mainViewPagerAdapter.getPageTitle(position));
        }).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
    }

    private void anhxa() {
        tabLayout =findViewById(R.id.myTabLayout);
        viewPager2 = findViewById(R.id.myViewPager);
    }
}
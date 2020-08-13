package com.example.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.mytablayout);
        viewPager=findViewById(R.id.myviewpager);
        viewPager.setAdapter(new myviewpageadapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "selected " +tab.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "un-selected " +tab.getText().toString(),
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "re-selected " +tab.getText().toString(),
                    Toast.LENGTH_SHORT).show();

            }
        });


    }
    //for create fragment pager adapter class
    public class myviewpageadapter extends FragmentPagerAdapter{
        // for giveing tabs titles string array
        String titles[]={"Chats","Status","calls"};

        public myviewpageadapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return  new ChatsFragment();
            }
            if (position==1){
                return new StatusFragment();
            }
            if (position==2){
                return  new CallsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        //import the default getpage title()
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}

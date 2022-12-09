package com.example.networks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Adapter;

import com.android.volley.toolbox.Volley;
import com.example.networks.Fragment.VPAdapter;
import com.example.networks.databinding.ActivityRegistorBinding;
import com.google.android.material.tabs.TabLayout;

public class RegistorActivity extends AppCompatActivity {
    ActivityRegistorBinding binding;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Customer"));
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("ServiesProvider"));
//
//    //    queue= Volley.newRequestQueue(HomeActivity2.this);
//
//        FragmentManager manager=getSupportFragmentManager();
////
////        adapter= (Adapter) new com.example.networks.Fragment.Adapter(manager,getLifecycle());
////        binding.viewPager.setAdapter((RecyclerView.Adapter) adapter);
////
//
//        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                binding.viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
//            }
//        });
    }
}
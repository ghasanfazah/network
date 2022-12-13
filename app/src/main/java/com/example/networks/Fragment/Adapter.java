package com.example.networks.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.AbstractList;

public class Adapter extends FragmentStateAdapter {
    AbstractList<Fragment> fragments;


    public Adapter(FragmentManager manager, Lifecycle lifecycle) {
        super(manager,lifecycle);
    }

    public Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==1){
            return new FragmentCustomer2();
        }
        return new FragmentServiesPrviders();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

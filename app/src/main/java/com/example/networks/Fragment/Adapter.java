package com.example.networks.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.networks.CustomerREGFragment;
import com.example.networks.SerFRGFragment;

public class Adapter extends FragmentStateAdapter {


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
            return new CustomerREGFragment();
        }
        return new SerFRGFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

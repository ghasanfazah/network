package com.example.networks.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapter extends FragmentStateAdapter {

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public VPAdapter(FragmentManager manager, Lifecycle lifecycle) {
        super(manager,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==1){
            return new Fragment();
        }
        return new Fragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

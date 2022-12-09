package com.example.networks.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

public class Producat extends Fragment {
    private int id;
    private String name;

    public Producat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Producat(String name) {
        this.name = name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

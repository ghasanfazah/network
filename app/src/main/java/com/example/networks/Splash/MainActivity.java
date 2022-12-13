package com.example.networks.Splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networks.Activity.HomeActivity2;
import com.example.networks.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent=new Intent(getApplicationContext(), HomeActivity2.class);
        startActivity(intent);
        finish();
    }
}
package com.example.networks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networks.databinding.ActivitySplask3Binding;

public class SplaskActivity3 extends AppCompatActivity {
    ActivitySplask3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplask3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),HomeActivity2.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
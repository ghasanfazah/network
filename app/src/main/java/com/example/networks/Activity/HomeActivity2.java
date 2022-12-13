package com.example.networks.Activity;

import static com.android.volley.Request.Method.POST;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.networks.Fragment.Fragment1;
import com.example.networks.Fragment.Fragment2;
import com.example.networks.Fragment.VPAdapter;
import com.example.networks.databinding.ActivityHome2Binding;
import com.example.networks.databinding.FragmentSplash1Binding;
import com.example.networks.splashFragment1;
import com.example.networks.splashFragment2;
import com.example.networks.splashFragment3;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity2 extends AppCompatActivity implements Fragment1.OnclilkLis ,Fragment1.OnClickSign , Fragment2.OnclilkListener , splashFragment1.Cilck ,splashFragment2.OnclickButton ,splashFragment3.OnclickBtn {
    ActivityHome2Binding binding;


    JsonObjectRequest jsonObjectRequest;
    JSONObject jsonObject;

    RequestQueue queue;
    VPAdapter adapter;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Customer"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("ServiesProvider"));

        queue= Volley.newRequestQueue(HomeActivity2.this);

        FragmentManager manager=getSupportFragmentManager();
        adapter=new VPAdapter(manager,getLifecycle());
        binding.viewPager.setAdapter(adapter);


        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
    }
});

    }
    void put(String email,String password){

        JSONObject jsonObject =new JSONObject();
        try {

            jsonObject.put("email",email);
            jsonObject.put("password",password);
            jsonObjectRequest=new JsonObjectRequest(POST,
                    "https://studentucas.awamr.com/api/auth/login/delivery",
                    jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //رساله اذا نجح
                    try {
                        Toast.makeText(HomeActivity2.this,response.getString("message"), Toast.LENGTH_SHORT).show();

                         if (response.getBoolean("success")==true){
                             Intent intent=new Intent(HomeActivity2.this, HomeActivity.class);
                             startActivity(intent);
                         }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }





                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(HomeActivity2.this, ""+ error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
        queue.add(jsonObjectRequest);

    }

//    @Override
//    public void onclick(String email, String password) {
//
//    }

    @Override
    public void onclickLIS(String email, String password) {
        put(email,password);
    }

    @Override
    public void onclilkListener(String email, String password) {
        put(email,password);
    }

    @Override
    public void onClick() {
        Intent intent =new Intent(this, splashFragment2.class);
       startActivity(intent);
    }

    @Override
    public void Click() {
        Intent intent =new Intent(this, splashFragment3.class);
        startActivity(intent);
    }

    @Override
    public void Cilck() {
        Intent intent =new Intent(this, HomeActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onClickSign() {
        Intent intent =new Intent(this, RegistorActivity.class);
        startActivity(intent);
    }


//    @Override
//    public void clickbutton() {
//        Intent intent =new Intent(this,RegistorActivity.class);
//        startActivity(intent);
//    }




}
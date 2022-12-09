package com.example.networks;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.networks.Fragment.Fragment1;
import com.example.networks.Fragment.Fragment2;
import com.example.networks.Fragment.VPAdapter;
import com.example.networks.databinding.ActivityHome2Binding;
import com.example.networks.databinding.ActivityRegistorBinding;
import com.example.networks.databinding.Fragment1Binding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity2 extends AppCompatActivity {
    ActivityHome2Binding binding;

    JsonObjectRequest jsonObjectRequest;
    JSONObject jsonObject;
    String name;
    int id;
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
put();


    }
    void put(){

      jsonObject=new JSONObject();

        try {
            jsonObject.put("email","");
            jsonObject.put("password","123123");
             jsonObjectRequest=new JsonObjectRequest(POST, "http://studentucas.awamr.com/api/auth/login/delivery", jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        if (response.getBoolean("success")){
                            Toast.makeText(HomeActivity2.this, response.getString("message"), Toast.LENGTH_SHORT).show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
//
//    void get(){
//        StringRequest stringRequest=new StringRequest(GET, "http://studentucas.awamr.com/api/all/works", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    jsonObject=new JSONObject();
//                    JSONArray jsonArray=jsonObject.getJSONArray("data");
//
//
//                    for (int i = 0; i <jsonArray.length() ; i++) {
//                        JSONObject jsonObject2=jsonArray.getJSONObject(i);
//                       name= jsonObject2.getString("name");
//                        id= jsonObject2.getInt("id");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        queue.add(stringRequest);
//    }


}
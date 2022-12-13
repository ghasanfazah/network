package com.example.networks.Fragment;

import static com.android.volley.Request.Method.POST;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.networks.R;
import com.example.networks.databinding.Fragment2Binding;

import org.json.JSONException;
import org.json.JSONObject;


public class Fragment2 extends Fragment {
    Fragment2Binding binding;
    Button button,button3;
    OnclilkListener onclilkListener;
    OnButtonclilkListener onButtonclilkListenerl;


    EditText editText,editText2;

    private static final String ARG_EMAIL = "email";
    private static final String ARG_PASSSWORD = "password";

    private String mEmail;
    private String mpassword;

    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof OnclilkListener) {
            onclilkListener = (OnclilkListener) context;
        } else {
            throw new ClassCastException("implement valid");
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onclilkListener=null;
    }

    public Fragment2() {
        // Required empty public constructor
    }


    public static Fragment1 newInstance(String mEmail, String mpassword) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_EMAIL, mEmail);
        args.putString(ARG_PASSSWORD, mpassword);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEmail = getArguments().getString(ARG_EMAIL);
            mpassword = getArguments().getString(ARG_PASSSWORD);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        button = view.findViewById(R.id.btn_login);


        // TextView textView = view.findViewById(R.id.tv_Have);
        editText=view.findViewById(R.id.eT_Email2);
        editText2=view.findViewById(R.id.eT_Password2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclilkListener.onclilkListener(editText.getText().toString(),editText2.getText().toString());
            }
        });
        button3=view.findViewById(R.id.btn_SignIn_2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onButtonclilkListenerl.OnButtonclilkListener();
            }
        });


        return view;
    }

    public  interface OnclilkListener{
        void onclilkListener(String email, String password);
    }

    public  interface OnButtonclilkListener{
        void OnButtonclilkListener();
    }





}
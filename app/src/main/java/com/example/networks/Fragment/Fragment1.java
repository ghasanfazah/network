package com.example.networks.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.networks.R;
import com.example.networks.databinding.Fragment1Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {
    Fragment1Binding binding;
    Button button,button2;
    OnclilkLis onclilkLis;
    OnClickSign onClickSign;


    EditText editText,editText2;

    private static final String ARG_EMAIL = "email";
    private static final String ARG_PASSSWORD = "password";

    private String mEmail;
    private String mpassword;

    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof OnclilkLis) {
            onclilkLis = (OnclilkLis) context;
        } else {
            throw new ClassCastException("implement valid");
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onclilkLis=null;
    }

    public Fragment1() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
       button = view.findViewById(R.id.btn_loging);
       // TextView textView = view.findViewById(R.id.tv_Have);
        editText=view.findViewById(R.id.eT_Email);
        editText2=view.findViewById(R.id.eT_Password);
        button2=view.findViewById(R.id.btn_SignIn);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSign.onClickSign();


            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
onclilkLis.onclickLIS(editText.getText().toString(),editText2.getText().toString());
            }
        });


        return view;
    }

    public  interface OnclilkLis{
        void onclickLIS(String email, String password);
    }
    public interface OnClickSign{
        void onClickSign();

    }




}
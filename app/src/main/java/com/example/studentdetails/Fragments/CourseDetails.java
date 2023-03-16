package com.example.studentdetails.Fragments;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.studentdetails.R;



public class CourseDetails extends Fragment {


    public CourseDetails() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.fragment_course_details, container, false);

            Button next = rootView.findViewById(R.id.next);

            getParentFragmentManager().setFragmentResultListener("dataCourse",
                    this,
                    new FragmentResultListener(){
                        @Override
                        public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                            String course = result.getString("course");
                            String id = result.getString("id");


    // ADD LOGIC HERE
                        }
                    });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment secondFrag = new Summary();
                    FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.course, secondFrag).commit();
                }
            });

            return rootView;
    }
}
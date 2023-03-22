package com.example.studentdetails.Fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.studentdetails.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CourseDetails extends Fragment {


    public CourseDetails() {
        // Required empty public constructor
    }


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayAdapter<CharSequence> year_adapter, semester_adapter;
    private String selectedYear, selectedSemester, uniqueID;

    private String year, sem, year_and_sem, databaseNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.fragment_course_details, container, false);

            Spinner course_spinner2 = rootView.findViewById(R.id.course);
            Button save = rootView.findViewById(R.id.save);
            Button next = rootView.findViewById(R.id.next);



            getParentFragmentManager().setFragmentResultListener("dataCourse",
                    this,
                    new FragmentResultListener(){
                        @Override
                        public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                            String course = result.getString("course");
                            String id = result.getString("id");

                            ArrayList<String> list = new ArrayList<String>();
                            list.add(course);

                            ArrayAdapter<String> course_adapter_2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);

                            course_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                            course_spinner2.setAdapter(course_adapter_2);

                            Spinner year_spinner = rootView.findViewById(R.id.year);

                            Spinner semester_spinner = rootView.findViewById(R.id.semester);

                            year_adapter = ArrayAdapter.createFromResource(getContext(), R.array.years_array, R.layout.spinner_layout);
                            year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            year_spinner.setAdapter(year_adapter);

                            semester_adapter = ArrayAdapter.createFromResource(getContext(), R.array.semester_array, R.layout.spinner_layout);
                            semester_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            semester_spinner.setAdapter(semester_adapter);

                            // Add a new document with a generated ID
                            // Create a new user with a first, middle, and last name

                            year_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    selectedYear = year_spinner.getSelectedItem().toString();

                                    int yearSpinnerID = adapterView.getId();
                                    if(yearSpinnerID == R.id.year){
                                        switch (selectedYear){
                                            case "Select Year":
                                                year = "error";
                                                break;

                                            case "Year 1":
                                                year = "1";
                                                break;

                                            case"Year 2":
                                                year = "2";
                                                break;

                                            case"Year 3":
                                                year = "3";
                                                break;

                                            case"Year 4":
                                                year = "4";
                                                break;

                                            default: break;
                                        }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });


                            // Add a new document with a generated ID
                            next.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

// Create a new user with a first and last name

                                }
                            });

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
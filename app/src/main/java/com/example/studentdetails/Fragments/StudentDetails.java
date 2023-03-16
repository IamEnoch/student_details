package com.example.studentdetails.Fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studentdetails.MainActivity;
import com.example.studentdetails.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public StudentDetails() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static StudentDetails newInstance(String param1, String param2) {
        StudentDetails fragment = new StudentDetails();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student_details, container, false);


        EditText firstName = rootView.findViewById(R.id.fname);
        EditText middleName = rootView.findViewById(R.id.mname);
        EditText lastName = rootView.findViewById(R.id.lname);
        EditText idNum = rootView.findViewById(R.id.idnum);
        EditText regNum = rootView.findViewById(R.id.reg);

        Button submit = rootView.findViewById(R.id.submit);
        Button cancel = rootView.findViewById(R.id.cancel);

        RadioButton male = rootView.findViewById(R.id.male);
        RadioButton female  = rootView.findViewById(R.id.female);
        Spinner courses = rootView.findViewById(R.id.courses);
        Spinner department = rootView.findViewById(R.id.department);
        Spinner school = rootView.findViewById(R.id.school);


        ArrayAdapter<CharSequence> coursesAdapter = ArrayAdapter.createFromResource(getContext(),R.array.courses,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> departmentAdapter = ArrayAdapter.createFromResource(getContext(),R.array.department,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> schoolAdapter = ArrayAdapter.createFromResource(getContext(),R.array.school,android.R.layout.simple_spinner_item);

        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        courses.setAdapter(coursesAdapter);
        department.setAdapter(departmentAdapter);
        school.setAdapter(schoolAdapter);




        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String f_name = firstName.getText().toString();
                String m_name = middleName.getText().toString();
                String l_name = lastName.getText().toString();
                String idNumber = idNum.getText().toString();
                String registration = regNum.getText().toString();


                String gender = null;
                if (male.isChecked()) {
                    gender = "male";
                } else if (female.isChecked()) {
                    gender = "female";
                }

                Map<String, Object> student = new HashMap<>();
                student.put("firstName", f_name);
                student.put("gender", gender);
                student.put("idNumber", idNumber);
                student.put("lastName", l_name);
                student.put("registrationNumber", registration);
                student.put("middleName", m_name);

                // Add a new document with a generated ID
                db.collection("students")
                        .add(student)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast.makeText(getActivity(), "Added successfully" + documentReference.getId(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                                Toast.makeText(getActivity(), "Failed To Add" + e, Toast.LENGTH_SHORT).show();

                            }
                        });

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        // Inflate the layout for this fragment
        return rootView;
    }
}
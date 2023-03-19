package com.example.studentdetails.Fragments;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

<<<<<<< HEAD
import androidx.annotation.Nullable;
=======
import androidx.annotation.NonNull;
>>>>>>> 7f70a2dad899572f45a4e6200731e70aa9b02b1e
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
=======
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
>>>>>>> 7f70a2dad899572f45a4e6200731e70aa9b02b1e

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

    private String selectedSchool, selectedDepartment, selectedCourse;
    private Spinner school_spinner, department_spinner, course_spinner;
    private ArrayAdapter<CharSequence> school_adapter, department_adapter, course_adapter;
    private String f_name, m_name, l_name, reg_no, gender, id_no;
    private RadioGroup radioGroup;
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

<<<<<<< HEAD
    }
=======

        EditText firstName = rootView.findViewById(R.id.fname);
        EditText middleName = rootView.findViewById(R.id.mname);
        EditText lastName = rootView.findViewById(R.id.lname);
        EditText idNum = rootView.findViewById(R.id.idnum);
        EditText regNum = rootView.findViewById(R.id.reg);

        Button submit = rootView.findViewById(R.id.submit);
        Button cancel = rootView.findViewById(R.id.cancel);

        RadioButton male = rootView.findViewById(R.id.male);
        RadioButton female  = rootView.findViewById(R.id.female);
        Spinner course_spinner = rootView.findViewById(R.id.courses);
        Spinner department_spinner = rootView.findViewById(R.id.department);
        Spinner school_spinner = rootView.findViewById(R.id.school);


        ArrayAdapter<CharSequence> school_adapter = ArrayAdapter.createFromResource(getContext(), R.array.school_array, R.layout.spinner_layout);

        school_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        school_spinner.setAdapter(school_adapter);

        school_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedSchool = school_spinner.getSelectedItem().toString();

                int schoolSpinnerID = adapterView.getId();
                if (schoolSpinnerID == R.id.school){
                    switch(selectedSchool){

                        case "Select The School": department_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.default_Department, R.layout.spinner_layout);
                            break;

                        case "School of Business": department_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.business_departments, R.layout.spinner_layout);
                            break;


                        case "School of Engineering": department_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.engineering_departments, R.layout.spinner_layout);
                            break;


                        case "School of Computer Science and IT": department_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.CS_and_IT_departments, R.layout.spinner_layout);
                            break;

                        case "School of Science": department_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.science_departments, R.layout.spinner_layout);
                            break;


                        default: break;

                    }
                    department_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    department_spinner.setAdapter(department_adapter);

                    department_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedDepartment = department_spinner.getSelectedItem().toString();

                            int departmentSpinnerID = adapterView.getId();
                            if(departmentSpinnerID == R.id.department){
                                switch (selectedDepartment){
                                    case "Select the Department": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.default_course, R.layout.spinner_layout);
                                        break;

                                    case "Department of Accounting": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.accounting_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Commerce": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.commerce_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Finance": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.finance_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Mechatronics Engineering": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.mechatronics_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Mechanical Engineering": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.mechanical_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Chemical Engineering": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.chemical_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Computer Science": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.cs_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of IT": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.IT_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Nursing": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.nursing_department, R.layout.spinner_layout);
                                        break;

                                    case "Department of Actuarial Science": course_adapter = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.actuarial_department, R.layout.spinner_layout);
                                        break;


                                    default: break;
                                }

                                course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                course_spinner.setAdapter(course_adapter);

                                course_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        selectedCourse = course_spinner.getSelectedItem().toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




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
                Bundle result = new Bundle();
                result.putString("course", selectedCourse);
                result.putString("id", idNumber);
                getParentFragmentManager().setFragmentResult("dataCourse", result);
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
>>>>>>> 7f70a2dad899572f45a4e6200731e70aa9b02b1e

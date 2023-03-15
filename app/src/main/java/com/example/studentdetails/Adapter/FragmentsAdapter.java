package com.example.studentdetails.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.studentdetails.Fragments.CourseDetails;
import com.example.studentdetails.Fragments.StudentDetails;
import com.example.studentdetails.Fragments.Summary;

public class FragmentsAdapter extends FragmentPagerAdapter{
    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new StudentDetails();
            case 1:return new CourseDetails();
            case 2:return  new Summary();
            default:return new StudentDetails();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0){
            title="Student Details";
        }
        if (position == 1){
            title="Course Details";
        }
        if (position == 2){
            title="Summary";
        }
        return title;
    }
}
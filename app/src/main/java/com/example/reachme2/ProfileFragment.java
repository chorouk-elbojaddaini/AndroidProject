package com.example.reachme2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener  {
     TextView addWorkTextView;
     TextView addEducationTextView;
     TextView addSkillTextView;
     TextView addLanguageView;
     TextView uploadDocumentView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);


        //get list view
        List<WorkExperienceItem> workExperienceList = new ArrayList<>();
        workExperienceList.add(new WorkExperienceItem("fullstack dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));
        workExperienceList.add(new WorkExperienceItem("backend dev"));



        ListView workExperienceListView = (ListView) v.findViewById(R.id.work_experience_list_view);
        workExperienceListView.setAdapter( new WorkExperienceAdapter(getContext(),workExperienceList));
        // Inflate the layout for this fragment

         addWorkTextView = v.findViewById(R.id.addWork);
         addEducationTextView = v.findViewById(R.id.addEducation);
         addSkillTextView = v.findViewById(R.id.addSkill);
         addLanguageView = v.findViewById(R.id.addLanguage);
         uploadDocumentView = v.findViewById(R.id.uploaddoc);
         addWorkTextView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent addWorkIntent = new Intent(getActivity(),addWorkExperience.class);
                 startActivity(addWorkIntent);

             }
         });
         addEducationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEducationIntent = new Intent(getActivity(),AddEducation.class);
                startActivity(addEducationIntent);

            }
        });
        addSkillTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSkillIntent = new Intent(getActivity(),AddSkill.class);
                startActivity(addSkillIntent);

            }
        });
        addLanguageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addLanguageIntent = new Intent(getActivity(),AddLanguages.class);
                startActivity(addLanguageIntent);

            }
        });
        uploadDocumentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addLanguageIntent = new Intent(getActivity(),UploadDocument.class);
                startActivity(addLanguageIntent);

            }
        });
         return v;
    }


    @Override
    public void onClick(View view) {

    }
}
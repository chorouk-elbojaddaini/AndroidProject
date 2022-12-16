package com.example.reachme2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
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
    TextView editWorkExperience;
    private DBHelper DB;
    TextView workReload;
    TextView domainSection;
    String domaine;
    TextView txt;
    TextView abr;
    TextView emailTxt;

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
        DBHelper DB = new DBHelper(getActivity());
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);



        List<Languages> languagesList = new ArrayList<>();
        Cursor languagesCursor = DB.getAllLanguages(userEmailClass.email);
        if(languagesCursor.moveToFirst()){
            do {
                // on below line we are adding the data from cursor to our array list.

                languagesList.add(new Languages(

                        languagesCursor.getString(1)
                ));
            } while (languagesCursor.moveToNext());
        }
        ListView languageListView = (ListView) v.findViewById(R.id.languagess_list_view);

        languageListView.setAdapter( new languageItemAdapter(getContext(),languagesList));


        List<Skill> skillList = new ArrayList<>();
        Cursor skillListCursor = DB.getAllSkill(userEmailClass.email);
        if(skillListCursor.moveToFirst()){
            do {
                // on below line we are adding the data from cursor to our array list.

                skillList.add(new Skill(

                        skillListCursor.getString(1),
                        skillListCursor.getString(2)


                ));
            } while (skillListCursor.moveToNext());
        }

        //get list view


        ListView skillListView = (ListView) v.findViewById(R.id.skill_list_view);

        skillListView.setAdapter( new SkillAdapter(getContext(),skillList));




        workReload = v.findViewById(R.id.workReload);

        txt = v.findViewById(R.id.nom);
        abr = v.findViewById(R.id.abreviation);
        emailTxt = v.findViewById(R.id.emailtxt);

        String name = getActivity().getIntent().getStringExtra("email");
        Cursor cursor = DB.viewData(name);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder email = new StringBuilder();
        String emailString = email.toString();

        while(cursor.moveToNext()){
            stringBuilder.append(""+ cursor.getString(1));
            stringBuilder2.append(""+ cursor.getString(2));
            email.append(""+cursor.getString(0));

        }
        String text = stringBuilder + " "+stringBuilder2;
        String firstCharacter = stringBuilder.substring(0,1).toUpperCase();
        String secondCharacter = stringBuilder2.substring(0,1).toUpperCase();
        String nomComplet = firstCharacter + secondCharacter;


        txt.setText(text);
        abr.setText(nomComplet);
        emailTxt.setText(email);
        userEmailClass.email = email.toString();
        //Toast.makeText(getContext(),userEmailClass.email , Toast.LENGTH_SHORT).show();
        Cursor domaineListCursor =  DB.getDomaine(userEmailClass.email);
        domainSection = v.findViewById(R.id.domaine_section);

        if(domaineListCursor.moveToFirst()){
            domaine = domaineListCursor.getString(1);
            if(!domaine.isEmpty()){
                domainSection.setText(domaine);

            }
        }



        boolean insertedEmail = DB.insertCurrentUserEmail(email.toString());



        domainSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Domains.class);
                startActivity(intent);
            }
        });

        workReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().detach(ProfileFragment.this).attach(ProfileFragment.this).commit();


            }
        });
        DB = new DBHelper(getActivity());

        Cursor workExperienceListCursor =  DB.getAllworkExperience(userEmailClass.email);
        List<workExperience> workExperienceList = new ArrayList<>();
        if(workExperienceListCursor.moveToFirst()){
            do {
                // on below line we are adding the data from cursor to our array list.

                workExperienceList.add(new workExperience(
                        workExperienceListCursor.getInt(0),
                        workExperienceListCursor.getString(1),
                        workExperienceListCursor.getString(2),
                        workExperienceListCursor.getString(3),
                        workExperienceListCursor.getString(4),
                        workExperienceListCursor.getString(5),
                        workExperienceListCursor.getString(6),
                        workExperienceListCursor.getString(7),
                        workExperienceListCursor.getInt(8),
                        workExperienceListCursor.getString(9)

                ));
            } while (workExperienceListCursor.moveToNext());
        }
        //get list view


        ListView workExperienceListView = (ListView) v.findViewById(R.id.work_experience_list_view);

        workExperienceListView.setAdapter( new WorkExperienceAdapter(getContext(),workExperienceList));

            /* workExperienceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView t = view.findViewById(R.id.work_id);
                    Intent  intent = new Intent(getActivity(),UpdateWorkExperience.class);
                    intent.putExtra("id",t.getText().toString());
                    startActivity(intent);
                }
            });*/
        workExperienceListView.setClickable(true);

        workExperienceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                workExperience item = (workExperience) workExperienceListView.getItemAtPosition(i);
                Intent intent = new Intent(getActivity(),UpdateWorkExperience.class);
                intent.putExtra("workExperienceItem",item);

                startActivity(intent);
            }
        });

        Cursor educationListCursor = DB.getAllEducation(userEmailClass.email);
        List<Education> educationList = new ArrayList<>();


        if(educationListCursor.moveToFirst()){
            do {
                // on below line we are adding the data from cursor to our array list.

                educationList.add(new Education(
                        educationListCursor.getInt(0),
                        educationListCursor.getString(1),
                        educationListCursor.getString(2),
                        educationListCursor.getString(3),
                        educationListCursor.getString(4),
                        educationListCursor.getString(5),
                        educationListCursor.getString(6),
                        educationListCursor.getString(7),
                        educationListCursor.getString(8)
                ));
            } while (educationListCursor.moveToNext());
        }



        ListView educationListView  = (ListView) v.findViewById(R.id.educationListView) ;
        educationListView.setAdapter(new EducationAdapter(getContext(),educationList));
        educationListView.setClickable(true);

        educationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Education educationItem = (Education) educationListView.getItemAtPosition(i);
                Intent intent = new Intent(getActivity(),UpdateEducation.class);
                intent.putExtra("educationItem",educationItem);
                startActivity(intent);

            }

        });



        // Inflate the layout for this fragment
        addWorkTextView = v.findViewById(R.id.addWork);
        addEducationTextView = v.findViewById(R.id.addEducation);
        addSkillTextView = v.findViewById(R.id.addSkill);
        addLanguageView = v.findViewById(R.id.addLanguage);


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
                Intent addLanguageIntent = new Intent(getActivity(),LanguagesListView.class);
                startActivity(addLanguageIntent);

            }
        });


        addWorkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addWorkIntent = new Intent(getActivity(),addWorkExperience.class);
                addWorkIntent.putExtra("email",emailString);
                startActivity(addWorkIntent);

            }
        });

        return v;
    }


    @Override
    public void onClick(View view){

}
}
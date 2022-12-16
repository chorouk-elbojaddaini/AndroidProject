package com.example.reachme2;



import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    DBHelper DB;
    TextView recom;
    TextView save;
    TextView nameJob;
    LinearLayout imageOne,imageTwo;
    ListView listview;
    List<itemList> itemLists;
    Button apply;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        DB = new DBHelper(getActivity());
        recom = rootView.findViewById(R.id.recom);
        save = rootView.findViewById(R.id.jobsaving);

        imageOne = rootView.findViewById(R.id.image_one);
        imageTwo = rootView.findViewById(R.id.image_two);
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



        userEmailClass.email = email.toString();






        Cursor domaineListCursor =  DB.getDomaine(userEmailClass.email);

        String domaine;
        if(domaineListCursor.moveToFirst()) {
            domaine = domaineListCursor.getString(1);
            if (!domaine.isEmpty()) {

                Cursor itemListsCursor = DB.getSerchedJob(domaine);
                itemLists = new ArrayList<>();
                if(itemListsCursor.getCount()==0){
                    imageOne.setVisibility(View.VISIBLE);
                    imageTwo.setVisibility(View.VISIBLE);
                     //listview.setVisibility(View.GONE);
                }
                else{
                    if (itemListsCursor.moveToFirst()) {
                        do {
                            // on below line we are adding the data from cursor to our array list.

                            itemLists.add(new itemList(
                                    itemListsCursor.getInt(0),
                                    itemListsCursor.getString(1),
                                    itemListsCursor.getString(2),
                                    itemListsCursor.getString(3),
                                    itemListsCursor.getString(4),
                                    itemListsCursor.getString(5),
                                    itemListsCursor.getInt(6)

                            ));
                        } while (itemListsCursor.moveToNext());
                        listview = (ListView) rootView.findViewById(R.id.list);
                        listview.setAdapter(new itemListAdapter(getContext(),itemLists));



                    }
                }


            }

        }
        if(domaineListCursor.getCount()==0){
            imageOne.setVisibility(View.VISIBLE);
            imageTwo.setVisibility(View.VISIBLE);
        }


        return rootView;
    }
}
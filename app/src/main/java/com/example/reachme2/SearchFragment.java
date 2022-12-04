package com.example.reachme2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        //list of items
        List<HighTechItem> itemListse = new ArrayList<>();
        itemListse.add(new HighTechItem("Computer/Information Technology","computer"));
        itemListse.add(new HighTechItem("Accounting/Finance","finance"));
        itemListse.add(new HighTechItem("Admin/Human Ressources","admin"));
        itemListse.add(new HighTechItem("Building/Construction","building"));
        itemListse.add(new HighTechItem("Arts/Media/Communication","media"));
        itemListse.add(new HighTechItem("Education/Training","education"));
        itemListse.add(new HighTechItem("Enginnering","engineering"));
        itemListse.add(new HighTechItem("Hotel/Restaurant","hotel"));
        itemListse.add(new HighTechItem("Sciences","sciences"));
        itemListse.add(new HighTechItem("Healthcare","health"));
        itemListse.add(new HighTechItem("Sales/Marketing","marketing"));
        itemListse.add(new HighTechItem("Manufacturing","manufacturing"));







        //get list view
        ListView listview = rootView.findViewById(R.id.searlist);
        listview.setAdapter(new HighTechItemAdapter(getContext(),itemListse));

        return rootView;
    }
}
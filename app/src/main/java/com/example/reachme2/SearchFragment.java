package com.example.reachme2;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    DBHelper DB;
    SearchView searchJobInput;
    TextView specializationTxt;
    List<itemList> itemLists;
    itemListAdapter itemAdapter;
    Cursor itemListsCursor;
    ImageView imageSearch;
    TextView notFoundSearch , enterJobText;
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
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        searchJobInput = v.findViewById(R.id.searchJob);

        imageSearch = v.findViewById(R.id.image_search);
        notFoundSearch = v.findViewById(R.id.notfound_search);
        enterJobText = v.findViewById(R.id.search_for_domaine);
        searchJobInput.clearFocus();
        searchJobInput.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                DB = new DBHelper(getActivity());



                itemListsCursor = DB.getSerchedJob(s);
                itemLists = new ArrayList<>();
                if(itemListsCursor.moveToFirst()){
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
                }



                //get list view
                ListView listview = (ListView) v.findViewById(R.id.searlist);
                if(!itemLists.isEmpty()){
                    imageSearch.setVisibility(View.GONE);
                    notFoundSearch.setVisibility(View.GONE);


                    listview.setVisibility(View.VISIBLE);
                    itemAdapter = new itemListAdapter(getContext(),itemLists);
                    listview.setAdapter(itemAdapter);
                }
                else{
                    listview.setVisibility(View.GONE);
                    imageSearch.setVisibility(View.VISIBLE);
                    notFoundSearch.setVisibility(View.VISIBLE);
                    enterJobText.setVisibility(View.GONE);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //filterList(newText);
                return false;
            }
        });
        //list of items
        //List<HighTechItem> itemListse = new ArrayList<>();


        return v;
    }
    private void filterList(String text){
        List<itemList> filteredList = new ArrayList<>();
        for(itemList item : itemLists){
            if(item.getDomaine().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }
        if(filteredList.isEmpty()){

        }
        else{
            itemAdapter.setFilteredList(filteredList);
        }
    }
}
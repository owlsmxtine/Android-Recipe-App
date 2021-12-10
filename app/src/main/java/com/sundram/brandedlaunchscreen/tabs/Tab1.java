package com.sundram.brandedlaunchscreen.tabs;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.brandedlaunchscreen.Adapter.MeatAdapter;
import com.sundram.brandedlaunchscreen.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab1 extends Fragment {

    RecyclerView recyclerView;
    String nm1, ov1;
    MeatAdapter meatAdapter;
    public static String mainPrers = "file.main.message";


    //Overriden method onCreateView
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        SharedPreferences pref = getContext().getSharedPreferences(mainPrers,0);
        String dataMessage = pref.getString("message","");
        try {
            JSONArray jsonArray = new JSONArray(dataMessage);
            MeatAdapter meatAdapter = new MeatAdapter(jsonArray,getContext());

            recyclerView = view.findViewById(R.id.rv);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            recyclerView.setAdapter(meatAdapter);
            meatAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON", dataMessage);


        return view;
    }



}

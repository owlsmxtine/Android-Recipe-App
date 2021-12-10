package com.sundram.brandedlaunchscreen;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.sundram.brandedlaunchscreen.Adapter.ProfileAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ExplorePageActivity extends  BaseActivity {
    List<JSONArray> profileList;
    //the recyclerview
    RecyclerView view;;
    String nm1, ov1;
    ProfileAdapter profileAdapter;
    public static String mainPrers = "file.main.message";


    //the recyclerview

    TextView nm,pre,per,ing;
    ImageView img;

    @Override
    int getContentViewId() {
        return R.layout.activity_explore_page;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_dashboard;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = (RecyclerView) findViewById(R.id.rec);
        view.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences pref = getSharedPreferences(mainPrers,0);
        String dataMessage = pref.getString("message","");

        try {
            JSONArray jsonArray = new JSONArray(dataMessage);
            profileAdapter = new ProfileAdapter(jsonArray,this);


            view.setAdapter(profileAdapter);
            profileAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON", dataMessage);
    }
}
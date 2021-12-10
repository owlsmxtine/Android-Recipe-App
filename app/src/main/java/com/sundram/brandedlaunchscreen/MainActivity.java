package com.sundram.brandedlaunchscreen;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.sundram.brandedlaunchscreen.Adapter.HomeAdapter;
import com.sundram.brandedlaunchscreen.model.Item;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_home;
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
    public int getContentViewId() {
        return R.layout.activity_main;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        ArrayList<Item> arrayList = new ArrayList<>();

        arrayList.add(new Item("Burger",R.drawable.american,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Pancake", R.drawable.american_pancakes,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Chicken",R.drawable.asian_chicken,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Pizza",R.drawable.european_pizza,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Burger",R.drawable.american,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Pancake", R.drawable.american_pancakes,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Chicken",R.drawable.asian_chicken,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Pizza",R.drawable.european_pizza,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Burger",R.drawable.american,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Pancake", R.drawable.american_pancakes,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Chicken",R.drawable.asian_chicken ,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));
        arrayList.add(new Item("Pizza",R.drawable.european_pizza,"1 baking flour\n2 sugar\n3 lichens\n4 blueband spoonful",1,"1 boil water \n2 mix with flour\n3 add salt \n4 stir steadily\n5 put on oven to bake"));

        HomeAdapter adapter = new HomeAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, Integer.parseInt("1"), GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
}

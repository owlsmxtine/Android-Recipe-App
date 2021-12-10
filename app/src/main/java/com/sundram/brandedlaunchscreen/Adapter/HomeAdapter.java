package com.sundram.brandedlaunchscreen.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sundram.brandedlaunchscreen.ExplorePageActivity;
import com.sundram.brandedlaunchscreen.R;
import com.sundram.brandedlaunchscreen.model.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private ArrayList<Item> mValues;
    private Context mContext;
    protected ItemListener mListener;

    public HomeAdapter(Context context, ArrayList<Item> values) {
        mValues = values;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name,price,hire;
        private ImageView imageView;

        private Item item;


        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            name = (TextView) v.findViewById(R.id.name);

            imageView = (ImageView) v.findViewById(R.id.imageview);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent= new Intent(mContext,ExplorePageActivity.class);
                    intent.putExtra("nam",item.getName());
                    intent.putExtra("img",item.getImage());
                    intent.putExtra("pre",item.getPrepation());
                    intent.putExtra("ing",item.getIngridents());
                    intent.putExtra("per",item.getPerson());

                    JSONObject jsonObject = new JSONObject();
                    try {

                        jsonObject.put("nam",item.getName());
                        jsonObject.put("ing", item.getIngridents());
                        jsonObject.put("img", item.getImage());
                        jsonObject.put("pre",item.getPrepation());
                        jsonObject.put("per",item.getPerson());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (preferences.contains("message")) {
                        String dataMessage = preferences.getString("message", "");

                        try {
                            JSONArray jsonArray = new JSONArray(dataMessage);
                            jsonArray.put(jsonObject);
                            editor.putString("message", jsonArray.toString());
                            editor.apply();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JSONArray jsonArray = new JSONArray();
                        jsonArray.put(jsonObject);
                        editor.putString("message", jsonArray.toString());
                        editor.apply();
                    }

                    Toast.makeText(mContext, "Recipe Detail created!", Toast.LENGTH_SHORT).show();



                    mContext.startActivity(intent);

                }
            });

        }

        public void setData(@NonNull Item item) {
            this.item = item;
            name.setText(item.getName());

            Glide.with(mContext)
                    .load(item.getImage())
                    .into(imageView);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_recipelist, parent, false);
        preferences = mContext.getSharedPreferences(ExplorePageActivity.mainPrers,0);
        editor = preferences.edit();


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setData(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface
    ItemListener {
        void onItemClick(Item item);
    }
}
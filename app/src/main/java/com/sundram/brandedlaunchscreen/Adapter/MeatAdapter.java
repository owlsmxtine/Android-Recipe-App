package com.sundram.brandedlaunchscreen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sundram.brandedlaunchscreen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MeatAdapter extends RecyclerView.Adapter<MeatAdapter.MyViewHolder> {

    Context context;
    JSONArray jsonArray;
    public MeatAdapter(JSONArray jsonArray, Context context) {
        this.context=context;
        this.jsonArray=jsonArray;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meat_tab1,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
          try {
              try {
                  JSONObject jsonObject=jsonArray.getJSONObject(position);
                  Glide.with(context)
                          .load(jsonObject.getInt("img"))
                          .into(holder.meati);
                  holder.meatn.setText(jsonObject.getString("nam"));
                  holder.meatg.setText(jsonObject.getString("ing"));

              } catch (JSONException e) {
                  e.printStackTrace();
              }

          } catch (Exception e) {
              e.printStackTrace();
          }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView meatn,meatg;
        ImageView meati;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            meati=itemView.findViewById(R.id.mi);
            meatn=itemView.findViewById(R.id.mn);
            meatg=itemView.findViewById(R.id.mg);
        }
    }
}

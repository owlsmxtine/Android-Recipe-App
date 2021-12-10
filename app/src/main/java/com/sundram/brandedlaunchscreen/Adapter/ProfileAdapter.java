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
import com.squareup.picasso.Picasso;
import com.sundram.brandedlaunchscreen.ExplorePageActivity;
import com.sundram.brandedlaunchscreen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileAdapter extends RecyclerView.Adapter <ProfileAdapter.MyViewHolder>{
    JSONArray jsonArray;
    Context context;
    public ProfileAdapter(JSONArray jsonArray, Context context) {
        this.context=context;
        this.jsonArray=jsonArray;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipelist_deatails,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      try {
          JSONObject jsonObject=jsonArray.getJSONObject(position);
          holder.name.setText(jsonObject.getString("nam"));

          Glide.with(context)
                  .load(jsonObject.getInt("img"))
                  .into(holder.img);
          holder.ing.setText(jsonObject.getString("ing"));
          holder.prep.setText(jsonObject.getString("pre"));
          holder.pers.setText(jsonObject.getString("per"));


      } catch (JSONException e) {
          e.printStackTrace();
      }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,prep,pers,ing;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.nm);
            prep=itemView.findViewById(R.id.prepa);
            pers=itemView.findViewById(R.id.pers);
            ing=itemView.findViewById(R.id.ingre);

        }
    }
}

package com.learning.ayush.easyplacement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class companyAdapter extends RecyclerView.Adapter<companyAdapter.ViewHolder>{
    private Firebase mFirebase;
   private ArrayList<String> company_list = new ArrayList<String>();
   private Context mContext;

    public companyAdapter(Context c1){
        mContext=c1;
        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/companies/");
        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dsp : dataSnapshot.getChildren()){

                    Map<String,String> map = dsp.getValue(Map.class);
                    String cname = map.get("Company_Name");
                    company_list.add(cname);

                }
                notifyDataSetChanged();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @NonNull
    @Override
    public companyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inf=LayoutInflater.from(viewGroup.getContext());
        View view=inf.inflate(R.layout.company_adapter,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.t1.setText(company_list.get(i));
    }


    @Override
    public int getItemCount() {
        return company_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1= itemView.findViewById(R.id.name_company);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
         Intent cInfo= new Intent(mContext,company_details.class);
         cInfo.putExtra("name",t1.getText().toString());
         mContext.startActivity(cInfo);
        }
    }


}

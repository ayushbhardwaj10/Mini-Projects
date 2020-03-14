package com.learning.ayush.easyplacement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class varifyAdapter extends RecyclerView.Adapter<varifyAdapter.ViewHolder> {
    private Firebase mFirebase;
    private ArrayList<String> student_list = new ArrayList<String>();
    private Context mContext;

    public varifyAdapter(Context c1)
    {
        mContext=c1;
        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/stu/");
        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dsp : dataSnapshot.getChildren()){

                    Map<String,String> map = dsp.getValue(Map.class);
                    String cname = map.get("Username");
                    student_list.add(cname);
                }
                if(student_list.isEmpty())
                    student_list.add("No Students to varify");
                notifyDataSetChanged();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @NonNull
    @Override
    public varifyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.varify_adapter,viewGroup,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull varifyAdapter.ViewHolder viewHolder, int i) {
        viewHolder.t1.setText(student_list.get(i));
    }

    @Override
    public int getItemCount() {
        return student_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView t1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1= itemView.findViewById(R.id.student_usn);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent stuInfo= new Intent(mContext,Student_Varification_Process.class);
            stuInfo.putExtra("usn",t1.getText().toString());
            mContext.startActivity(stuInfo);
        }
    }
}

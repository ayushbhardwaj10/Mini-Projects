package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class student_dashboard extends AppCompatActivity {


    private TextView welcome;
    private RecyclerView r1;
    private companyAdapter CA;
    //private Button back1;
    private String name,cgpa,twelve,usn,phone;
    private Firebase mFirebase;

    @Override
    public void onBackPressed()
    {
        Intent returnStuMain= new Intent(student_dashboard.this,stuMain.class);
        startActivity(returnStuMain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        welcome= findViewById(R.id.welcome);
        //back1= findViewById(R.id.back1);
        name= getIntent().getExtras().getString("name");
        cgpa= getIntent().getExtras().getString("cgpa");
        twelve= getIntent().getExtras().getString("twelve");
        usn= getIntent().getExtras().getString("USN");
        phone= getIntent().getExtras().getString("Phone");


        welcome.setText(name);
        mFirebase= new Firebase("https://easyplacement-72355.firebaseio.com/student");
        Firebase childFirebase = mFirebase.child("s1");
        Firebase Fcgpa = childFirebase.child("cgpa");
        Fcgpa.setValue(cgpa);
        Firebase F12 = childFirebase.child("twelve");
        F12.setValue(twelve);
        Firebase Fname = childFirebase.child("name");
        Fname.setValue("s1");
        Firebase FUSN = childFirebase.child("USN");
        FUSN.setValue(usn);
        Firebase FPhone = childFirebase.child("Phone");
        FPhone.setValue(phone);


        r1= findViewById(R.id.companyList);
        CA=new companyAdapter(this);
        r1.setAdapter(CA);
    }

}

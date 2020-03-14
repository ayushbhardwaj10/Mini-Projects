package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class tpo_addCompanies extends AppCompatActivity {

    private EditText cName,cPackage,cCGPA,c12,cJD;
    private Button addCompanyBtn;
    private Firebase mFirebase,mFirebase3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_add_companies);

        cName= findViewById(R.id.cName);
        cPackage= findViewById(R.id.cPackage);
        cCGPA= findViewById(R.id.cCGPA);
        c12= findViewById(R.id.c12);
        cJD= findViewById(R.id.cJD);
        addCompanyBtn = findViewById(R.id.addcompanybtn);
        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/companies/");

        addCompanyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String cname= cName.getText().toString();
             String cpackage= cPackage.getText().toString();
             String ccgpa= cCGPA.getText().toString();
             String cTwelve= c12.getText().toString();
             String cjd= cJD.getText().toString();
                if(cname.isEmpty() || cpackage.isEmpty() || ccgpa.isEmpty() || cTwelve.isEmpty() || cjd.isEmpty())
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"EMPTY FIELDS NOT ACCEPTED..!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Firebase childFirebase = mFirebase.child(cname);

                    Firebase Fname = childFirebase.child("Company_Name");
                    Fname.setValue(cname);

                    Firebase Fpackage = childFirebase.child("Package");
                    Fpackage.setValue(cpackage);

                    Firebase Fcgpa = childFirebase.child("CGPA");
                    Fcgpa.setValue(ccgpa);

                    Firebase F12 = childFirebase.child("Cuttoff12");
                    F12.setValue(cTwelve);

                    Firebase FJD = childFirebase.child("Job_Description");
                    FJD.setValue(cjd);


                    String url = "https://easyplacement-72355.firebaseio.com/applied_companies/";
                    mFirebase3= new Firebase(url);
                    Firebase childfirebase = mFirebase3.child(cname);

                    Firebase FnameofCompany= childfirebase.child("Name");
                    FnameofCompany.setValue(cname);


                    Toast toast = Toast.makeText(getApplicationContext(), "Company Added..!!", Toast.LENGTH_LONG);
                    toast.show();

                    Intent intent = new Intent(tpo_addCompanies.this, tpoDashboard.class);
                    startActivity(intent);

                }


            }
        });

    }
}

package com.learning.ayush.easyplacement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class company_details extends AppCompatActivity {
private TextView company,Tpkg,Tjd,Tcgpa,Ttwelve,status;
private Firebase mFirebase;
private Firebase mFirebase2;
private Firebase mFirebase3;
private Firebase mFirebase4;

private String cgpa,cuttoff12,jd,pkg,marks12,CGPA,usn,c,url2,phone,url;
int flag=0;
private Button apply;
int f=0;
String name=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        student_dashboard sd= new student_dashboard();


        Tpkg= findViewById(R.id.c_pkg);
        Tjd= findViewById(R.id.c_jd);
        Tcgpa= findViewById(R.id.c_cgpa);
        Ttwelve= findViewById(R.id.c_twelve);
        company=findViewById(R.id.company);
        status= findViewById(R.id.status);
        apply= findViewById(R.id.apply);
        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/companies/");
        mFirebase2=new Firebase("https://easyplacement-72355.firebaseio.com/student/");


        name=getIntent().getExtras().getString("name");

        url = "https://easyplacement-72355.firebaseio.com/applied_companies/"+name+"/";
        mFirebase3= new Firebase(url);

        //To know if a student has applied for a company or not.
        mFirebase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dsp : dataSnapshot.getChildren()){

                    Map<String,String> map = dsp.getValue(Map.class);

                    String tempName = map.get("name");

                    if(tempName.equals("s1")) {
                        usn= map.get("USN");
                        url= "https://easyplacement-72355.firebaseio.com/varified_students/"+usn+"/";
                        mFirebase4= new Firebase(url);
                        mFirebase4.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                             if(dataSnapshot.child(name).getValue()!=null) {
                                 String ans = (String) dataSnapshot.child(name).getValue();
                                 Log.d("Status", ans);
                                 apply.setEnabled(false);
                                 apply.setText("APPLIED");
                                 apply.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));

                             }
                             else Log.d("Status", "not applied");
                            }

                            @Override
                            public void onCancelled(FirebaseError firebaseError) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dsp : dataSnapshot.getChildren()){

                    Map<String,String> map = dsp.getValue(Map.class);

                    String cname = map.get("Company_Name");

                    if(name.equals(cname)) {
                        cgpa= map.get("CGPA");
                        cuttoff12= map.get("Cuttoff12");
                        jd= map.get("Job_Description");
                        pkg= map.get("Package");
                        company.setText(name);
                        Tpkg.setText(pkg);
                        Tjd.setText(jd);
                        Tcgpa.setText(cgpa);
                        Ttwelve.setText(cuttoff12);


                        mFirebase2.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for(DataSnapshot dsp : dataSnapshot.getChildren()){

                                    Map<String,String> map = dsp.getValue(Map.class);

                                    String tempName = map.get("name");

                                    if(tempName.equals("s1")) {
                                        marks12= map.get("twelve");
                                        CGPA= map.get("cgpa");
                                        usn= map.get("USN");
                                        phone= map.get("Phone");

                                        Double a= Double.parseDouble(marks12);
                                        Double b = Double.parseDouble(cuttoff12);
                                        Double c= Double.parseDouble(CGPA);
                                        Double d= Double.parseDouble(cgpa);
                                        if(a>=b && c>=d)
                                            status.setText("Eligible");
                                        else {
                                            status.setText("Not-Eligible");
                                            apply.setEnabled(false);
                                        }


                                    }
                                }

                            }

                            @Override
                            public void onCancelled(FirebaseError firebaseError) {

                            }
                        });


                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        //when apply button is clicked
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                url= "https://easyplacement-72355.firebaseio.com/varified_students/"+usn+"/";
                mFirebase4= new Firebase(url);
                //Firebase ch= mFirebase4.child(name);
                Firebase Fch = mFirebase4.child(name);
                Fch.setValue("applied");
                Firebase childFirebase = mFirebase3.child(usn);
                Firebase Fname = childFirebase.child("USN");
                Fname.setValue(usn);
                apply.setEnabled(false);
                apply.setText("APPLIED");
                apply.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                Toast.makeText(getApplicationContext(),"Successfully Applied",Toast.LENGTH_LONG).show();

              /* int permissionCheck= ContextCompat.checkSelfPermission(company_details.this, Manifest.permission.SEND_SMS);
                if(permissionCheck== PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage();
                }
                else {
                    ActivityCompat.requestPermissions(company_details.this,new String[]{Manifest.permission.SEND_SMS},0);
                }
                  */



            }
        });



    }
   /* private void MyMessage(){
        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, "You have successfully applied for the company "+name, null, null);
        Toast.makeText(company_details.this, "Applied Successfully", Toast.LENGTH_LONG).show();
    } */

    //If permissions not given for SMS
    /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 0 :
                if(grantResults.length>=0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage();
                }
                else {
                    Toast.makeText(company_details.this, "Required Permission not available to take this ACTION", Toast.LENGTH_LONG).show();
                }
                break;

        }


    } */
}

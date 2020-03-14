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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Map;

public class Student_Varification_Process extends AppCompatActivity {

    private Firebase mFirebase,mFirebase2;
    private String name,usn,branch,twe,cgpa,phone,pwd,Usn;
    private TextView tname,tusn,tbranch,ttwe,tcgpa,tphone;
    private Button v_approve,v_reject,goBack;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__varification__process);
        tname= findViewById(R.id.v_name);
        tusn= findViewById(R.id.v_usn);
        tbranch= findViewById(R.id.v_branch);
        ttwe= findViewById(R.id.v_12);
        tcgpa= findViewById(R.id.v_cgpa);
        tphone= findViewById(R.id.v_pno);
        v_approve= findViewById(R.id.v_approve);
        v_reject= findViewById(R.id.v_reject);
        goBack= findViewById(R.id.goback);

        mFirebase= new Firebase("https://easyplacement-72355.firebaseio.com/stu/");
        mFirebase2= new Firebase("https://easyplacement-72355.firebaseio.com/varified_students/");
        usn=getIntent().getExtras().getString("usn");
        Log.d("usn",usn);


        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                name= (String)dataSnapshot.child(usn).child("Name").getValue();
                Log.d("check",name);
                Usn= (String)dataSnapshot.child(usn).child("Username").getValue();
                Log.d("check",Usn);
                branch= (String)dataSnapshot.child(usn).child("Branch").getValue();
                Log.d("check",branch);
                twe= (String)dataSnapshot.child(usn).child("Twe").getValue();
                Log.d("check",twe);
                cgpa= (String)dataSnapshot.child(usn).child("Cgpa").getValue();
                Log.d("check",cgpa);
                phone= (String)dataSnapshot.child(usn).child("Phone").getValue();
                Log.d("check",phone);
                pwd= (String)dataSnapshot.child(usn).child("Password").getValue();
                Log.d("check",pwd);
                tname.setText(name);
                tusn.setText(Usn);
                tbranch.setText(branch);
                ttwe.setText(twe);
                tcgpa.setText(cgpa);
                tphone.setText(phone);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        v_approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase childFirebase = mFirebase2.child(usn);

                Firebase Fname = childFirebase.child("Name");
                Fname.setValue(name);

                Firebase Fbranch = childFirebase.child("Branch");
                Fbranch.setValue(branch);

                Firebase Fcgpa = childFirebase.child("Cgpa");
                Fcgpa.setValue(cgpa);

                Firebase Ftwe = childFirebase.child("Twe");
                Ftwe.setValue(twe);

                Firebase Fphone = childFirebase.child("Phone");
                Fphone.setValue(phone);

                Firebase Fusername = childFirebase.child("Username");
                Fusername.setValue(usn);

                Firebase Fpassword = childFirebase.child("Password");
                Fpassword.setValue(pwd);

                Toast.makeText(Student_Varification_Process.this,"Varified Successfully..!!",Toast.LENGTH_SHORT).show();

                //To delete record from un-approved storage
                mFirebase.child(Usn).getRef().removeValue();

                Intent sendIntent2 = new Intent(Intent.ACTION_VIEW);
                sendIntent2.putExtra("address", phone);
                sendIntent2.putExtra("sms_body", "CONGRATULATIONS "+name+", Your account is been approved at EASYPLACEMENT mobile application. Thankyou");
                sendIntent2.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent2);
                //SENDING SMS FOR APPROVAL TO STUDENT
               /* int permissionCheck= ContextCompat.checkSelfPermission(Student_Varification_Process.this, Manifest.permission.SEND_SMS);
                if(permissionCheck== PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage();
                }
                else {
                    ActivityCompat.requestPermissions(Student_Varification_Process.this,new String[]{Manifest.permission.SEND_SMS},0);
                } */

            }
        });

        v_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //To delete record from un-approved storage
                Log.d("reject",Usn);
                mFirebase.child(Usn).getRef().removeValue();

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("address", phone);
                sendIntent.putExtra("sms_body", "SORRY "+name+ ", Your account is been rejected at EASYPLACEMENT mobile application. Please fill correct details again. Thankyou");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
                //sendSMSMessage();
               /* //SENDING SMS FOR REJECTION TO STUDENT
                int permissionCheck= ContextCompat.checkSelfPermission(Student_Varification_Process.this, Manifest.permission.SEND_SMS);
                if(permissionCheck== PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage2();
                }
                else {
                    ActivityCompat.requestPermissions(Student_Varification_Process.this,new String[]{Manifest.permission.SEND_SMS},1);
                }*/
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent(Student_Varification_Process.this,Varify_students.class);
                startActivity(goback);
            }
        });

    }


    // Code Depricated

    private void sendSMSMessage(){

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        /* SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, "CONGRATULATIONS "+name+", Your account is been approved at EASYPLACEMENT mobile application. Thankyou", null, null);
        Toast.makeText(Student_Varification_Process.this, "Approved,Message Sent", Toast.LENGTH_LONG).show();*/
    }
    private void MyMessage2(){
        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(phone, null, "SORRY "+name+ ", Your account is been rejected at EASYPLACEMENT mobile application. Please fill correct details again. Thankyou", null, null);
        Toast.makeText(Student_Varification_Process.this, "Rejeted,Message Sent", Toast.LENGTH_LONG).show();
    }
    //If permissions not given for SMS
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, "CONGRATULATIONS "+name+", Your account is been approved at EASYPLACEMENT mobile application. Thankyou", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 0 :
                if(grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage();
                }
                else {
                    Toast.makeText(Student_Varification_Process.this, "Required Permission not available to take this ACTION", Toast.LENGTH_LONG).show();
                }
                break;
            case 1 :
                if(grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage2();
                }
                else {
                    Toast.makeText(Student_Varification_Process.this, "Required Permission not available to take this ACTION", Toast.LENGTH_LONG).show();
                }
                break;
        }


    }*/
}

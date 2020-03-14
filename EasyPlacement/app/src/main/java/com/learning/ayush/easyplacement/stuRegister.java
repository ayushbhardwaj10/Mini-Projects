package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class stuRegister extends AppCompatActivity {

    private Firebase mFirebase;
    private EditText name,branch,cgpa,twe,Phone,username,password1,password2;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_register);
        name= findViewById(R.id.name);
        branch= findViewById(R.id.branch);
        cgpa= findViewById(R.id.cgpa);
        twe= findViewById(R.id.twelfth);
        Phone= findViewById(R.id.phone);
        username= findViewById(R.id.username);
        password1= findViewById(R.id.password1);
        password2= findViewById(R.id.password2);
        register= findViewById(R.id.register);
        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/stu/");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name= name.getText().toString();
                String Branch= branch.getText().toString();
                String Cgpa= cgpa.getText().toString();
                String Twe= twe.getText().toString();
                String phone= Phone.getText().toString();
                String Username= username.getText().toString();
                String Password1= password1.getText().toString();
                String Password2= password2.getText().toString();

                if(Name.isEmpty() || Branch.isEmpty() || Cgpa.isEmpty() || Twe.isEmpty() || phone.isEmpty() || Username.isEmpty() || Password1.isEmpty() || Password2.isEmpty())
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"EMPTY FIELDS NOT ACCEPTED..!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(!(Password1.equals(Password2)))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"PASSWORD MISMATCH..!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Firebase childFirebase = mFirebase.child(Username);

                    Firebase Fname = childFirebase.child("Name");
                    Fname.setValue(Name);

                    Firebase Fbranch = childFirebase.child("Branch");
                    Fbranch.setValue(Branch);

                    Firebase Fcgpa = childFirebase.child("Cgpa");
                    Fcgpa.setValue(Cgpa);

                    Firebase Ftwe = childFirebase.child("Twe");
                    Ftwe.setValue(Twe);

                    Firebase Fphone = childFirebase.child("Phone");
                    Fphone.setValue(phone);

                    Firebase Fusername = childFirebase.child("Username");
                    Fusername.setValue(Username);

                    Firebase Fpassword = childFirebase.child("Password");
                    Fpassword.setValue(Password1);


                    Toast toast = Toast.makeText(getApplicationContext(), "Saved details,Please Wait for Confirmation", Toast.LENGTH_LONG);
                    toast.show();

                    Intent intentstumain = new Intent(stuRegister.this, stuMain.class);
                    startActivity(intentstumain);

                }
            }
        });

    }
}

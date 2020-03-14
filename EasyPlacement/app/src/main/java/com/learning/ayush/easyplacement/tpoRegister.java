package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class tpoRegister extends AppCompatActivity {

    private EditText Name,Age,Expertise,Username,Password1,Password2,secretKey;
    private Button register;
    private Firebase mFirebase,mFirebase2;
    private Long secretCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_register);
        Name= findViewById(R.id.name);
        Age= findViewById(R.id.age);
        Expertise= findViewById(R.id.expertise);
        Username= findViewById(R.id.username);
        Password1= findViewById(R.id.password1);
        Password2=findViewById(R.id.password2);
        secretKey= findViewById(R.id.tpo_secret_key);
        register=findViewById(R.id.register);
        mFirebase2=new Firebase("https://easyplacement-72355.firebaseio.com/tpo_secret/");
        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/tpo/");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mFirebase2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot dsp : dataSnapshot.getChildren()){

                            Map<String,String> map = dsp.getValue(Map.class);
                            String c = map.get("code");
                            secretCode= Long.parseLong(c);
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
                Long keyEntered= Long.parseLong(secretKey.getText().toString());
                String name= String.valueOf(Name.getText());
                String age= String.valueOf(Age.getText());
                String expertise= String.valueOf(Expertise.getText());
                String username= String.valueOf(Username.getText());
                String password1= String.valueOf(Password1.getText());
                String password2= String.valueOf(Password2.getText());



                if(keyEntered==null ||  name.isEmpty() || age.isEmpty() || expertise.isEmpty() || username.isEmpty() || password1.isEmpty()|| password2.isEmpty())
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"EMPTY FIELDS NOT ACCEPTED..!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(!(password1.equals(password2)))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"PASSWORD MISMATCH..!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                //store it in firebase
                else {

                    if(!String.valueOf(keyEntered).equals(String.valueOf(secretCode)))
                    {
                        Toast.makeText(getApplicationContext(),"WRONG SECRET KEY",Toast.LENGTH_SHORT).show();
                    }
                    else {

                    Firebase childFirebase = mFirebase.child(username);

                    Firebase Fname = childFirebase.child("Name");
                    Fname.setValue(name);

                    Firebase Fage = childFirebase.child("Age");
                    Fage.setValue(age);

                    Firebase Fexpertise = childFirebase.child("Expertise");
                    Fexpertise.setValue(expertise);

                    Firebase Fusername = childFirebase.child("Username");
                    Fusername.setValue(username);

                    Firebase Fpassword = childFirebase.child("Password");
                    Fpassword.setValue(password1);


                    Toast toast = Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_LONG);
                    toast.show();

                    Intent intent = new Intent(tpoRegister.this, tpoMain.class);
                    startActivity(intent);

                 }}
                }

        });

    }
}

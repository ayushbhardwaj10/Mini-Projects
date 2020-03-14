package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class stuMain extends AppCompatActivity {

    private EditText username,password;
    private Firebase mFirebase;
    private String namepp,cgpap,twelvep,usnp,phone;
    private Button login,register;
    private ProgressBar mProgressBar;
    @Override
    public void onBackPressed()
    {
        Intent returnMain= new Intent(stuMain.this,MainActivity.class);
        startActivity(returnMain);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main);

        login=findViewById(R.id.login);
        register= findViewById(R.id.register);
        mProgressBar= findViewById(R.id.progressBar);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);

        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/varified_students/");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(stuMain.this,stuRegister.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String usernameEnter = username.getText().toString();
                final String passEnter = password.getText().toString();
                if(usernameEnter.isEmpty() || passEnter.isEmpty())
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Username/Password Empty",Toast.LENGTH_SHORT);
                    toast.show(); }
                    else {
                     mProgressBar.setVisibility(View.VISIBLE);
                        mFirebase.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int f=0;

                                for(DataSnapshot dsp : dataSnapshot.getChildren()){


                                    Map<String,String> map = dsp.getValue(Map.class);

                                    String username = map.get("Username");
                                    String password = map.get("Password");

                                    if(usernameEnter.equals((username)) && passEnter.equals(password)) {
                                        f = 1;
                                        namepp = map.get("Name");
                                        cgpap= map.get("Cgpa");
                                        twelvep= map.get("Twe");
                                        usnp= map.get("Username");
                                        phone=map.get("Phone");

                                    }

                                }



                                if(f==1)
                                {
                                    Toast toast=Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_LONG);
                                    toast.show();
                                    Intent stuDash= new Intent(stuMain.this,student_dashboard.class);
                                    stuDash.putExtra("name",namepp);
                                    stuDash.putExtra("cgpa",cgpap);
                                    stuDash.putExtra("twelve",twelvep);
                                    stuDash.putExtra("USN",usnp);
                                    stuDash.putExtra("Phone",phone);
                                    startActivity(stuDash);
                                }
                                else {
                                    mProgressBar.setVisibility(View.GONE);
                                    Toast toast=Toast.makeText(getApplicationContext(),"Login Failure",Toast.LENGTH_LONG);
                                    toast.show();
                                    mProgressBar.setVisibility(View.GONE);
                                }
                            }

                            @Override
                            public void onCancelled(FirebaseError firebaseError) {

                            }
                        });
                }
            }
        });


    }
}

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

public class tpoMain extends AppCompatActivity {

    private Button login,register;
    private String name;
    private Firebase mFirebase;
    private EditText username,password;
    private ProgressBar mProgressBar;

    public void onBackPressed()
    {
        Intent returnMain2= new Intent(tpoMain.this,MainActivity.class);
        startActivity(returnMain2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_main);

        login=findViewById(R.id.login);
        register= findViewById(R.id.register);
        mProgressBar= findViewById(R.id.progressBar2);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);

        mFirebase=new Firebase("https://easyplacement-72355.firebaseio.com/tpo/");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tpoMain.this,tpoRegister.class);
                startActivity(intent);
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String usernameEnter = username.getText().toString();

                final String passEnter = password.getText().toString();
                if(usernameEnter.isEmpty() || passEnter.isEmpty())
                {Toast toast=Toast.makeText(getApplicationContext(),"Username/Password Empty",Toast.LENGTH_SHORT);
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
                                name= map.get("Name");
                            }

                        }

                        if(f==1)
                        {
                            Toast toast=Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT);
                            toast.show();
                            Intent tpoMainLogin= new Intent(tpoMain.this,tpoDashboard.class);
                            tpoMainLogin.putExtra("uname",name);
                            startActivity(tpoMainLogin);

                        }
                        else {
                            mProgressBar.setVisibility(View.GONE);
                            Toast toast=Toast.makeText(getApplicationContext(),"Login Failure",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }}
        });
    }
}

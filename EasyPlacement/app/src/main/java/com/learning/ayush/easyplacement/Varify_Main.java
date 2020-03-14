package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class Varify_Main extends AppCompatActivity {

    private Firebase mFirebase;
    private EditText secretKey;
    private Button submit;
    private long secretCode;
    @Override
    public void onBackPressed()
    {
        Intent ivarifymain2= new Intent(Varify_Main.this,MainActivity.class);
        startActivity(ivarifymain2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varify__main);

        secretKey= findViewById(R.id.secretKey);
        submit= findViewById(R.id.submitSecret);
        mFirebase= new Firebase("https://easyplacement-72355.firebaseio.com/student_secret/");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long getKey= Long.parseLong(secretKey.getText().toString());

                mFirebase.addValueEventListener(new ValueEventListener() {
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

                if(getKey==secretCode)
                {
                  Intent varifystudents= new Intent(Varify_Main.this,Varify_students.class);
                  startActivity(varifystudents);
                }
                else Toast.makeText(Varify_Main.this,"Wrong Key..!!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

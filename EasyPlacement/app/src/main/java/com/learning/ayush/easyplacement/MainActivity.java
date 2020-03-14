package com.learning.ayush.easyplacement;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button b;
    private Firebase mFirebase;
    private Button studLogin,tpoLogin,varify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studLogin= findViewById(R.id.studentlogin);
        tpoLogin= findViewById(R.id.tpologin);
        varify=findViewById(R.id.varify);

        varify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent varifyMain= new Intent(MainActivity.this,Varify_Main.class);
                startActivity(varifyMain);
            }
        });

        tpoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isInternetOn();
                    Intent intent = new Intent(MainActivity.this,tpoMain.class);
                    startActivity(intent);
            }
        });

        studLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,stuMain.class);
                startActivity(intent);
            }
        });


    }

    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {

            // if connected with internet

            return true;

        } else{
            Toast.makeText(this, " POOR INTERNET CONNECTION..!!!", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}


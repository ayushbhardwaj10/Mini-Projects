package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class tpoDashboard extends AppCompatActivity {

    private CardView addCompanies,checkStatus,attachFiles;
    private TextView welcome;
    public void onBackPressed()
    {
        Intent returnTpoMain= new Intent(tpoDashboard.this,tpoMain.class);
        startActivity(returnTpoMain);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_dashboard);

        addCompanies = findViewById(R.id.addCompanies);
        checkStatus= findViewById(R.id.checkStatus);
        attachFiles= findViewById(R.id.attachFiles);
        welcome = findViewById(R.id.welcomeTpo);

        Intent it= getIntent();
        Bundle bd= it.getExtras();
        String n= bd.getString("uname");
        welcome.setText(n);


        //Adding new companies
        addCompanies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tpo_addCompany= new Intent(tpoDashboard.this,tpo_addCompanies.class);
                startActivity(tpo_addCompany);
            }
        });

        //TPO Checking status
        checkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //attaching files for students
        attachFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}

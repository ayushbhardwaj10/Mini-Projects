package com.learning.ayush.easyplacement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class Varify_students extends AppCompatActivity {

    private RecyclerView r1;
    private varifyAdapter VA;
    @Override
    public void onBackPressed()
    {
        Intent ivarifymain= new Intent(Varify_students.this,Varify_Main.class);
        startActivity(ivarifymain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varify_students);

        r1= findViewById(R.id.studentsToBeVarified);
        VA=new varifyAdapter(this);
        r1.setAdapter(VA);

    }
}

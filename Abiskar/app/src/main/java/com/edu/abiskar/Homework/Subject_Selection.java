package com.edu.abiskar.Homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edu.abiskar.R;

public class Subject_Selection extends AppCompatActivity {

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject__selection);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Abiskar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button_1 = findViewById(R.id.homeworkActivitySUbject_1_ButtonID);
        button_2 = findViewById(R.id.homeworkActivitySUbject_2_ButtonID);
        button_3 = findViewById(R.id.homeworkActivitySUbject_3_ButtonID);
        button_4 = findViewById(R.id.homeworkActivitySUbject_4_ButtonID);
        button_5 = findViewById(R.id.homeworkActivitySUbject_5_ButtonID);
        button_6 = findViewById(R.id.homeworkActivitySUbject_6_ButtonID);
        button_7 = findViewById(R.id.homeworkActivitySUbject_7_ButtonID);
        button_8 = findViewById(R.id.homeworkActivitySUbject_8_ButtonID);
        button_9 = findViewById(R.id.homeworkActivitySUbject_9_ButtonID);
        button_10 = findViewById(R.id.homeworkActivitySUbject_10_ButtonID);
        button_11 = findViewById(R.id.homeworkActivitySUbject_11_ButtonID);

        //Physics 1st Paper
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Physics 2nd Paper
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Chemistry 1st paper
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Chemistry 2nd Paper
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Biology 1st Paper
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Biology 2nd Paper
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Higher Math 1st Paper
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Higher Math 2nd Paper
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //ICT
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //English 1st Paper
        button_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //English 2nd Paper
        button_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    /*@Override
    protected void onDestroy() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(), "Signed out.", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }*/
}
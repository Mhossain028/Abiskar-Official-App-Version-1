package com.edu.abiskar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edu.abiskar.WebView.WebviewActivity;

public class Routine_Link_Activity extends AppCompatActivity {

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine__link_);

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

        button_1 = findViewById(R.id.routineLinkActivitySUbject_1_ButtonID);
        button_2 = findViewById(R.id.routineLinkActivitySUbject_2_ButtonID);
        button_3 = findViewById(R.id.routineLinkActivitySUbject_3_ButtonID);
        button_4 = findViewById(R.id.routineLinkActivitySUbject_4_ButtonID);
        button_5 = findViewById(R.id.routineLinkActivitySUbject_5_ButtonID);
        button_6 = findViewById(R.id.routineLinkActivitySUbject_6_ButtonID);
        button_7 = findViewById(R.id.routineLinkActivitySUbject_7_ButtonID);
        button_8 = findViewById(R.id.routineLinkActivitySUbject_8_ButtonID);
        button_9 = findViewById(R.id.routineLinkActivitySUbject_9_ButtonID);
        button_10 = findViewById(R.id.routineLinkActivitySUbject_10_ButtonID);
        button_11 = findViewById(R.id.routineLinkActivitySUbject_11_ButtonID);

        //Physics 1st Paper
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(Routine_Link_Activity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Physics 2nd Paper
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Routine_Link_Activity.this, "Will update soon.", Toast.LENGTH_LONG).show();
            }
        });

        //Chemistry 1st paper
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Routine_Link_Activity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "chemistry_1st");
                startActivity(intent);
            }
        });

        //Chemistry 2nd Paper
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Routine_Link_Activity.this, "Will update soon.", Toast.LENGTH_LONG).show();
            }
        });

        //Biology 1st Paper
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Routine_Link_Activity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "biology_1st");
                startActivity(intent);
            }
        });

        //Biology 2nd Paper
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Routine_Link_Activity.this, "Will update soon.", Toast.LENGTH_LONG).show();
            }
        });

        //Higher Math 1st Paper
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Routine_Link_Activity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "higher_math_1st");
                startActivity(intent);
            }
        });

        //Higher Math 2nd Paper
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Routine_Link_Activity.this, "Will update soon.", Toast.LENGTH_LONG).show();
            }
        });

        //ICT
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Routine_Link_Activity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "ict");
                startActivity(intent);
            }
        });

        //English 1st Paper
        button_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Routine_Link_Activity.this, "Will update soon.", Toast.LENGTH_LONG).show();
            }
        });

        //English 2nd Paper
        button_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Routine_Link_Activity.this, "Will update soon.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
package com.edu.abiskar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SetAlertTimeActivity extends AppCompatActivity {

    private EditText alertMessageEditText;
    private TimePicker timePicker;
    private Button setAlertButton;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alert_time);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Set Alert");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });*/

        alertMessageEditText = findViewById(R.id.setAlertTimeActivityAlertMessageEditTextID);
        timePicker = findViewById(R.id.setAlertTimeActivityTimePickerID);
        setAlertButton = findViewById(R.id.setAlertTimeActivitySetAlertButtonID);

        //timePicker.setIs24HourView(true);

        setAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer hour = timePicker.getCurrentHour();
                Integer minute = timePicker.getCurrentMinute();
                String alertMessage = alertMessageEditText.getText().toString();

                if (alertMessage.isEmpty()) {
                    alertMessageEditText.setError("Type a alert message please");
                    alertMessageEditText.requestFocus();
                    return;
                }

                databaseReference = FirebaseDatabase.getInstance().getReference("ClassAlertMessage");

                HashMap<String, Object> hashMap = new HashMap<>();

                hashMap.put("hour", hour);
                hashMap.put("minute", minute);
                hashMap.put("alertMessage", alertMessage);

                databaseReference.push().setValue(hashMap);

                Toast.makeText(SetAlertTimeActivity.this, "Input updated in the database successfully.", Toast.LENGTH_LONG).show();

                alertMessageEditText.setText("");
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
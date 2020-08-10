package com.edu.abiskar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {

    private Button setAlertTimeButton, deleteAlertButton, addStudentButton;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Admin Panel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        setAlertTimeButton = findViewById(R.id.adminActivityAddAlertTimeButtonID);
        deleteAlertButton = findViewById(R.id.adminActivityDeleteAllAlertTimeButtonID);
        addStudentButton = findViewById(R.id.adminActivityAddNewStudentButtonID);

        setAlertTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SetAlertTimeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        deleteAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("ClassAlertMessage");
                databaseReference.removeValue();
                Toast.makeText(AdminActivity.this, "Remove all alerts successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddStudent();
            }
        });
    }

    private void AddStudent() {

        AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
        View view = getLayoutInflater().inflate(R.layout.custom_dialog_add_student_layout, null);

        final EditText studentID = view.findViewById(R.id.customDialogAddStudentLayoutStudentIDEditTextID);
        Button cancelButton = view.findViewById(R.id.customDialogAddStudentLayoutCancelButtonID);
        Button addStudentButton = view.findViewById(R.id.customDialogAddStudentLayoutAddStudentButtonID);

        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String temp = studentID.getText().toString().trim();

                if (temp.isEmpty()) {
                    studentID.setError("Enter student id");
                    studentID.requestFocus();
                    return;
                }

                final String email = temp + "@abiskar.com";
                final String password = "123456";

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    studentID.setText("");
                                    Toast.makeText(AdminActivity.this, "Student added successfully. Email: " + email, Toast.LENGTH_SHORT).show();
                                } else {
                                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(AdminActivity.this, "Student is already registered.", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(AdminActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });
            }
        });
        alertDialog.show();
    }

}
package com.edu.abiskar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edu.abiskar.Lecture_Video.Video_Selection_Activity;
import com.edu.abiskar.Model.AlertMessageClass;
import com.edu.abiskar.WebView.WebviewActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplicationActivity extends AppCompatActivity {

    private Button adminPanelButton, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8;
    private FirebaseUser mUser;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Abiskar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);

        mUser = FirebaseAuth.getInstance().getCurrentUser();

        adminPanelButton = findViewById(R.id.applicationActivityAdminPanelButtonID);
        button_1 = findViewById(R.id.applicationActivityButton_1_ButtonID);
        button_2 = findViewById(R.id.applicationActivityButton_2_ButtonID);
        button_3 = findViewById(R.id.applicationActivityButton_3_ButtonID);
        button_4 = findViewById(R.id.applicationActivityButton_4_ButtonID);
        button_5 = findViewById(R.id.applicationActivityButton_5_ButtonID);
        button_6 = findViewById(R.id.applicationActivityButton_6_ButtonID);
        button_7 = findViewById(R.id.applicationActivityButton_7_ButtonID);
        button_8 = findViewById(R.id.applicationActivityButton_8_ButtonID);

        // extra feature for admin panel  (#Rahat #Meraj #Mamun vaia #Ony vaia)
        if (mUser.getUid().toString().equals("G0TwDPdeFqYBav1N3hi144K5zAi1") ||
                mUser.getUid().toString().equals("VlfHzMBYsPcbzrcgH71mtjfHz1B3") ||
                mUser.getUid().toString().equals("XQSayxtyNBROLXuFTddtQXILsvy2") ||
                mUser.getUid().toString().equals("k9svZcUbfCbtf45IKAgW9zIyTr42")) {
            adminPanelButton.setVisibility(View.VISIBLE);
        } else {
            adminPanelButton.setVisibility(View.GONE);
        }

        adminPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        //automatic alarm set.
        MobileAlarmSet();

        //নৈবত্তিক ও সৃজনশীল প্রশ্ন
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(ApplicationActivity.this, MCQ_Srijonshil.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
                Intent intent = new Intent(ApplicationActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "mcq_srijonshil");
                startActivity(intent);
            }
        });

        //ক্লাস ভিডিও
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, Video_Selection_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //শেয়ারকৃত নোট
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "share_note");
                startActivity(intent);
            }
        });

        //Live ক্লাসের রুটিন ও জয়েন লিংক
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "class_routine");
                startActivity(intent);

                /*Intent intent = new Intent(ApplicationActivity.this, Routine_Link_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
            }
        });

        //বাড়ির কাজ
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "home_work");
                startActivity(intent);
                /*Intent intent = new Intent(ApplicationActivity.this, Subject_Selection.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
            }
        });

        //নোটিশ বোর্ড
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "notice_board");
                startActivity(intent);
            }
        });

        //সকল NCTB বইসমূহ
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "nctb_books");
                startActivity(intent);
            }
        });

        //Contact with us
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, ContactUsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void MobileAlarmSet() {
        databaseReference = FirebaseDatabase.getInstance().getReference("ClassAlertMessage");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    AlertMessageClass alertMessageClass = snapshot.getValue(AlertMessageClass.class);

                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, alertMessageClass.getHour());
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, alertMessageClass.getMinute());
                    intent.putExtra(AlarmClock.EXTRA_MESSAGE, alertMessageClass.getAlertMessage());
                    intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    Toast.makeText(getApplicationContext(), "Alarm set successfully.", Toast.LENGTH_LONG).show();
                    startActivity(intent);

                    NotificationService notificationService = new NotificationService();
                    notificationService.displayNotification(getApplicationContext(), "Abiskar Class Alert", alertMessageClass.getAlertMessage());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ApplicationActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_application_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuSignOutID) {
            FirebaseAuth.getInstance().signOut();
            finish();
            Toast.makeText(getApplicationContext(), "Sign out", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alertMessege() {
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(ApplicationActivity.this);

        //for setting title
        alertdialogbuilder.setTitle(R.string.alertTitle);

        //for setting message
        alertdialogbuilder.setMessage(R.string.alertMessege);

        //for setting icon
        alertdialogbuilder.setIcon(R.drawable.alert);

        //for setting buttons
        alertdialogbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();   //for cancel the dialog
                finish();         //for exit the application
            }
        });

        alertdialogbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertdialogbuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertdialogbuilder.setCancelable(false);    //for not cancel the alert dialog for unexpected click.
        AlertDialog alertdialog = alertdialogbuilder.create();
        alertdialog.show();
    }

    @Override
    public void onBackPressed() {
        alertMessege();
    }

   /* @Override
    protected void onDestroy() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(), "Signed out.", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }*/
}
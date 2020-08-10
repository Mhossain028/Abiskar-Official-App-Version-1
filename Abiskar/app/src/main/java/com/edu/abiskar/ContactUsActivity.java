package com.edu.abiskar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.edu.abiskar.WebView.WebviewActivity;

public class ContactUsActivity extends AppCompatActivity {

    private ImageButton phone, facebook, websiteee, gmail;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Abiskar Contact");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        phone = findViewById(R.id.contactUsActivityPhoneImageButtonID);
        facebook = findViewById(R.id.contactUsActivityFacebookImageButtonID);
        websiteee = findViewById(R.id.contactUsActivityPersonalWebsiteImageButtonID);
        gmail = findViewById(R.id.contactUsctivityGmailImageButtonID);
        progressBar = findViewById(R.id.contactUsActivityProgressBarID);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+8801843059970"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "facebook");
                startActivity(intent);
            }
        });

        websiteee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsActivity.this, WebviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("WebCode", "websiteee");
                startActivity(intent);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                String subject = "Abiskar Contact Forum";
                String body = "";
                intent.putExtra(intent.EXTRA_SUBJECT, subject);
                intent.putExtra(intent.EXTRA_TEXT, body);
                intent.putExtra(intent.EXTRA_EMAIL, new String[]{"abiskar.edu@gmail.com"});
                startActivity(Intent.createChooser(intent, " Queries "));
                progressBar.setVisibility(View.GONE);
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
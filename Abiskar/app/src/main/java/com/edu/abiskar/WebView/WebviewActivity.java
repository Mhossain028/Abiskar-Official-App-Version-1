package com.edu.abiskar.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.edu.abiskar.R;

public class WebviewActivity extends AppCompatActivity {

    private WebView webView;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webviewActivityWebviewID);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        Bundle bundle = getIntent().getExtras();
        value = bundle.getString("WebCode");

        if (value.equals("register")) {
            webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfucTQA3JTa4wI69l9FJfmiLCG5We7xutlU3iv-PA6ZaYxJZw/viewform");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("physics_1st")) {
            webView.loadUrl("https://www.youtube.com/playlist?list=PLlWvb0q2Tx0a9tnR3UQSy2BnJagJVM03P");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("chemistry_1st")) {
            webView.loadUrl("https://www.youtube.com/playlist?list=PLlWvb0q2Tx0b9l3wNK3R6nSpsSKLEW6CU");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("biology_1st")) {
            webView.loadUrl("https://www.youtube.com/playlist?list=PLlWvb0q2Tx0bVakYA2chOdyn5oB9Trnh5");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("higher_math_1st")) {
            webView.loadUrl("https://www.youtube.com/playlist?list=PLlWvb0q2Tx0YWKbJEVSfeCiFYUMsH-Hqm");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("ict")) {
            webView.loadUrl("https://www.youtube.com/playlist?list=PLlWvb0q2Tx0YzOmPK84EY5Gk5MYeraN5G");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("mcq_srijonshil")) {
            webView.loadUrl("https://www.abiskar-edu.com/online-exams");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("share_note")) {
            webView.loadUrl("https://www.abiskar-edu.com/students/share-your-notes");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("class_routine")) {
            webView.loadUrl("https://www.abiskar-edu.com/routine");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("home_work")) {
            webView.loadUrl("https://www.abiskar-edu.com/teachers/assign-student-tasks");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("notice_board")) {
            webView.loadUrl("https://www.abiskar-edu.com/others/notice");
            webView.setVisibility(View.VISIBLE);
        } else if (value.equals("nctb_books")) {
            webView.loadUrl("https://www.abiskar-edu.com/others/nctb-books");
            webView.setVisibility(View.VISIBLE);
        }else if (value.equals("facebook")) {
            webView.loadUrl("https://www.facebook.com/abiskar.edu/");
            webView.setVisibility(View.VISIBLE);
        }else if (value.equals("websiteee")) {
            webView.loadUrl("https://www.abiskar-edu.com/");
            webView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    protected void onDestroy() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(), "Signed out.", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }*/
}
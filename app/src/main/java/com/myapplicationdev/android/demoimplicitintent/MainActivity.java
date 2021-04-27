package com.myapplicationdev.android.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEmail;
    EditText editTextMessage;
    Button btnRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        btnEmail = (Button) findViewById(R.id.buttonEmail);
        //btnRP = (Button) findViewById(R.id.buttonWeb);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the action i want the intent to do;
                //ACTION_SEND used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                //put essentials like email address, subj and
                //body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());
                //this MIME type indicates email
                email.setType("message/rfc822");
                //createChooser shows user a list of app that can
                //handle this MIME type which is email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

//        btnRP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
//                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
//                startActivity(rpIntent);
//            }
//        });
    }
}
package com.example.jitsisetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        //To implement onIDReceive from first MainActivity - start meet with received meet ID and server address
        if(intent.hasExtra("MEET_ID") && intent.hasExtra("SERVER_ADDRESS")) {
            //EditText editText = findViewById(R.id.meet_name);
            //editText.setText(intent.getStringExtra("MEET_ID"));

            //EditText editText2 = findViewById(R.id.server_url);
            //editText2.setText(intent.getStringExtra("SERVER_ADDRESS"));
            String meet=intent.getStringExtra("MEET_ID");
            String server=intent.getStringExtra("SERVER_ADDRESS");

            assert meet != null;
            assert server != null;
            if(meet.length()>0 && server.length()>0) {
                try {
                    joinMeet(meet, server);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void joinMeet(View v) throws MalformedURLException {
        EditText editText = findViewById(R.id.meet_name);
        String meet =  editText.getText().toString();

        EditText editText2 = findViewById(R.id.server_url);
        String server =  editText2.getText().toString();

        if(meet.length()>0 && server.length()>0) {

            JitsiMeetConferenceOptions
                    options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(server))
                    .setRoom(meet)
                    .build();

            JitsiMeetActivity.launch(this, options);

        }
    }

    public void joinMeet(String meet, String server) throws MalformedURLException {
        JitsiMeetConferenceOptions
                options = new JitsiMeetConferenceOptions.Builder()
                .setServerURL(new URL(server))
                .setRoom(meet)
                .build();

        JitsiMeetActivity.launch(this, options);

    }

    public void returnActivity(View v) {
        //Modify MainActivity.class to <OriginalActivity>.class to return to original activity that called it in actual app using an intent
        Intent intent = new Intent(this, MainActivity.class);

        //TEST CODE TO CHECK ABSTRACTION OF MODULE
        //USE WITH MainActivity.class intent

        //TEST CODE FOR DEFAULT LAUNCH OF ACTIVITY 1
        //intent.putExtra("DEFAULT","1");

        //TEST CODE FOR MEET ID AND SERVER ADDRESS GIVEN TO ACTIVITY 1
        //intent.putExtra("MEET_ID","HelloMate");
        //intent.putExtra("SERVER_ADDRESS","https://meet.jit.si");

        startActivity(intent);
    }
}
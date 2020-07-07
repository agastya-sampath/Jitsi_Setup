package com.example.jitsisetup;

import androidx.appcompat.app.AppCompatActivity;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if(intent.hasExtra("MEET_ID") && intent.hasExtra("SERVER_ADDRESS")) {
            //String meet_id = intent.getStringExtra("MEET_ID");
            //String server_address = intent.getStringExtra("SERVER_ADDRESS");
            onIDReceive(intent);
        }
        else if(intent.hasExtra("DEFAULT")) {
            try {
                onDefaultClick(getCurrentFocus());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public void onDefaultClick(View v) throws MalformedURLException {
        String text= getString(R.string.meet_id);
        String server= getString(R.string.server_address);
        JitsiMeetConferenceOptions
            options = new JitsiMeetConferenceOptions.Builder()
            .setServerURL(new URL(server))
            .setRoom(text)
            .build();

        JitsiMeetActivity.launch(this, options);
    }

    public void onIDClick(View v) {
        Intent intent= new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onIDReceive(Intent intent) {
        Intent intent2= new Intent(this, MainActivity2.class);
        intent2.putExtra("MEET_ID",intent.getStringExtra("MEET_ID"));
        intent2.putExtra("SERVER_ADDRESS",intent.getStringExtra("SERVER_ADDRESS"));
        startActivity(intent2);
    }


}
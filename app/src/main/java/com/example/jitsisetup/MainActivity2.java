package com.example.jitsisetup;

import androidx.appcompat.app.AppCompatActivity;

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
}
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


}
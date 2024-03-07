package io.hextree.flagproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChallengeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        // which button should you press?
        View.OnClickListener failHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeActivity.this, MainActivity.class));
            }
        };

        findViewById(R.id.button1).setOnClickListener(failHandler);
        findViewById(R.id.button2).setOnClickListener(failHandler);
        findViewById(R.id.button3).setOnClickListener(failHandler);
        findViewById(R.id.button4).setOnClickListener(failHandler);
        findViewById(R.id.button5).setOnClickListener(failHandler);
        findViewById(R.id.button6).setOnClickListener(failHandler);
        findViewById(R.id.button7).setOnClickListener(failHandler);
        findViewById(R.id.button8).setOnClickListener(failHandler);
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeActivity.this, FlagActivity.class));
            }
        });
        findViewById(R.id.button10).setOnClickListener(failHandler);
    }
}
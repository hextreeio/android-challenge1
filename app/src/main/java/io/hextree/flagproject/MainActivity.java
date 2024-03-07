package io.hextree.flagproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this is the main activity... how to get to the challenge?
        TextView text = findViewById(R.id.main_text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                text.setText("Counter: "+counter);
                if(counter>9999) {
                    startActivity(new Intent(MainActivity.this, ChallengeActivity.class));
                }
            }
        });

    }
}
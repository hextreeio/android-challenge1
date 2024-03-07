package io.hextree.flagproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;


public class FlagActivity extends AppCompatActivity {

    int progressTracking = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        // how to reveal the flag now?
        TextView text = findViewById(R.id.flag_text);
        SeekBar bar = findViewById(R.id.seek_bar);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text.setText("Read the code: "+progress+"%");
                progressTracking = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Success!!! Show the flag now!
                if(progressTracking==42) {
                    text.setText(decryptFlag());
                }
            }
        });
    }

    // You could reverse engineer this function to find the flag, but it's probably faster if
    // you just read the activity code.
    // How do you get to this FlagActivity? What actions do you have to perform?
    // Run this project in the emulator and perform those actions to reveal the flag.
    String decryptFlag() {

        String z1 = a(getResources().getString(b(c.d.e)));
        int z2 = z1.length(), z3 = 0x10;
        byte[] z4 = new byte[z2 / 2];
        for (int z5 = 0; z5 < z2; z5 += 2) {
            z4[z5 / 2] = (byte) ((Character.digit(z1.charAt(z5), z3) << 4)
                    + Character.digit(z1.charAt(z5 + 1), z3));
        }

        String z6 = a(getResources().getString(b(c.f.g)));
        byte[] z7 = Base64.decode(z6, Base64.DEFAULT);
        //byte[] z7 = z6.getBytes();
        byte[] z8 = new byte[z7.length];
        for (int z9 = 0; z9 < z7.length; z9++) {
            z8[z9] = (byte) (z7[z9] ^ z4[z9 % z4.length]);
        }

        Log.i("FLAG", new String(z8));
        Log.i("base64.FLAG", new String(Base64.encode(z8, Base64.DEFAULT)));

        return new String(z8);
    }
    String a(String s) { return s; }
    int b(int i) { return i; }
    interface c {
        interface d { int e = R.string.challenge_secret_key; }
        interface f { int g = R.string.secret; }
    }
}
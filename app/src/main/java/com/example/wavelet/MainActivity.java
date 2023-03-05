package com.example.wavelet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Vibrator vibrator;
    private ImageView start_stop;
    public int mode;
    public int interval;
    public double duration;

    public void Show(View start_stop) {
        start_stop.setVisibility(View.VISIBLE);
    }
    public void Hide(View start_stop) {
        start_stop.setVisibility(View.INVISIBLE);
    }
    ImageButton check;
    AppCompatActivity aca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interval=0;
        aca=this;

        mode =  0;
        start_stop = (ImageView) findViewById(R.id.start_stop_button);
        Fragment vbm = new VibrationMenu(this);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        start_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.main_activity, vbm).commit();
            }

            public void vibrate(){
                vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
            }
        });
        check =findViewById(R.id.checkbutton);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interval==0) {
                    Toast.makeText(aca, "Please select something", Toast.LENGTH_LONG);
                }else{
                    check.setBackgroundColor(450000);

                }
            }
        });
    }
}
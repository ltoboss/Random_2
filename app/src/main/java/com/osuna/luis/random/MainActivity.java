package com.osuna.luis.random;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView a,b,c;
    View vi, vBotones, circle, zoneplay;
    private static final int TIMER_LENGTH = 20;
    private Drawer drawer;
    Button op1,op2,op3,op4,op5,send;
    int intentos, letter;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        letter = 0;
        intentos =0;
        Button button = (Button) findViewById(R.id.btnClick);
        name = (EditText) findViewById(R.id.txtPokemon);
        ButtonsDeclare();
        VisibilityThings();

        drawer = (Drawer) findViewById(R.id.timer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RandomLetter();
                BeginCounter();
                vi = getWindow().getDecorView().getRootView();
                drawer.start(TIMER_LENGTH);
                VisibilityThings();
            }
        });
    }

    public void RandomLetter(){
        int num1 = 97;
        int num2 = 122;
        char c = 0;
        int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
        c = (char) numAleatorio;
        b = (TextView) (TextView) findViewById(R.id.txtLetter);
        b.setText(String.valueOf(c).toUpperCase());

        if(letter == 0)
            op1.setText(String.valueOf(c).toUpperCase());
        if(letter == 1)
            op2.setText(String.valueOf(c).toUpperCase());
        if(letter == 2)
            op3.setText(String.valueOf(c).toUpperCase());
        if(letter == 3)
            op4.setText(String.valueOf(c).toUpperCase());
        if(letter == 4)
            op5.setText(String.valueOf(c).toUpperCase());
    }

    public void BeginCounter(){
        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {

                c = (TextView) findViewById(R.id.txtTime);
                long time = (millisUntilFinished / 1000) - 1;


                c.setText(time + " segundos");
                //here you can have your logic to set text to edittext
            }

            @SuppressLint("ResourceAsColor")
            public void onFinish() {

                if(letter == 0)
                    op1.setBackgroundColor(R.color.timer_circle);
                if(letter == 1)
                    op2.setBackgroundColor(R.color.timer_circle);
                if(letter == 2)
                    op3.setBackgroundColor(R.color.timer_circle);
                if(letter == 3)
                    op4.setBackgroundColor(R.color.timer_circle);
                if(letter == 4)
                    op5.setBackgroundColor(R.color.timer_circle);

                letter++;
                c.setText("Tiempo agotado.");
                ChangeColorBackground();
            }

        }.start();
    }

    public void ButtonsDeclare(){

        op1 = (Button) findViewById(R.id.btnOpor1);
        op2 = (Button) findViewById(R.id.btnOpor2);
        op3 = (Button) findViewById(R.id.btnOpor3);
        op4 = (Button) findViewById(R.id.btnOpor4);
        op5 = (Button) findViewById(R.id.btnOpor5);
        send = (Button) findViewById(R.id.btnSendName);

        op1.setEnabled(false);
        op2.setEnabled(false);
        op3.setEnabled(false);
        op4.setEnabled(false);
        op5.setEnabled(false);
    }

    public void ChangeColorBackground(){

        new CountDownTimer(1500, 100) {
            int a = 0;
            public void onTick(long millisUntilFinished) {
                if (a == 0){
                    vi.setBackgroundColor(Color.argb(255, 255, 0, 0));
                    a = 1;
                }else{
                    vi.setBackgroundColor(Color.argb(255, 0, 0, 255));
                    a = 0;
                }
            }

            public void onFinish() {
                vi.setBackgroundColor(Color.argb(255, 255, 255, 255));
            }
        }.start();
    }

    public void VisibilityThings(){
        vBotones = (View) findViewById(R.id.Buttons);
        zoneplay = (View) findViewById(R.id.zonePlay);
        circle = (View) findViewById(R.id.Circle);

        if (vBotones.getVisibility() == View.GONE){
            vBotones.setVisibility(View.VISIBLE);
            zoneplay.setVisibility(View.VISIBLE);
            circle.setVisibility(View.VISIBLE);
        }else{
            vBotones.setVisibility(View.GONE);
            zoneplay.setVisibility(View.GONE);
            circle.setVisibility(View.GONE);
        }

    }

}



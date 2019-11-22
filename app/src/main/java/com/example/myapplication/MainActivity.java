package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    float x;
    float y;
    float sDown;
    String sMove;
    String sUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(this);
        ConstraintLayout root =findViewById(R.id.root);
        root.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        TextView t=findViewById(R.id.textView);
        switch  (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                sDown=x+','+y;
                sMove = "";
                break;
            case MotionEvent.ACTION_MOVE:
                sMove =x + "," + y;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = + x + "," + y;
                break;
        }
        t.setText("\n"+sDown+"\n"+sMove+"\n"+sUp);
        return true;
    }
        }
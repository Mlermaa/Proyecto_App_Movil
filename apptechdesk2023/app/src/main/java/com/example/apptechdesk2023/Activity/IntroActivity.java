package com.example.apptechdesk2023.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apptechdesk2023.R;

public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout inicioBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        inicioBtn = findViewById(R.id.inicioBtn);
        inicioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }

        });
    }
}
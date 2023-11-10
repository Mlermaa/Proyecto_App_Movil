package com.example.apptechdesk2023.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apptechdesk2023.R;
import com.example.apptechdesk2023.ui.login.LoginActivity;

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
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
             }

        });
    }
}
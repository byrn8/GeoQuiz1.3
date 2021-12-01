package com.example.geoquiz13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DifficultySelection extends AppCompatActivity {

    private Button easy, normal, hard, insane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);

        easy = findViewById(R.id.easy_button);
        easy.setOnClickListener(v -> openEasyPage());

        normal = findViewById(R.id.normal_button);
        normal.setOnClickListener(v -> openNormalPage());

        hard = findViewById(R.id.hard_button);
        hard.setOnClickListener(v -> openHardPage());

        insane = findViewById(R.id.insane_button);
        insane.setOnClickListener(v -> openInsanePage());
    }

    private void openEasyPage() {
        Intent in = new Intent(this, EasyQuestions.class);
        startActivity(in);
    }

    private void openNormalPage() {
        Intent in = new Intent(this, NormalQuestions.class);
        startActivity(in);
    }

    private void openHardPage() {
        Intent in = new Intent(this, HardQuestions.class);
        startActivity(in);
    }

    private void openInsanePage() {
        Intent in = new Intent(this, InsaneQuestions.class);
        startActivity(in);
    }
}
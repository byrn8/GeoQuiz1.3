package com.example.geoquiz13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    private Button home;
    private TextView result;
    int quizScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        home = findViewById(R.id.home_button);
        home.setOnClickListener(v -> openHomePage());

        result = findViewById(R.id.result);

        result.setText("You got " + quizScore + " out of 10!");
    }

    private void openHomePage() {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}
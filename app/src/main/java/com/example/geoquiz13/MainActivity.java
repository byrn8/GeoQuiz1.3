package com.example.geoquiz13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button help, leaderboard, start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leaderboard = findViewById(R.id.leaderboard_button);
        leaderboard.setOnClickListener(v -> openLeaderboardPage());

        start = findViewById(R.id.start_button);
        start.setOnClickListener(v -> openDifficultyPage());
    }

    private void openLeaderboardPage() {
        Intent in = new Intent(this, LeaderBoard.class);
        startActivity(in);
    }

    private void openDifficultyPage() {
        Intent in = new Intent(this, DifficultySelection.class);
        startActivity(in);
    }
}
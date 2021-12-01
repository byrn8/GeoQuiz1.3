package com.example.geoquiz13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class InsaneQuestions extends AppCompatActivity {

    private List<QuestionTemplate> questionList;

    private QuestionTemplate currentQuestion;

    int questionNumber, quizScore;
    int questionCounter = 0;

    boolean isRunning;

    private TextView question, timer, score;
    private Button button1, button2, button3, button4, next;

    CountDownTimer questionTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insane_questions);

        questionList = new ArrayList<>();
        question = findViewById(R.id.question_text);
        timer = findViewById(R.id.timer);
        score = findViewById(R.id.score);
        button1 = findViewById(R.id.option1);
        button2 = findViewById(R.id.option2);
        button3 = findViewById(R.id.option3);
        button4 = findViewById(R.id.option4);
        next = findViewById(R.id.next_button);

        addQuestion();
        questionNumber = questionList.size();
        createQuestion();

        button1.setOnClickListener(v -> {
            questionTimer.cancel();
            if("option1" == currentQuestion.getAnswer() && isRunning == true) {
                button1.setBackgroundColor(Color.GREEN);
                Toast.makeText(InsaneQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button1.setBackgroundColor(Color.RED);
                Toast.makeText(InsaneQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

                if("option2" == currentQuestion.getAnswer()) {
                    button2.setBackgroundColor(Color.GREEN);
                }
                else if("option3" == currentQuestion.getAnswer()) {
                    button3.setBackgroundColor(Color.GREEN);
                }
                else {
                    button4.setBackgroundColor(Color.GREEN);
                }
                isRunning = false;
            }
        });

        button2.setOnClickListener(v -> {
            questionTimer.cancel();
            if("option2" == currentQuestion.getAnswer() && isRunning == true) {
                button2.setBackgroundColor(Color.GREEN);
                Toast.makeText(InsaneQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button2.setBackgroundColor(Color.RED);
                Toast.makeText(InsaneQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

                if("option1" == currentQuestion.getAnswer()) {
                    button1.setBackgroundColor(Color.GREEN);
                }
                else if("option3" == currentQuestion.getAnswer()) {
                    button3.setBackgroundColor(Color.GREEN);
                }
                else {
                    button4.setBackgroundColor(Color.GREEN);
                }
                isRunning = false;
            }
        });

        button3.setOnClickListener(v -> {
            questionTimer.cancel();
            if("option3" == currentQuestion.getAnswer() && isRunning == true) {
                button3.setBackgroundColor(Color.GREEN);
                Toast.makeText(InsaneQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button3.setBackgroundColor(Color.RED);
                Toast.makeText(InsaneQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

                if("option1" == currentQuestion.getAnswer()) {
                    button1.setBackgroundColor(Color.GREEN);
                }
                else if("option2" == currentQuestion.getAnswer()) {
                    button2.setBackgroundColor(Color.GREEN);
                }
                else {
                    button4.setBackgroundColor(Color.GREEN);
                }
                isRunning = false;
            }
        });

        button4.setOnClickListener(v -> {
            questionTimer.cancel();
            if("option4" == currentQuestion.getAnswer() && isRunning == true) {
                button4.setBackgroundColor(Color.GREEN);
                Toast.makeText(InsaneQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button4.setBackgroundColor(Color.RED);
                Toast.makeText(InsaneQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

                if("option1" == currentQuestion.getAnswer()) {
                    button1.setBackgroundColor(Color.GREEN);
                }
                else if("option2" == currentQuestion.getAnswer()) {
                    button2.setBackgroundColor(Color.GREEN);
                }
                else {
                    button3.setBackgroundColor(Color.GREEN);
                }
                isRunning = false;
            }
        });

        next.setOnClickListener(v -> {
            if (questionCounter == questionNumber - 1) {
                next.setOnClickListener(x -> openResultsPage());
            }
            if (isRunning == true) {
                Toast.makeText(InsaneQuestions.this, "You need to select an answer!", Toast.LENGTH_SHORT).show();
            }
            else {
                questionTimer.cancel();
                createQuestion();
            }
        });
    }

    private void openResultsPage() {
        Intent in = new Intent(this, ResultScreen.class);
        startActivity(in);
    }

    private void createQuestion() {

        score.setText(quizScore + "/10");

        isRunning = true;

        button1.setBackgroundColor(Color.BLUE);
        button2.setBackgroundColor(Color.BLUE);
        button3.setBackgroundColor(Color.BLUE);
        button4.setBackgroundColor(Color.BLUE);

        qTimer();

        if (questionCounter < questionNumber) {
            currentQuestion = questionList.get(questionCounter);
            question.setText(currentQuestion.getQuestion());
            button1.setText(currentQuestion.getOption1());
            button2.setText(currentQuestion.getOption2());
            button3.setText(currentQuestion.getOption3());
            button4.setText(currentQuestion.getOption4());
            questionCounter++;
        }
        else {
            finish();
        }
    }

    private void qTimer() {
        questionTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { ;
                timer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                isRunning = false;
                if("option1" == currentQuestion.getAnswer()) {
                    button1.setBackgroundColor(Color.GREEN);
                }
                else if("option2" == currentQuestion.getAnswer()) {
                    button2.setBackgroundColor(Color.GREEN);
                }
                else if("option3" == currentQuestion.getAnswer()) {
                    button3.setBackgroundColor(Color.GREEN);
                }
                else if("option4" == currentQuestion.getAnswer()) {
                    button4.setBackgroundColor(Color.GREEN);
                }
            }
        }.start();
    }

    private void addQuestion() {
        questionList.add(new QuestionTemplate("What is the capital of Poland?", "Krakow", "Warsaw", "Berlin", "London", "option2"));
        questionList.add(new QuestionTemplate("What is the capital of Germany?", "Bremen", "Berlin", "Bavaria", "Frankfurt", "option2"));
        questionList.add(new QuestionTemplate("What is the capital of Czechia?", "Prague", "Kiev", "Bratislava", "Danube", "option1"));
        questionList.add(new QuestionTemplate("What is the capital of Australia?", "Perth", "Sydney", "Melbourne", "Canberra", "option4"));
        questionList.add(new QuestionTemplate("What is the capital of Canada?", "Vancouver", "Calgary", "Ottawa", "Edmonton", "option3"));
        questionList.add(new QuestionTemplate("What is the capital of Egypt?", "Cairo", "Amman", "Tripoli", "Riyadh", "option1"));
        questionList.add(new QuestionTemplate("What is the capital of Peru?", "Lima", "Caracas", "San Tiago", "Havana", "option1"));
        questionList.add(new QuestionTemplate("What is the capital of New Zealand?", "Auckland", "Hamilton", "Wellington", "Brisbane", "option3"));
        questionList.add(new QuestionTemplate("What is the capital of Ireland?", "Limerick", "Belfast", "Dublin", "Cardiff", "option3"));
        questionList.add(new QuestionTemplate("What is the capital of Spain?", "Rome", "Barcelona", "Lisbon", "Madrid", "option4"));
    }
}
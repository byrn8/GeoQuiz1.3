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

public class HardQuestions extends AppCompatActivity {

    private List<QuestionTemplate> questionList;

    private QuestionTemplate currentQuestion;

    int questionNumber, quizScore;
    int questionCounter = 0;

    boolean isRunning; //Used to correct various errors found in the code

    private TextView question, timer, score;
    private Button button1, button2, button3, button4, next;

    CountDownTimer questionTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_questions);

        questionList = new ArrayList<>();
        question = findViewById(R.id.question_text);
        timer = findViewById(R.id.timer);
        score = findViewById(R.id.score);
        button1 = findViewById(R.id.option1);
        button2 = findViewById(R.id.option2);
        button3 = findViewById(R.id.option3);
        button4 = findViewById(R.id.option4);
        next = findViewById(R.id.next_button);

        addQuestion(); //This method holds the values for the questions
        questionNumber = questionList.size();
        createQuestion(); //This method displays the questions on screen

        button1.setOnClickListener(v -> {
            questionTimer.cancel();
            if("option1" == currentQuestion.getAnswer() && isRunning == true) {
                button1.setBackgroundColor(Color.GREEN); //Sets the correct button to colour green (if user selected correct answer)
                Toast.makeText(HardQuestions.this, "Correct", Toast.LENGTH_SHORT).show(); //output correct toast
                quizScore++;
                isRunning = false; //Boolean user to confirm whether a user has answered already
            }
            else if (isRunning == true) {
                button1.setBackgroundColor(Color.RED); //Sets the incorrect button to colour red
                Toast.makeText(HardQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show(); //output incorrect toast

                if("option2" == currentQuestion.getAnswer()) {
                    button2.setBackgroundColor(Color.GREEN); //Sets the correct button to colour green (if user selected incorrect answer)
                }
                else if("option3" == currentQuestion.getAnswer()) {
                    button3.setBackgroundColor(Color.GREEN); //Sets the correct button to colour green (if user selected incorrect answer)
                }
                else {
                    button4.setBackgroundColor(Color.GREEN); //Sets the correct button to colour green (if user selected incorrect answer)
                }
                isRunning = false;
            }
        });

        button2.setOnClickListener(v -> { //Check button 1 for comments about this
            questionTimer.cancel();
            if("option2" == currentQuestion.getAnswer() && isRunning == true) {
                button2.setBackgroundColor(Color.GREEN);
                Toast.makeText(HardQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button2.setBackgroundColor(Color.RED);
                Toast.makeText(HardQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

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

        button3.setOnClickListener(v -> { //Check button 1 for comments about this
            questionTimer.cancel();
            if("option3" == currentQuestion.getAnswer() && isRunning == true) {
                button3.setBackgroundColor(Color.GREEN);
                Toast.makeText(HardQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button3.setBackgroundColor(Color.RED);
                Toast.makeText(HardQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

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

        button4.setOnClickListener(v -> { //Check button 1 for comments about this
            questionTimer.cancel();
            if("option4" == currentQuestion.getAnswer() && isRunning == true) {
                button4.setBackgroundColor(Color.GREEN);
                Toast.makeText(HardQuestions.this, "Correct", Toast.LENGTH_SHORT).show();
                quizScore++;
                isRunning = false;
            }
            else if (isRunning == true) {
                button4.setBackgroundColor(Color.RED);
                Toast.makeText(HardQuestions.this, "Incorrect", Toast.LENGTH_SHORT).show();

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
                next.setOnClickListener(x -> openMainActivity());
                //displays the results screen when the final question ahs been answered
            }
            if (isRunning == true) {
                Toast.makeText(HardQuestions.this, "You need to select an answer!", Toast.LENGTH_SHORT).show();
                //displays a toast if the user clicks 'next' before selecting an answer
            }
            else {
                questionTimer.cancel(); //terminates the timer
                createQuestion(); //creates a new question if a user has selected an answer
            }
        });
    }

    private void openMainActivity() {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in); //Send user to home page when quiz is finished
    }

    private void createQuestion() {

        score.setText(quizScore + "/10"); //updates the user score for every question

        isRunning = true;

        button1.setBackgroundColor(Color.parseColor("#FF03DAC5")); //resets the background colour for new questions
        button2.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        button3.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        button4.setBackgroundColor(Color.parseColor("#FF03DAC5"));

        qTimer();

        if (questionCounter < questionNumber) { //updates page with new question
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
                timer.setText("" + millisUntilFinished / 1000); //Show timer in seconds
            }

            @Override
            public void onFinish() {
                isRunning = false;
                if("option1" == currentQuestion.getAnswer()) {
                    button1.setBackgroundColor(Color.GREEN); //If option 1 was correct change colour to green
                }
                else if("option2" == currentQuestion.getAnswer()) {
                    button2.setBackgroundColor(Color.GREEN); //If option 2 was correct change colour to green
                }
                else if("option3" == currentQuestion.getAnswer()) {
                    button3.setBackgroundColor(Color.GREEN); //If option 3 was correct change colour to green
                }
                else if("option4" == currentQuestion.getAnswer()) {
                    button4.setBackgroundColor(Color.GREEN); //If option 4 was correct change colour to green
                }
            }
        }.start();
    }

    private void addQuestion() {
        questionList.add(new QuestionTemplate("What is the capital of Mongolia?", "Chinggis", "Turpan", "Irkutsk", "Ulaanbaatar", "option4"));
        questionList.add(new QuestionTemplate("What is the capital of Sri Lanka?", "Kochi", "Medan", "Colombo", "Kandy", "option3"));
        questionList.add(new QuestionTemplate("What is the capital of Kenya?", "Nairobi", "Mombasa", "Kampala", "Cape Town", "option1"));
        questionList.add(new QuestionTemplate("What is the capital of Bolivia?", "Sucre", "La Paz", "Campinas", "Santa Cruz", "option2"));
        questionList.add(new QuestionTemplate("What is the capital of Estonia?", "Vyborg", "Tartu", "Tallinn", "Riga", "option3"));
        questionList.add(new QuestionTemplate("What is the capital of Taiwan?", "Quanzhou", "Tainan", "Xiamen", "Taipei", "option4"));
        questionList.add(new QuestionTemplate("What is the capital of Algeria?", "Tripoli", "Jeddah", "Rabat", "Algiers", "option4"));
        questionList.add(new QuestionTemplate("What is the capital of Switzerland?", "Bern", "Zurich", "Geneva", "Salzburg", "option1"));
        questionList.add(new QuestionTemplate("What is the capital of Nepal?", "Patna", "Kathmandu", "Jaipur", "Karachi", "option2"));
        questionList.add(new QuestionTemplate("What is the capital of Iran?", "Baghdad", "Tehran", "Damascus", "Shiraz", "option2"));
    }
}
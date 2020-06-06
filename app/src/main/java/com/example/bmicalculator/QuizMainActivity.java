package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class QuizMainActivity extends AppCompatActivity {

    private EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        Button startQuizButton = findViewById(R.id.startQuiz);
        nameText = findViewById(R.id.nameEnterText);
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchQuizQuestionsActivity();
            }
        });

    }

    private void launchQuizQuestionsActivity() {
        Intent intent= new Intent(this, QuizQuestionsActivity.class);
        String name=nameText.getText().toString();
        intent.putExtra("userName", name);
        startActivity(intent);
    }


}

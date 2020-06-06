package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizQuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button quitbutton,submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "W jakim kraju miała początek epidemia koronawirusa",
            "W którym roku pojawiły się pierwsze przypadki zachorowań",
            "Który z krajów europejskich był pierwszy w którym epidemia się rozprzestrzeniła znacząco",
            "Jaki uklad atakiuje wirus",
            "Jaki jest najpoważniejszy skutek choroby",
            "Ile czasu mija od zarażenia do pierwszych objawów"
    };
    String answers[] = {"Chiny","2019","Włochy","Układ oddechowy","Śmierć","0-14 dni"};
    String opt[] = {
            "Japonia","Chiny","Korea Północna","USA",
            "2017","2018","2019","2020",
            "Hiszpania","Włochy","Grecja","Francja",
            "Układ krwionośny","Układ oddechowy","Układ nerwowy","Układ immunologiczny",
            "Śmierć","Niepełnosprawność","Syndrom Downa","Autyzm",
            "Kilka godzin","0-14 dni","3 tygodnie","4 tygodnie"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("userName");

        if (name.trim().isEmpty())
            textView.setText(R.string.helllo_user);
        else
            textView.setText(R.string.hello + name);

        submitbutton=findViewById(R.id.button3);
        quitbutton=findViewById(R.id.buttonquit);
        tv= findViewById(R.id.tvque);

        radio_g=findViewById(R.id.answersgrp);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), R.string.select_at_least_one, Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), R.string.correct, Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), R.string.wrong, Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),QuizScoreActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuizScoreActivity.class);
                startActivity(intent);
            }
        });
    }

}
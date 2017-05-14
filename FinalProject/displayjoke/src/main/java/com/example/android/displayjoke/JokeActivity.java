package com.example.android.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static String  joke_key ="joke_key";
    TextView tv_joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        tv_joke = (TextView)findViewById(R.id.tv_joke);
        Intent intent = getIntent();
        tv_joke.setText(intent.getStringExtra(joke_key));
    }
}

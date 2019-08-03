package com.example.study_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("greetingBundle");
        String greeting = bundle.getString("greeting");
        String message = intent.getStringExtra("message");
        Boolean showAll = intent.getBooleanExtra("showAll", false);
        int numItems = intent.getIntExtra("numItems", 0);
        TextView t = (TextView)findViewById(R.id.textView1);
        t.setText("Это вторая активность: " + greeting + " " + message + " " + showAll + " " + numItems);
        Button b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}

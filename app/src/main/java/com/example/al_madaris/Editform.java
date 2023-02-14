package com.example.al_madaris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Editform extends AppCompatActivity {
    DBHandler db;
    Intent intent;
    Button updatabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editform);

        intent = getIntent();
        db = new DBHandler(this);
    }
}
package com.example.al_madaris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Recyclerview extends AppCompatActivity {
    DBHandler db;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Intent intent,editbtnintent;
    Button editbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        editbtn = findViewById(R.id.editbtnlayout);


        intent = getIntent();
        db = new DBHandler(this);

        List<Student> studentList = db.getStudentRecord();

        recyclerView = findViewById(R.id.recyclebox);


        layoutManager = new LinearLayoutManager(Recyclerview.this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(studentList) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

//        editbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editbtnintent = new Intent(Recyclerview.this , Editform.class);
//                startActivity(editbtnintent);
//            }
//        });

    }


}
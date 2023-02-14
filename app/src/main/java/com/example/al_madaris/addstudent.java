package com.example.al_madaris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addstudent extends AppCompatActivity {
   // Intent intent;
    Button addstudentbtn;
    EditText nametxt , rollnotxt , fathercontact , para , ayatfrom , ayatto , sabki , manzil;
    Intent intent;
    DBHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);

        intent = getIntent();
        db = new DBHandler(this);

        addstudentbtn = findViewById(R.id.submitbtn);
        nametxt = findViewById(R.id.nametxt);
        rollnotxt = findViewById(R.id.rollnotxt);
        fathercontact = findViewById(R.id.fathertxt);
        para = findViewById(R.id.paratxt);
        ayatfrom = findViewById(R.id.fromverse);
        ayatto = findViewById(R.id.toverse);
        sabki = findViewById(R.id.sabki);
        manzil = findViewById(R.id.manzil);


        addstudentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametxt.getText().toString();
                String rollno = rollnotxt.getText().toString();
                String fathercon = fathercontact.getText().toString();
                String parano = para.getText().toString();
                String ayatfr = ayatfrom.getText().toString();
                String ayatt = ayatto.getText().toString();
                String sabk = sabki.getText().toString();
                String manzl = manzil.getText().toString();

                Student s = new Student(name , rollno , fathercon,parano,ayatfr,ayatt,sabk,manzl);
                db.insertStudent(s);


                Toast.makeText(addstudent.this,"Student Sucessfully Added",Toast.LENGTH_LONG);

                intent = new Intent(addstudent.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
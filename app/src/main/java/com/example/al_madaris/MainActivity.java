package com.example.al_madaris;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button studentaddbtn , studentdelbtn , studentviewbtn;
    Intent addstudent , viewstudent;
    // below 3 lines are for dialog
    ArrayList<CharSequence> arrayListCollection = new ArrayList<>();
    ArrayAdapter<CharSequence> adapter;
    EditText txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentaddbtn = findViewById(R.id.addbtn);
        studentdelbtn = findViewById(R.id.removebtn);
        studentviewbtn = findViewById(R.id.viewbtn);


        studentaddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addstudent = new Intent(MainActivity.this , addstudent.class);
                startActivity(addstudent);

            }
        });

        studentviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewstudent  = new Intent(MainActivity.this , Recyclerview.class);
                startActivity(viewstudent);
            }
        });

        studentdelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final EditText editTextName1 = new EditText(MainActivity.this);

                //builder.setMessage("Roll No");
                builder.setTitle("Delete Student");
                editTextName1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);
                editTextName1.setHint("Roll No");
                builder.setView(editTextName1);

                builder.setCancelable(true); // yai es liye hai jb dialog box aye ga ager ap es diaglog box sai bahir click krain ge wo diaglog box khtm ho jaye ga , ager fall ho ga to dialog box khtm ni ho ga
                builder.setPositiveButton("Delete",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int asdf) {
                                DBHandler db;
                                        db = new DBHandler(MainActivity.this);
                                db.deleteStudent(editTextName1.getText().toString());
                                //  String asdfg = getString(editTextName1);

                                Toast.makeText(MainActivity.this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).setNegativeButton("Cancil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
}
    });
}
}
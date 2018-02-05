package com.example.aaron.yuntao1_subbook;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    Book book ;
    Button ADD;
    TextView DATE;
    TextView NAME;
    TextView Amount;
    TextView Comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        book = new Book ("New Book");
        ADD = (Button) findViewById(R.id.ADD);
        DATE = (TextView) findViewById(R.id.Date);
        NAME = (TextView) findViewById(R.id.NAME);
        Amount = (TextView) findViewById(R.id.AMOUNT);
        Comments = (TextView) findViewById(R.id.COMMENTS);
    }
    public void addTask(View view){

        book.setComments(Comments.getText().toString());

        Intent intent = new Intent(this,MainActivity.class);
        setResult(1,intent);
        finish();
    }

}



package com.example.aaron.yuntao1_subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private static final String FILENAME = "sub1.sav";
    private ListView oldBooks;
    private ArrayList<Book> Books;
    private ArrayAdapter<Book> adapter;
    private TextView monthTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycle ---->", "onCreate is called");
        setContentView(R.layout.activity_main);
        monthTotal = (TextView) findViewById(R.id.monthTotal);
        Button ADD = (Button) findViewById(R.id.ADD);

        oldBooks = (ListView) findViewById(R.id.OldBooks);
        registerForContextMenu(oldBooks);

    }

    @Override
    protected void onStart() {

        // TODO Auto-generated method stub
        super.onStart();
        Log.i("LifeCycle --->", "onStart is called");
        loadFromFile();

        adapter = new ArrayAdapter<Book>(this, R.layout.list_view, Books);

        oldBooks.setAdapter(adapter);
    }

    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2018-01-25
            Type listType = new TypeToken<ArrayList<Book>>() {
            }.getType();
            Books = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            Books = new ArrayList<Book>();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }


    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(Books, out);
            out.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, 0);
    }
    public void sentMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, 1);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

    }

}


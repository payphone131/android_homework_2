package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.b);
        editText = findViewById(R.id.et);

        List<It> itList = new ArrayList<>();
        for(int i = 1;i <= 100;i++){
            It itx = new It(String.valueOf(i));
            itList.add(itx);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(itList);
        recyclerView.setAdapter(myAdapter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String query = charSequence.toString();
                if(query != null){
                    List<It> itList = new ArrayList<>();
                    for(int j = 1;j <= 100;j++){
                        It itx = new It(String.valueOf(j));
                        if(String.valueOf(j).contains(charSequence))
                            itList.add(itx);
                    }
                    MyAdapter myAdapter = new MyAdapter(itList);
                    recyclerView.setAdapter(myAdapter);
                }
                else{
                    List<It> itList = new ArrayList<>();
                    for(int j = 1;j <= 100;j++){
                        It itx = new It(String.valueOf(j));
                        itList.add(itx);
                    }
                    MyAdapter myAdapter = new MyAdapter(itList);
                    recyclerView.setAdapter(myAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}
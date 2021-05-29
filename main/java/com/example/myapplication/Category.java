package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Category extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView text;
    Button savebtn;
    ListView listView;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        drawerLayout = findViewById(R.id.drawer_layout);
        text= findViewById(R.id.txt);
        savebtn= findViewById(R.id.savebutton);
        listView = findViewById(R.id.ListView);

        DB = new DbHelper(Category.this);

        arrayList = DB.getAllText();


        arrayAdapter = new ArrayAdapter(Category.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = text.getText().toString();
                if(!text1.isEmpty()){
                    if(DB.addtext(text1)){
                        text.setText("");
                        Toast.makeText(Category.this, "Data inserted..", Toast.LENGTH_SHORT).show();
                        arrayList.clear();
                        arrayList.addAll(DB.getAllText());
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                }


            }
        });
    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }


    public void ClickCategory(View view){
        MainActivity.redirectActivity(this,Category.class);
    }

    public void ClickContact(View view){
       recreate();
    }

    public void ClickContactList(View view){
        MainActivity.redirectActivity(this,ContactList.class);
    }


}
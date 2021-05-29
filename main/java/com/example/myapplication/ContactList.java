package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class ContactList extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        drawerLayout = findViewById(R.id.drawer_layout);
    }


    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }


    public void ClickCategory(View view){
        recreate();
    }

    public void ClickContact(View view){
        MainActivity.redirectActivity(this,Contact.class);
    }

    public void ClickContactList(View view){
        recreate();
    }

}
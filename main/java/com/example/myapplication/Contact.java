package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends AppCompatActivity {

    DrawerLayout drawerLayout;
    EditText firstName,lastName,mobileNum,email,category;
    Button saveBtn;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        drawerLayout = findViewById(R.id.drawer_layout);
        firstName= findViewById(R.id.firstnameEt);
        lastName= findViewById(R.id.lastnameEt);
        mobileNum= findViewById(R.id.numEt);
        email= findViewById(R.id.emailEt);
        category= findViewById(R.id.categoryEt);

        saveBtn= findViewById(R.id.button);
        DB = new DbHelper(this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname= firstName.getText().toString();
                String lname= lastName.getText().toString();
                Integer num= Integer.valueOf(mobileNum.getText().toString());
                String emailAdd= email.getText().toString();
                String categ= category.getText().toString();

//                Boolean checkinsertdata = DB.insertuserdata(fname,lname,num,emailAdd,categ);
//                if(checkinsertdata == true){
//                    Toast.makeText(Contact.this, "Hello", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(Contact.this,"Error",Toast.LENGTH_SHORT).show();
//                }

//                Cursor res = DB.getdata();
//                if(res.getCount()==0){
//                    Toast.makeText(Contact.this, "Error", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                StringBuffer buffer= new StringBuffer();
//                while (res.moveToNext()){
//                    buffer.append("Name" +res.getString(0));
//                }

                Intent intent = new Intent(getApplicationContext(),ContactList.class);
                startActivity(intent);
            }

        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Category.class);
                startActivity(intent);
            }
        });

    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }


    public void ClickCategory(View view){
        recreate();
    }

    public void ClickContact(View view){
        recreate();
    }

    public void ClickContactList(View view){
        MainActivity.redirectActivity(this,ContactList.class);
    }

}
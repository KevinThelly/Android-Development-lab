package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class tables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        TextView name, addr, dob, contact, gender, lang, email, timer, marriage;
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        addr = findViewById(R.id.addr);
        dob = findViewById(R.id.date);
        contact = findViewById(R.id.contact);
        gender = findViewById(R.id.gender);
        lang = findViewById(R.id.language);
        timer=findViewById(R.id.timer);
        marriage=findViewById(R.id.marriage);

        Toast.makeText(this, getIntent().getStringExtra("name"), Toast.LENGTH_SHORT).show();

        //getting data from the intent
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        addr.setText(getIntent().getStringExtra("addr"));
        dob.setText(getIntent().getStringExtra("dob"));
        gender.setText(getIntent().getStringExtra("gender"));
        lang.setText(getIntent().getStringExtra("lang"));
        contact.setText(getIntent().getStringExtra("contact"));
        marriage.setText(getIntent().getStringExtra("marriage"));
        timer.setText(getIntent().getStringExtra("Hour")+ ":"+getIntent().getStringExtra("Min"));


    }
}

package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText address;
    EditText email;
    EditText number;
    EditText dob;
    RadioButton rb1;
    RadioButton rb2;
    CheckBox ch1;
    CheckBox ch2;
    Button b1;
    Button b2;
    Button b3;
    RadioGroup rg;

    Button selectDate;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.et1);
        address=findViewById(R.id.et2);
        email=findViewById(R.id.et4);
        number=findViewById(R.id.et3);
        dob=findViewById(R.id.editText2);
        rb1=findViewById(R.id.radioButton1);
        rb2=findViewById(R.id.radioButton2);
        ch1=findViewById(R.id.checkBox);
        ch2=findViewById(R.id.checkBox1);
        b1=findViewById(R.id.btnDate);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        rg=findViewById(R.id.rg);

        selectDate = findViewById(R.id.btnDate);
        date = findViewById(R.id.editText2);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("");
                address.setText("");
                email.setText("");
                number.setText("");
                dob.setText("");
                rg.clearCheck();
                if(ch1.isChecked())
                        ch1.toggle();
                if(ch2.isChecked())
                        ch2.toggle();

                }
            });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lan = "";
                // get selected radio button from radioGroup
                int selectedId = rg.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton radioButton = (RadioButton) findViewById(selectedId);

                Intent i = new Intent(MainActivity.this, tables.class);
                i.putExtra("name",  name.getText().toString());
                i.putExtra("addr",address.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("dob",dob.getText().toString());
                i.putExtra("contact",number.getText().toString());
                i.putExtra("gender",radioButton.getText());
                if(ch1.isChecked()){
                    lan = lan+"English";
                }
                if (ch1.isChecked() && ch2.isChecked()){
                    lan = lan+", ";
                }
                if(ch2.isChecked()){
                    lan = lan+"Tamil";
                }
                i.putExtra("lang",lan);
//                Toast.makeText(MainActivity.this, name.getText(), Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        }
}









package com.scott.annie.login_spinner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    Button btn1,btn2;
    EditText edt1,edt2,edt3,edt4;
    Spinner sp1;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn1=(Button)findViewById(R.id.b1);
        btn2=(Button) findViewById(R.id.button);
        edt1=(EditText)findViewById(R.id.ed1);
        edt2=(EditText)findViewById(R.id.ed2);
        edt3=(EditText)findViewById(R.id.ed3);
        edt4=(EditText)findViewById(R.id.ed4);
        sp1=(Spinner)findViewById(R.id.spinner1);


        final String states[] = {"MADHYA PRADESH", "HARYANA", "UTTAR PRADESH", "ANDHRA PRADESH", "MAHARASHTRA", "KERALA"};

        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, states);
        sp1.setAdapter(arrayAdapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str1 = states[i];
                 Integer str_position=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(signup.this, "PLEASE SELECT AN OPTION", Toast.LENGTH_LONG).show();
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edt1.getText().toString().length()==0){
                    edt1.setError("username not entered");
                    edt1.requestFocus();
                }
                else if(edt2.getText().toString().length()==0){
                    edt2.setError("password not entered");
                    edt2.requestFocus();
                }
                else if(edt3.getText().toString().length()==0){
                    edt3.setError("City not entered");
                    edt3.requestFocus();
                }
                else if(edt4.getText().toString().length()==0){
                    edt3.setError("Phone number not entered");
                    edt3.requestFocus();
                }
                else {

                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_LONG).show();
                }

                String username= edt1.getText().toString();
                String password= edt2.getText().toString();
                String city=edt3.getText().toString();
                String phnumber=edt4.getText().toString();
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.putString("city",city);
                editor.putString("phonenumber",phnumber);
                editor.commit();

                Intent ob = new Intent(signup.this, third.class);
                startActivity(ob);


            }
        });

    }
}

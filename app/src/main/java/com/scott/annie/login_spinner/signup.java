package com.scott.annie.login_spinner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText name, mail, phone, city;
    Button submit;
    Spinner state;
    String state_string;
    Integer state_position;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.name1);
        mail = findViewById(R.id.mail1);
        phone = findViewById(R.id.phone1);
        city = findViewById(R.id.city1);
        state = findViewById(R.id.statespinner1);
        submit = findViewById(R.id.submit);

        final String states[] = {"Bihar", "Chhattisgarh", "Jharkhand", "Madhya Pradesh", "Odisha", "Rajasthan", "Uttar Pradesh"};

        preferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, states);
        state.setAdapter(arrayAdapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                state_string = states[i];
                state_position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(signup.this, "You haven't selected anything ! ", Toast.LENGTH_LONG).show();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(name.getText())) {

                    name.setError("username is required!");

                } else if (TextUtils.isEmpty(mail.getText())) {
                    mail.setError("mail is required!");

                } else if (TextUtils.isEmpty(city.getText())) {
                    city.setError("city is required!");

                } else if (TextUtils.isEmpty(phone.getText())) {
                    phone.setError("phone number is required!");

                } else {

                    Intent intent = new Intent(signup.this,third.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("mail", mail.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    intent.putExtra("state", state_string);
                    intent.putExtra("state_position", (state_position).toString());
                    intent.putExtra("city", city.getText().toString());
                    startActivity(intent);
                }

            }
        });

        name.setText(getIntent().getStringExtra("name2"));
        mail.setText(getIntent().getStringExtra("mail2"));
        phone.setText(getIntent().getStringExtra("phone2"));
        city.setText(getIntent().getStringExtra("city2"));
        state_position = getIntent().getIntExtra("string_position", 0);
        state.setSelection(state_position);

        String username = name.getText().toString();
        String email = mail.getText().toString();
        String city1 = city.getText().toString();
        String phnumber = phone.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("password", email);
        editor.putString("city", city1);
        editor.putString("phonenumber", phnumber);
        editor.commit();


    }
}



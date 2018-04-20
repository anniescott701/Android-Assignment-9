package com.scott.annie.login_spinner;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView usernm, pwd, city,phnum;
        SharedPreferences pref;

        usernm =  (TextView)findViewById(R.id.ed1);
        pwd=  (TextView)findViewById(R.id.ed2);
        city =  (TextView)findViewById(R.id.ed3);
        phnum =  (TextView)findViewById(R.id.ed4);
        pref=getSharedPreferences("pref", Context.MODE_PRIVATE);
        if (pref.contains("username")){
            usernm.setText(pref.getString("name","dafault"));
        }if (pref.contains("password")){
            pwd.setText(pref.getString("password","default"));
        }if (pref.contains("city")){
            city.setText(pref.getString("city","default"));
        }
            if (pref.contains("phonenumber")){
                phnum.setText(pref.getString("phonenumber","default"));
            }


    }
}


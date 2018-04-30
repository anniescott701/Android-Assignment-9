package com.scott.annie.login_spinner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class third extends AppCompatActivity {

    TextView name,mail,phone,state,city ;
    Button b1,b2,b3;
    Integer stringPostion;

    String data;
    private String Annie = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        name=findViewById(R.id.namelabel);
        mail=findViewById(R.id.maillabel);
        phone=findViewById(R.id.phonelabel);
        state=findViewById(R.id.statelabel);
        city=findViewById(R.id.citylabel);
        b1=findViewById(R.id.submitback);
        b2=findViewById(R.id.savebtn);
        b3=findViewById(R.id.readbtn);
        stringPostion=Integer.parseInt(getIntent().getStringExtra("state_position"));

        Log.d("TEST",stringPostion+"");
        name.setText(getIntent().getStringExtra("name"));
        mail.setText(getIntent().getStringExtra("mail"));
        phone.setText(getIntent().getStringExtra("phone"));
        state.setText(getIntent().getStringExtra("state"));
        city.setText(getIntent().getStringExtra("city"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(third.this,signup.class);
                intent.putExtra("name2",name.getText().toString());
                intent.putExtra("mail2",mail.getText().toString());
                intent.putExtra("phone2",phone.getText().toString());
                intent.putExtra("city2",city.getText().toString());
                intent.putExtra("string_position",stringPostion);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=data + "," + name.getText().toString();
                data=data + "," + mail.getText().toString();
                data=data + "," + city.getText().toString();
                data=data + "," + phone.getText().toString();

                try {
                    FileOutputStream fOut = openFileOutput(Annie,MODE_WORLD_WRITEABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(Annie);
                    int c;
                    String temp="";
                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    name.setText(temp);
                    city.setText(temp);
                    mail.setText(temp);
                    phone.setText(temp);

                    Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
            }

        });
    }

    }


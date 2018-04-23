package com.scott.annie.login_spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class third extends AppCompatActivity {

    TextView name,mail,phone,state,city;
    Button back;
    Integer stringPostion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        name=findViewById(R.id.namelabel);
        mail=findViewById(R.id.maillabel);
        phone=findViewById(R.id.phonelabel);
        state=findViewById(R.id.statelabel);
        city=findViewById(R.id.citylabel);
        back=findViewById(R.id.submitback);
        stringPostion=Integer.parseInt(getIntent().getStringExtra("state_position"));

        Log.d("TEST",stringPostion+"");
        name.setText(getIntent().getStringExtra("name"));
        mail.setText(getIntent().getStringExtra("mail"));
        phone.setText(getIntent().getStringExtra("phone"));
        state.setText(getIntent().getStringExtra("state"));
        city.setText(getIntent().getStringExtra("city"));

        back.setOnClickListener(new View.OnClickListener() {
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

    }
}

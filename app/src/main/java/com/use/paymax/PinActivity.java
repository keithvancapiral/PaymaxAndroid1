package com.use.paymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PinActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);


       final EditText eTPin1 = findViewById(R.id.eTPin1);
        Button btnPin =findViewById(R.id.btnPin);

        final String pin1 = eTPin1.getText().toString();


        btnPin.setOnClickListener(new View.OnClickListener(){


              @Override
              public void onClick(View v) {



                      Intent intent = new Intent(PinActivity.this, ListActivity.class);
                      startActivity(intent);

                  }

          });



    }
}

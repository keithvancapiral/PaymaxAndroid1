package com.use.paymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElectricityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        Button btnElectricity = findViewById(R.id.btnMeralco2);


        btnElectricity.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



                Intent intent = new Intent(ElectricityActivity.this, MeralcoActivity.class);
                startActivity(intent);

            }

        });



    }
}

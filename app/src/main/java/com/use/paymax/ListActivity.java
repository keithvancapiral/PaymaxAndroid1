package com.use.paymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button btnBP = (Button) findViewById(R.id.BillsPayments);


        btnBP.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



                Intent intent = new Intent(ListActivity.this, BillPaymentsActivity.class);
                startActivity(intent);

            }

        });


    }
}

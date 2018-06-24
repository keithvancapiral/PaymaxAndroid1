package com.use.paymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BillPaymentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payments);
        
        Button button =(Button) findViewById(R.id.button12);



         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 Intent intent = new Intent(BillPaymentsActivity.this, ElectricityActivity.class);
                 startActivity(intent);


             }
         });


    }

}

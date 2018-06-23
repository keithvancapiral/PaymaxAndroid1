package com.use.paymax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PrintActivity extends AppCompatActivity {

    TextView accNum,amtPesos,confeee,pay,con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);


        accNum =  findViewById(R.id.accNumber);
        amtPesos =  findViewById(R.id.AmountPesos);
        confeee =  findViewById(R.id.ConFee);
        pay =  findViewById(R.id.PayFor);
        con =  findViewById(R.id.ConNumber);

        String accountNumber = getIntent().getStringExtra("accountNumber");
        String amountPesos = getIntent().getStringExtra("amountPesos");
        String conFee = getIntent().getStringExtra("conFee");
        String payFor = getIntent().getStringExtra("payFor");
        String conNumber = getIntent().getStringExtra("contactNumber");


        accNum.setText(accountNumber);
        amtPesos.setText(amountPesos);
        confeee.setText(conFee);
        pay.setText(payFor);
        con.setText(conNumber);





    }
}

package com.use.paymax;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MeralcoActivity extends AppCompatActivity {
    EditText AccountNumber,AmountPesos,ConvinienceFee,PayFor,ContactNumber;
    Button Submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meralco);



        AccountNumber = findViewById(R.id.AccountNumber);
        AmountPesos = findViewById(R.id.AmountPesos);
        ConvinienceFee =findViewById(R.id.ConvinienceFee);
        PayFor =findViewById(R.id.PayFor);
        ContactNumber = findViewById(R.id.ContactNumber);
        Submit  = findViewById(R.id.Submit);

        final  String accountNumber = AccountNumber.getText().toString();
        final String amountPesos = AmountPesos.getText().toString();
        final String conFee = ConvinienceFee.getText().toString();
        final String payFor = PayFor.getText().toString();
        final String contactNumber = ContactNumber.getText().toString();



        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MeralcoActivity.this);
                builder.setCancelable(false);
                builder.setTitle("MERALCO");

                builder.setMessage("Are you sure to continue?");
                builder.setPositiveButton("APPROVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Intent intent = new Intent(MeralcoActivity.this, PrintActivity.class);
                        intent.putExtra("accountNumber", accountNumber);
                        intent.putExtra("amountPesos",amountPesos);
                        intent.putExtra("conFee", conFee);
                        intent.putExtra("payFor", payFor);
                        intent.putExtra("contactNumber", contactNumber);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();




            }
        });














    }
}

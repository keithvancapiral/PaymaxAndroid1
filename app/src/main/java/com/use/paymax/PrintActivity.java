package com.use.paymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.telpo.tps550.api.TelpoException;
import com.telpo.tps550.api.printer.UsbThermalPrinter;

public class PrintActivity extends AppCompatActivity {
    UsbThermalPrinter myprinter = new UsbThermalPrinter(PrintActivity.this);
    private int leftDistance = 1;
    private int lineDistance = 1;
    String accountNumber,amountPesos,conNumber,conFee,payFor,RecieptString;
    TextView accNum,amtPesos,confeee,pay,con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);


        accNum =  (TextView) findViewById(R.id.accNumber);
        amtPesos = (TextView) findViewById(R.id.AmountPesos);
        confeee = (TextView) findViewById(R.id.ConFee);
        pay = (TextView) findViewById(R.id.PayFor);
        con = (TextView) findViewById(R.id.ConNumber);
        Intent inten= getIntent();
        accountNumber = inten.getExtras().getString("accountNumber");
        amountPesos = inten.getExtras().getString("amountPesos");
        conFee = inten.getExtras().getString("conFee");
        payFor = inten.getExtras().getString("payFor");
        conNumber = inten.getExtras().getString("contactNumber");
        RecieptString = "========================================="+accountNumber+"\n"+"\n";
        RecieptString += "Account Number : "+accountNumber+"\n"+"\n";
        RecieptString += "Amount in Pesos :"+amountPesos+"\n"+"\n";
        RecieptString += "Convenience Fee :"+conFee+"\n"+"\n";
        RecieptString += "Pay For :         "+payFor+"\n"+"\n";
        RecieptString += "Customer Numer:  "+conNumber+"\n"+"\n";
        RecieptString += "========================================="+accountNumber+"\n"+"\n";

        Toast.makeText(this, RecieptString, Toast.LENGTH_SHORT).show();


        accNum.setText(accountNumber);
        amtPesos.setText(amountPesos);
        confeee.setText(conFee);
        pay.setText(payFor);
        con.setText(conNumber);

        Button btnReciept = (Button) findViewById(R.id.printReciept);
        btnReciept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new contentPrintThread().start();
            }
        });
    }
    private class contentPrintThread extends Thread {
        public void run() {
            super.run();
            try {

//                    myprinter.start(0);
                myprinter.reset();
                Log.d("hello", "run: 1");

                myprinter.setAlgin(UsbThermalPrinter.ALGIN_LEFT);
                myprinter.setLeftIndent(leftDistance);
                myprinter.setLineSpace(lineDistance);
                myprinter.setFontSize(1);
                myprinter.setGray(1);
//                Integer che = myprinter.checkStatus();
//                Log.d("check", "che" + String.valueOf(che));
                myprinter.addString(RecieptString);
                Log.d("heyssss", "run: 8");
                myprinter.printString();
                Log.d("heysssss", "run: 9");
                myprinter.walkPaper(20);
            } catch (TelpoException e) {
                e.printStackTrace();

                Log.d("Telpo", "run: "+e.getCause());

            } catch (Exception e) {
                e.printStackTrace();
                if (e.toString().equals("com.telpo.tps550.api.printer.NoPaperException")) {
                    Log.d("asd", "no paper");

                } else if (e.toString().equals("com.telpo.tps550.api.printer.OverHeatException")) {
                    Log.d("asd", "overheat");

                } else {
                    Log.d("asd", "printer");
                }
            }
        }
    }

}

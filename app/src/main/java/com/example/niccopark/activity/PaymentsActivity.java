package com.example.niccopark.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.niccopark.R;

import org.w3c.dom.Text;

public class PaymentsActivity extends AppCompatActivity {

    private Button payBtn;
    private TextView statusTxt;
    private TextView numberOfTickets;
    private EditText upiId;
    private Button incrementBtn;
    private Button decrementBtn;
    private int tickets;
    private int totalAmt = 0;
    private TextView totalAmtTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        statusTxt = findViewById(R.id.status_txt);
        payBtn = findViewById(R.id.pay_btn);
        upiId = findViewById(R.id.upi);
        numberOfTickets = findViewById(R.id.number_of_tickets);
        totalAmtTxt = findViewById(R.id.total_amount_txt);
        incrementBtn = findViewById(R.id.increment_btn);
        decrementBtn = findViewById(R.id.decrement_btn);
        payBtn.setOnClickListener(v->{
            if(!isEmpty(upiId.getText().toString()) && tickets > 0){
                statusTxt.setText("Payment successfully done! You will receive the tickets through email within 24 hours. Press back button to go back to the home screen.");
                statusTxt.setTextColor(getColor(R.color.colorPrimary));
            }else{
                statusTxt.setText("Make sure you enter the above details correctly.");
                statusTxt.setTextColor(getColor(R.color.colorAccent));
            }
        });

        incrementBtn.setOnClickListener(v->{
            tickets++;
            totalAmt = (tickets*10);
            numberOfTickets.setText(tickets + " tickets");
            totalAmtTxt.setText("Total = Rs "+totalAmt);
        });
        decrementBtn.setOnClickListener(v->{
            tickets--;
            if(tickets < 0){
                tickets = 0;
            }
            totalAmt = (tickets*10);
            numberOfTickets.setText(tickets +" tickets");
            totalAmtTxt.setText("Total = Rs "+totalAmt);
        });
    }

    private boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

}

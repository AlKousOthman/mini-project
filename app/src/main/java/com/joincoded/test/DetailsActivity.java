package com.joincoded.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.joincoded.test.Transactions.Transaction;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent.hasExtra("transaction")) {
            Transaction transaction = intent.getParcelableExtra("transaction");
            displayTransactionDetails(transaction);
        }
    }

    private void displayTransactionDetails(Transaction transaction) {
        TextView textViewId = findViewById(R.id.textViewTransactionId);
        TextView textViewDate = findViewById(R.id.textViewTransactionDate);
        TextView textViewType = findViewById(R.id.textViewTransactionType);
        TextView textViewAmount = findViewById(R.id.textViewTransactionAmount);
        TextView textViewBalance = findViewById(R.id.textViewTransactionBalance);
        TextView textViewAccount = findViewById(R.id.textViewTransactionAccount);

        textViewId.setText(" Transaction ID: " + transaction.getId());
        textViewDate.setText("Date: " + transaction.getDate());
        textViewType.setText("Transaction Type: " + transaction.getType());
        textViewAmount.setText("Amount: " + transaction.getFormattedAmount());
        textViewBalance.setText("Balance: " + transaction.getFormattedBalance());
        textViewAccount.setText("Account: " + transaction.getFormattedAccount());
    }
}
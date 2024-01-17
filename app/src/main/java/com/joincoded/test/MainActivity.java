package com.joincoded.test;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.joincoded.test.Adapters.TransactionAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.recyclerViewMain);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        List<Transaction> transactions = generateSampleTransactions();
        adapter = new TransactionAdapter(transactions);
        recyclerViewMain.setAdapter(adapter);
    }

@Override
public void onItemClick(Transaction transaction){
        Intent intent = new Intent(TransactionListActivity.this, TransactionDetailActivity.this);
        intent.putExtra("Transaction", (CharSequence) transaction);
        startActivity(intent);
}
    public void openTransactionsList(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private List<Transaction> generateSampleTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(13, "2024-01-15", "WITHDRAWAL", 100.00, 1250.00, 1234));
        transactions.add(new Transaction(23, "2024-01-16", "DEBIT", 150.00, 1400.00, 5678));
        transactions.add(new Transaction(33, "2024-01-13", "CREDIT", 50.00, 1350.00, 9876));

        return transactions;
    }


    private void openTransactionDetails(Transaction transaction) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("transaction", (CharSequence) transaction);
        startActivity(intent);
    }
}



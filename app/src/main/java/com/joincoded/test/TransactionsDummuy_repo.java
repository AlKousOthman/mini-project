package com.joincoded.test;

import java.util.ArrayList;
import java.util.List;

public class TransactionsDummuy_repo {

    private List<Transaction> generateSampleTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(13, "2024-01-15", "WITHDRAWAL", 100.00, 1250.00, 1234));
        transactions.add(new Transaction(23, "2024-01-16", "DEBIT", 150.00, 1400.00, 5678));
        transactions.add(new Transaction(33, "2024-01-13", "CREDIT", 50.00, 1350.00, 9876));

        return transactions;
    }



}

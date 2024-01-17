package com.joincoded.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import kotlin.jvm.internal.SerializedIr;

public class Transaction implements SerializedIr {

    private int id;
    private String date;
    private double amount;
    private double balance;

    private int account;

    private TransactionType type;

    public Transaction(int id, String date, String type, double amount, double balance, int account) {
        this.id = id;
        this.date = date;
        this.type = TransactionType.valueOf(type);
        this.amount = amount;
        this.balance = balance;
        this.account = account;
    }


    public int getId() {
        return id;
    }
    public String getDate() {
        return formatDate(date);
    }

    public TransactionType getType() {
        return type;
    }

    public String getFormattedAmount() {
        return formatCurrency(amount);
    }

    public String getFormattedBalance() {
        return formatCurrency(balance);
    }

    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault());
            Date date = inputFormat.parse(dateStr);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateStr;
        }
    }

    private String formatCurrency(double value) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return currencyFormat.format(value);
    }

    public String getFormattedAccount() {
        return formatCurrency(account);
    }



}

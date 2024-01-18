package com.joincoded.test.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joincoded.test.R;
import com.joincoded.test.TransactionItemClickListener;
import com.joincoded.test.Transactions.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private List<Transaction> transactions;
    private TransactionItemClickListener transactionListener ;

    public TransactionAdapter(List<Transaction> transactions, TransactionItemClickListener transactionListener) {
        this.transactions = transactions;
        this.transactionListener=transactionListener;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_card, parent, false);
        return new TransactionViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.bind(transaction);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionListener.onItemClick(transaction);
            }
        });

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    static class TransactionViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDate;
        TextView textViewType;
        TextView textViewAmount;
        TextView textViewBalance;
        TextView textViewId;
        TextView textViewAccount;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewType = itemView.findViewById(R.id.textViewType);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            textViewBalance = itemView.findViewById(R.id.textViewBalance);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewAccount = itemView.findViewById(R.id.textViewAccount);
        }
        public void bind(Transaction transaction) {
        }
    }
}



package com.joincoded.test.Adapters;

import android.content.Context;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joincoded.test.OnClick;
import com.joincoded.test.R;
import com.joincoded.test.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private List<Transaction> transactions;

    public TransactionAdapter(List<Transaction> transactions) {
        this.transactions = transactions;
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
                if (onItemClickListener != null ){
                    onItemClickListener.onItemClick(transaction);


                }
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
Intet intet = getIntent();
        if (intent != null && intent.hasExtra("Transaction")){
            Transaction transaction = (Transaction) intent.getSerializableExtra("Transaction")
            assert  transaction != null;
            openTransactionDetails(transactions);
        }
        public void bind(Transaction transaction) {
        }
    }
}



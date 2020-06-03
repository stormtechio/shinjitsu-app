package com.example.shinjitsu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.entities.PaymentEntity;

import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.MyViewHolder> {

    List<PaymentEntity> payments;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            cardView = itemView.findViewById(R.id.cardview_payments);
        }
    }

    public PaymentAdapter(List<PaymentEntity> payments) {

        this.payments = payments;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  =  LayoutInflater.from(parent.getContext()).inflate(R.layout.payments_cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Context context = holder.cardView.getContext();
        holder.name.setText(payments.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return payments.size();
    }



}

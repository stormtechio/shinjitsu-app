package com.example.shinjitsu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            cardView = itemView.findViewById(R.id.cardview_payments);
            imageView = itemView.findViewById(R.id.imageview_shape);
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
        PaymentEntity payment = payments.get(position);

        holder.name.setText(payment.getName());

        if(payment.isStatus()){
            holder.imageView.setImageResource(R.drawable.green_shape);
        }else{
            holder.imageView.setImageResource(R.drawable.red_shape);
        }


    }

    @Override
    public int getItemCount() {
        return payments.size();
    }

}

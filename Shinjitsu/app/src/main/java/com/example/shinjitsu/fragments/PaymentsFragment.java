package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.adapters.PaymentAdapter;
import com.example.shinjitsu.entities.PaymentEntity;

import java.util.ArrayList;
import java.util.List;

public class PaymentsFragment extends Fragment{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    PaymentEntity paymentEntity = new PaymentEntity();
    PaymentEntity paymentEntity2 = new PaymentEntity();
    PaymentEntity paymentEntity3 = new PaymentEntity();
    PaymentEntity paymentEntity4 = new PaymentEntity();
    List<PaymentEntity> payments = new ArrayList<PaymentEntity>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        paymentEntity.setName("Saori");
        paymentEntity2.setName("Ayrton");
        paymentEntity3.setName("Luna");
        paymentEntity4.setName("Einstein");

        payments.add(paymentEntity);
        payments.add(paymentEntity2);
        payments.add(paymentEntity3);
        payments.add(paymentEntity4);

        final View paymentsView = inflater.inflate(R.layout.payments_fragment, container, false);
        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new PaymentAdapter(payments);
        recyclerView.setAdapter(mAdapter);

        return paymentsView;
    }

}
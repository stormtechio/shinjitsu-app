package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.adapters.PaymentAdapter;
import com.example.shinjitsu.collections.ReverseByName;
import com.example.shinjitsu.collections.SortByName;
import com.example.shinjitsu.entities.PaymentEntity;

import java.util.ArrayList;
import java.util.Collections;
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
    Spinner filterSpinner;
    Spinner paySpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        paymentEntity.setName("Saori");
        paymentEntity2.setName("Ayrton");
        paymentEntity3.setName("Luna");
        paymentEntity4.setName("Einstein");

        paymentEntity.setStatus(true);
        paymentEntity2.setStatus(false);
        paymentEntity3.setStatus(true);
        paymentEntity4.setStatus(true);

        payments.add(paymentEntity);
        payments.add(paymentEntity2);
        payments.add(paymentEntity3);
        payments.add(paymentEntity4);

        final View paymentsView = inflater.inflate(R.layout.payments_fragment, container, false);

        filterSpinner = paymentsView.findViewById(R.id.filter_spinner);
        paySpinner = paymentsView.findViewById(R.id.filter_pay_spinner);



        adapterFilter();
        adapterPay();

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        mAdapter = new PaymentAdapter(payments);
                        recyclerView.setAdapter(mAdapter);
                        break;
                    case 1:
                        Collections.sort(payments, new SortByName());
                        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        mAdapter = new PaymentAdapter(payments);
                        recyclerView.setAdapter(mAdapter);
                        break;
                    case 2:
                        Collections.sort(payments, new ReverseByName());
                        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        mAdapter = new PaymentAdapter(payments);
                        recyclerView.setAdapter(mAdapter);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        
        paySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i){
                    case 0:
                        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        mAdapter = new PaymentAdapter(payments);
                        recyclerView.setAdapter(mAdapter);
                        break;
                    case 1:
                       //payments.remove(i).isStatus();
                        ArrayList<PaymentEntity> pay = new ArrayList<>();

                        for (PaymentEntity p: payments) {
                            if(p.isStatus()){
                                pay.add(p);
                            }

                        }

                        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        mAdapter = new PaymentAdapter(pay);
                        recyclerView.setAdapter(mAdapter);
                        break;

                    case 2:
                        ArrayList<PaymentEntity> notPay = new ArrayList<>();

                        for (PaymentEntity p: payments) {
                            if(!p.isStatus()){
                                notPay.add(p);
                            }
                        }
                        recyclerView = paymentsView.findViewById(R.id.recycler_view_payments);
                        recyclerView.setHasFixedSize(true);
                        layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        mAdapter = new PaymentAdapter(notPay);
                        recyclerView.setAdapter(mAdapter);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        return paymentsView;
    }

    private void adapterFilter(){

        ArrayAdapter<CharSequence> adapterFilter = ArrayAdapter.createFromResource(getContext(),
                R.array.order_array, android.R.layout.simple_spinner_item);
        adapterFilter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(adapterFilter);
    }

    private void adapterPay(){

        ArrayAdapter<CharSequence> adapterPay = ArrayAdapter.createFromResource(getContext(),
                R.array.pay_array, android.R.layout.simple_spinner_item);
        adapterPay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paySpinner.setAdapter(adapterPay);
    }
}




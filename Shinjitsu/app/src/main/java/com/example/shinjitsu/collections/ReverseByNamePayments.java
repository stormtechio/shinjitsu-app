package com.example.shinjitsu.collections;

import com.example.shinjitsu.entities.PaymentEntity;

import java.util.Comparator;

public class ReverseByNamePayments implements Comparator<PaymentEntity> {

    @Override
    public int compare(PaymentEntity paymentEntity, PaymentEntity t1) {
        return t1.getName().compareTo(paymentEntity.getName());
    }

}

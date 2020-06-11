package com.example.shinjitsu.collections;

import com.example.shinjitsu.entities.PaymentEntity;

import java.util.Comparator;

public class SortByName implements Comparator<PaymentEntity> {

    @Override
    public int compare(PaymentEntity paymentEntity, PaymentEntity t1) {
        return paymentEntity.getName().compareTo(t1.getName());
    }

}

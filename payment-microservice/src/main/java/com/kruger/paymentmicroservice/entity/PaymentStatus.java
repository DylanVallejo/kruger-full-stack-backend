package com.kruger.paymentmicroservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentStatus {

    ERROR_PAYMENT("error_payment"),
    MADE_PAYMENT("made_payment"),
    ACCEPTED_PAYMENT("accepted_payment"),
    RETURNED_PAYMENT("payment_returned"),
    IN_PROGRESS("in_progress");
    private final String status;
}

package com.arch.intern.crm.backend.order.model.enums;

import lombok.ToString;

@ToString
public enum OrderStatus {
    NEW,
    PREPARE,
    DELIVERY,
    DONE;
}

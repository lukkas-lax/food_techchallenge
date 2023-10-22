package com.fiap.food_techchallenge.domain.enums;

public enum OrderStatus {
    RECEIVED(1),
    IN_PREPARATION(2),
    READY(3),
    COMPLETED(4);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid order status code");
    }
}
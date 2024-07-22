package org.halitkalayci.common.events;

public class OrderCreatedEvent {
    private int id;
    private String customerName;

    public OrderCreatedEvent(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public OrderCreatedEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

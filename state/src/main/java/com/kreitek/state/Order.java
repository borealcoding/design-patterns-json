package com.kreitek.state;

public class Order {
    private final String orderId;
    private OrderState state = new OrderedState();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void prepare() throws OperationNotAllowedException {
        state.prepare(this);
        System.out.println("Prepare order " + orderId);
    }

    public void deliver() throws OperationNotAllowedException {
        state.deliver(this);
        System.out.println("deliver order " + orderId);
    }

    public void cancel() throws OperationNotAllowedException {
        state.cancel(this);
        System.out.println("Cancel order " + orderId);
    }
}

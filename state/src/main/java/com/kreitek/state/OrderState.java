package com.kreitek.state;

public interface OrderState {
    void prepare(Order order) throws OperationNotAllowedException;
    void deliver(Order order) throws OperationNotAllowedException;
    void cancel(Order order) throws OperationNotAllowedException;
}

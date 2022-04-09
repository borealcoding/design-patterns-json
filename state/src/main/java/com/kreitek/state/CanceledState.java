package com.kreitek.state;

public class CanceledState implements OrderState {
    @Override
    public void prepare(Order order) throws OperationNotAllowedException {
        throw new OperationNotAllowedException();
    }

    @Override
    public void deliver(Order order) throws OperationNotAllowedException {
        throw new OperationNotAllowedException();
    }

    @Override
    public void cancel(Order order) throws OperationNotAllowedException {
        throw new OperationNotAllowedException();
    }
}

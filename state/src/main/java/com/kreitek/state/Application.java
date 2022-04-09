package com.kreitek.state;

public class Application {

    public static void main(String[] args) {

        Order order = new Order("123");
        try {
            order.prepare();
            order.deliver();
        } catch (OperationNotAllowedException e) {
            e.printStackTrace();
        }

        Order badOrder = new Order("456");
        try {
            badOrder.prepare();
            badOrder.cancel();
            badOrder.deliver();
        } catch (OperationNotAllowedException e) {
            e.printStackTrace();
        }

    }
}

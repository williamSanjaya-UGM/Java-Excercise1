package orderInsertion;

import java.io.Serializable;

public class OrderList implements Serializable {
    private String orderName;
    private int orderQty;

    public OrderList(){};
    public OrderList(String orderName, int orderQty) {
        this.orderName = orderName;
        this.orderQty = orderQty;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "orderName='" + orderName + '\'' +
                ", orderQty=" + orderQty +
                '}';
    }
}

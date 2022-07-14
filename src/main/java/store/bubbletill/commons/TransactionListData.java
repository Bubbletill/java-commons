package store.bubbletill.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionListData {

    private int utid;
    private int store;
    private int register;
    private String date;
    private String time;
    private int trans;
    private TransactionType type;
    private String oper;
    private List<StockData> basket;
    private List<String> data;
    private double total;
    private HashMap<PaymentType, Double> methods;

    public int getUtid() {
        return utid;
    }

    public int getStore() {
        return store;
    }

    public int getRegister() {
        return register;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDateTime() {
        return date + " " + time;
    }

    public int getTrans() {
        return trans;
    }

    public TransactionType getType() {
        return type;
    }

    public String getOper() {
        return oper;
    }

    public List<StockData> getBasket() { return basket; }

    public List<String> getData() { return data; }

    public double getTotal() {
        return total;
    }

    public HashMap<PaymentType, Double> getMethods() { return methods; }
}

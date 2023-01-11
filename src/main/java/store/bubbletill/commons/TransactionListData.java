package store.bubbletill.commons;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionListData {

    @Getter private int utid;
    @Getter private int store;
    @Getter private int register;
    @Getter private String date;
    @Getter private String time;
    @Getter private int trans;
    @Getter private TransactionType type;
    @Getter private String oper;
    @Getter private List<StockData> basket;
    @Getter private List<String> data;
    @Getter private double total;
    @Getter private HashMap<PaymentType, Double> methods;


    public String getDateTime() {
        return date + " " + time;
    }

}

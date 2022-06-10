package store.bubbletill.commons;

public class TransactionListData {

    private int utid;
    private int store;
    private int register;
    private String date;
    private String time;
    private int trans;
    private TransactionType type;
    private String oper;
    private String items;
    private double total;
    private PaymentType primary_method;

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

    public String getItems() {
        return items;
    }
    public void setItems(String items) {this.items = items;}

    public double getTotal() {
        return total;
    }

    public PaymentType getPrimary_method() {
        return primary_method;
    }
}

package store.bubbletill.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {

    // Details
    private int id;
    private long time;
    private boolean voided;
    private TransactionType overrideTransType;

    private HashMap<String, String> managerActions;

    // Basket
    private List<StockData> basket;
    private HashMap<PaymentType, Double> tender;

    private List<String> dataLogs;

    public Transaction(int id) {
        this.id = id;
        time = System.currentTimeMillis() / 1000L;
        basket = new ArrayList<>();
        tender = new HashMap<>();
        managerActions = new HashMap<>();
        dataLogs = new ArrayList<>();
        voided = false;
    }

    public int getId() {
        return id;
    }
    public long getTime() {return time;}

    public List<StockData> getBasket() {
        return basket;
    }

    public void setBasket(List<StockData> basket) {
        this.basket = basket;
    }
    public void addToBasket(StockData stockData) {
        basket.add(stockData);
        log("" + stockData.getCategory() + " " + stockData.getItemCode() + " - £" + Formatters.decimalFormatter.format(stockData.getPriceWithReduction()));
    }

    public double getBasketSubTotal() {
        double total = 0.0;
        for (StockData sd : basket) {
            total += sd.getPrice();
        }

        return total;
    }

    public double getBasketTotal() {
        double total = 0.0;
        for (StockData sd : basket) {
            total += sd.getPrice() - sd.getPriceReduction();
        }

        return total;
    }

    public void log(String string) {
        dataLogs.add(string);
    }

    public List<String> getLogs() { return dataLogs; }
    public void setLogs(List<String> dataLogs) {
        this.dataLogs = dataLogs;
        if (this.dataLogs == null)
            this.dataLogs = new ArrayList<>();
    }

    public void addTender(PaymentType paymentType, double amount) {
        if (!tender.containsKey(paymentType)) {
            tender.put(paymentType, amount);
            log("TOTAL £" + Formatters.decimalFormatter.format(getBasketTotal()));
            log("TENDER " + paymentType + " of £" + Formatters.decimalFormatter.format(amount));
            return;
        }

        double current = tender.get(paymentType);
        tender.put(paymentType, current + amount);

        log("TENDER " + paymentType + " of £" + Formatters.decimalFormatter.format(amount));
    }

    public HashMap<PaymentType, Double> getTender() {return tender;}
    public void voidTender() {
        tender.clear();
        log("TENDER VOIDED");
    }

    public double getTenderTotal() {
        double total = 0;
        for (Map.Entry<PaymentType, Double> e : tender.entrySet()) {
            total += e.getValue();
        }

        return total;
    }
    public double getRemainingTender() {return getBasketTotal() - getTenderTotal();}

    public boolean isTenderComplete() { return getTenderTotal() >= getBasketTotal(); }

    public PaymentType getPrimaryTender() {
        PaymentType highest = PaymentType.VOID;
        double highestValue = 0;
        for (Map.Entry<PaymentType, Double> e : tender.entrySet()) {
            if (e.getValue() > highestValue) {
                highest = e.getKey();
                highestValue = e.getValue();
            }
        }

        return highest;
    }

    public boolean isVoided() { return voided; }
    public void setVoided(boolean voided) { this.voided = voided; }

    public void addManagerAction(String actionId, String operId) {
        managerActions.put(actionId, operId);
        log(operId + " authorised " + actionId);
    }
    public HashMap<String, String> getManagerActions() { return managerActions; }

    public void overrideTransType(TransactionType type) {
        overrideTransType = type;
    }

    public TransactionType determineTransType() {
        if (overrideTransType != null)
            return overrideTransType;

        if (voided)
            return TransactionType.VOID;

        boolean hasSale = false;
        boolean hasRefund = false;
        for (StockData item : basket) {
            if (item.isRefund())
                hasRefund = true;
            else
                hasSale = true;
        }

        if (!hasSale & hasRefund)
            return TransactionType.REFUND;
        else if (hasSale & hasRefund)
            return TransactionType.EXCHANGE;
        else
            return TransactionType.SALE;
    }
}
